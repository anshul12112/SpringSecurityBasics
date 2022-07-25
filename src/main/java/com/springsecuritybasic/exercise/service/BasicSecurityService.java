package com.springsecuritybasic.exercise.service;

import com.springsecuritybasic.exercise.Dto.UserDto;

public interface BasicSecurityService {

	String createUser(UserDto userDto);

	UserDto getUserDetails(Integer userId);

}
