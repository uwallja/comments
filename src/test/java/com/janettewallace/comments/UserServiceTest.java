package com.janettewallace.comments;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.janettewallace.comments.model.User;
import com.janettewallace.comments.repository.UserRepository;

//UserService only has 2 methods: save user and findByEmail

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

	@Autowired
	public UserRepository userRepo;
	
	//testing save user - below should populate to database with email as NULL
	@Test
	public void saveUserTest() {
		
		User user = new User();
	       user.setFirstName("Another");
	       user.setLastName("Test");
	       user.setEmail("another_test2@email.com");
       
	     userRepo.save(user);
	       
	     Assertions.assertThat(user.getId()).isGreaterThan(1);
	}
	
/*	//be sure to comment out the aforementioned code before running this test 
	  @Test 
	  void findByEmailTest() {
	  
	  //actual user email in database
	  
	  String actual = "jwallace@email.com"; //email created from previous save user test 
	  User user = userRepo.findByEmail(actual);
	  
	 //expected retrieved data from database 
	 String expected = userRepo.findByEmail(actual).getEmail();
	 Assertions.assertThat(expected.equals(actual)); }
	  
	  
	  //test with parameters for find user by email
	  
	 @ParameterizedTest
	 @ValueSource(strings={"jwallace@email.com"}) 
	 void findByEmailParameterizedTest(String actual) { 
		 String expected = userRepo.findByEmail(actual).getEmail();
	 
		 Assertions.assertThat(expected.equals(actual)); 
	}
	  
*/	
}
