package com.example.KeyboardArenaProject.service.user;

import com.example.KeyboardArenaProject.entity.Cleared;
import com.example.KeyboardArenaProject.entity.compositeKey.UserBoardCompositeKey;
import com.example.KeyboardArenaProject.repository.ClearedRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

@Service
public class ClearedService {
    ClearedRepository clearedRepository;

    public ClearedService(ClearedRepository clearedRepository) {
        this.clearedRepository = clearedRepository;
    }
    public int findParticipatesByBoardId(String boardId){
        return clearedRepository.findAllByCompositeId_BoardId(boardId).size();
    }
    //클리어한 유저 데이터가 존재하는지
    public boolean findIfUserClearDataExists(UserBoardCompositeKey id){
        return clearedRepository.ifClearedById(id);
    }

    public boolean findIfUserDataExists(UserBoardCompositeKey id){
        return clearedRepository.findByCompositeId(id)!=null;
    }
    //챌린지 시작 시간 기록

    public void saveCleared(String userId, String boardId) {
        Cleared newCleared = Cleared.builder()
                .id(userId)
                .boardId(boardId)
                .tries(0)
                .startTime(LocalDateTime.now())
                .build();
        clearedRepository.save(newCleared);
    }


    public List<Cleared> findAllByBoardId(String boardId){
        return clearedRepository.findAllByCompositeId_BoardIdOrderByClearTimeAsc(boardId);
    }

    public int findRanking(List<Cleared> clearedList, String id){
        OptionalInt indexOptional = IntStream.range(0, clearedList.size())
                .filter(i -> clearedList.get(i).getId().equals(id))
                .findFirst();
        if (indexOptional.isPresent()){
            return indexOptional.getAsInt()+1;
        }
        else{
            return 0;
        }
    }

    @Transactional
    public void updateStartTime(UserBoardCompositeKey curUsersClearRecord) {
        Cleared clearedData = clearedRepository.findByCompositeId(curUsersClearRecord);
        clearedData.updateStartTime();
    }

    @Transactional
    public LocalTime updateClearTime(UserBoardCompositeKey curUsersClearRecord){
        Cleared clearedData = clearedRepository.findByCompositeId(curUsersClearRecord);
        return clearedData.updateClearTime();
    }

    public Long getOnlyClearTime(UserBoardCompositeKey compositeKey){

        Cleared curCleared = clearedRepository.findByCompositeId(compositeKey);
        LocalDateTime startTime = curCleared.getStartTime();

        Duration duration = Duration.between(startTime, LocalDateTime.now());
        return duration.getSeconds();

    }
    public Cleared findByCompositeId(UserBoardCompositeKey id) {
        return clearedRepository.findByCompositeId(id);
    }
}
