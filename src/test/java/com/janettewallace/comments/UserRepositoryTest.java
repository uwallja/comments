package com.janettewallace.comments;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.test.context.junit4.SpringRunner;
import org.assertj.core.api.Assertions;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.janettewallace.comments.model.User;
import com.janettewallace.comments.repository.UserRepository;
import com.janettewallace.comments.service.UserServiceImpl;




@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest { 
	
	
	
	@Autowired
	public UserRepository userRepo;
	
	 
	//this test is testing the find user by email method located in the repository
	
	 @Test void findByEmailTest() {
	 
	 //actual user email in database
	 
	 String actual = "newuser@email.com"; 
	 User user = userRepo.findByEmail(actual);
	 
	 //expected retrieved data from database 
	 String expected = userRepo.findByEmail(actual).getEmail();
	 Assertions.assertThat(expected.equals(actual));
	 }

	
	//test with parameters for find user by email
	@ParameterizedTest
	@ValueSource(strings={"newuser@email.com", "auser@email.com", "test@email.com"})
	void findByEmailParameterizedTest(String actual) {
		String expected = userRepo.findByEmail(actual).getEmail();
		Assertions.assertThat(expected.equals(actual));
	}
	
	
}
