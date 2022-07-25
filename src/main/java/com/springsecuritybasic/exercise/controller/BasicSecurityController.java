package com.springsecuritybasic.exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springsecuritybasic.exercise.Dto.UserDto;
import com.springsecuritybasic.exercise.service.BasicSecurityService;

@RestController
@RequestMapping("/fetch")
public class BasicSecurityController {

	@Autowired
	private BasicSecurityService service;

	@GetMapping("/user/{userId}")
	ResponseEntity<UserDto> fetchUserDetail(@PathVariable("userId") Integer userId) {
		return new ResponseEntity<>(service.getUserDetails(userId), HttpStatus.OK);
	}

	@GetMapping("/welcomeAll")
	String getWelcomePage() {
		return "welcomAll";
	}

	@GetMapping("/singlePermissionPage")
	String getSinglePermissionPage() {
		return "singlePermissionPage";
	}

	@GetMapping("/adminAndPM")
	String getAdminAndPM() {
		return "AdminAndPM";
	}

}
