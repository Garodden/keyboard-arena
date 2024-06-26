package com.example.KeyboardArenaProject.dto.user;


import com.example.KeyboardArenaProject.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserTopBarInfo {
    String nickname;
    String id;
    String userId;
    int rank;
    int point;
    public UserTopBarInfo(User user){
        this.nickname = user.getNickname();
        this.id = user.getId();
        this.userId = user.getUserId();
        this.rank = user.getUserRank();
        this.point = user.getPoint();
    }
}
