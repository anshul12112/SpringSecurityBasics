package com.springsecuritybasic.exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springsecuritybasic.exercise.Dto.UserDto;
import com.springsecuritybasic.exercise.service.BasicSecurityService;

@RestController
@RequestMapping("/basicSecurity")
public class BasicSecurityUserContoller {

	@Autowired
	BasicSecurityService basicSecurityService;

	@PostMapping("/user")
	ResponseEntity<String> createUser(@RequestBody UserDto userDto) {
		return new ResponseEntity<>(basicSecurityService.createUser(userDto), HttpStatus.OK);
	}
}