package com.acn.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acn.user.entity.User;
import com.acn.user.service.UserService;
import com.acn.user.vo.ResponseTemplateVO;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
	
	@Autowired
	private UserService userServices;
	
	@PostMapping("/")
	public User saveUser(@RequestBody User user) {
		log.info("Inside saveUser of UserController");
		return userServices.saveUser(user);
	}

	@GetMapping("/{id}")
	public ResponseTemplateVO getUserwithDepartment(@PathVariable("id") Long userId) {
		log.info("Inside getUserwithDepartment of UserController");
		return userServices.getUserwithDepartment(userId);
	}

	

}
