package com.janettewallace.comments.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.janettewallace.comments.model.User;
import com.janettewallace.comments.web.controller.dto.UserRegistrationDto;

import lombok.extern.slf4j.Slf4j;

//interface 
public interface UserService extends UserDetailsService {

	User findByEmail(String email);
	User save(UserRegistrationDto registration);
	
}
