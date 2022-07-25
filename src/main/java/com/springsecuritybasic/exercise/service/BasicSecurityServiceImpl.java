package com.springsecuritybasic.exercise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springsecuritybasic.exercise.Dto.UserDto;
import com.springsecuritybasic.exercise.domain.User;
import com.springsecuritybasic.exercise.repository.UserRepository;

@Service
public class BasicSecurityServiceImpl implements BasicSecurityService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;

	@Override
	public String createUser(UserDto userDto) {
		userRepository.save(userDetailDtoToDomain(userDto));
		return "User Detail has been Recorded Sucessfully!";
	}

	public UserDto getUserDetails(Integer userId) {
		return userDetailDomainToDto(userRepository.findByUserId(userId));
	}

	protected User userDetailDtoToDomain(UserDto userDto) {
		User user = new User();
		user.setUsername(userDto.getUsername());
		user.setUserPswd(passwordEncoder.encode(userDto.getUserPswd()));
		user.setRole(userDto.getRole());
		user.setEmail(userDto.getEmail());
		return user;
	}

	protected UserDto userDetailDomainToDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setUsername(user.getUsername());
		userDto.setRole(user.getRole());
		userDto.setEmail(user.getEmail());
		return userDto;
	}

}
