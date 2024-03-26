package com.example.KeyboardArenaProject.service.user;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.KeyboardArenaProject.repository.UserRepository;

@Service
public class UserDetailService implements UserDetailsService {
	private UserRepository userRepository;

	public UserDetailService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		return userRepository.findByUserId(id).orElseThrow(() -> new IllegalArgumentException(id));
	}

}