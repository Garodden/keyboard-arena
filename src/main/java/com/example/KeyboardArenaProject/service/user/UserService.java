package com.example.KeyboardArenaProject.service.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.KeyboardArenaProject.dto.user.AddUserRequest;
import com.example.KeyboardArenaProject.entity.User;
import com.example.KeyboardArenaProject.repository.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;
	private BCryptPasswordEncoder encoder;

	public UserService(UserRepository userRepository, BCryptPasswordEncoder encoder) {
		this.userRepository = userRepository;
		this.encoder = encoder;
	}

	public User save(AddUserRequest dto) {
		return userRepository.save(
			//builder 패턴 적용 필요
			// User.builder()
			// 	.userId(dto.getUserId())
			// 	.password(encoder.encode(dto.getPassword()))
			// 	.nickname(dto.getNickname())
			// 	.email(dto.getEmail())
			// 	.findPw(dto.getFindPw())
			// 	.findPwQuestion(dto.getFindPwQuestion())
			// 	.build()
		);
	}
}
