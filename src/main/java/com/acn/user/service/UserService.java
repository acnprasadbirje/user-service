package com.acn.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.acn.user.entity.User;
import com.acn.user.repository.UserRepository;
import com.acn.user.vo.Department;
import com.acn.user.vo.ResponseTemplateVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {
		log.info("Inside saveUser of UserService");
		return userRepository.save(user);
	}

	public ResponseTemplateVO getUserwithDepartment(Long userId) {
		log.info("Inside getUserwithDepartment of UserService");
		ResponseTemplateVO vo = new ResponseTemplateVO();
		User user = userRepository.findByUserId(userId);
		Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+userId, Department.class);
		vo.setUser(user);
		vo.setDepartment(department);
		return vo;
	} 

}
