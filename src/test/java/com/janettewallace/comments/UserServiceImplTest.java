package com.janettewallace.comments;

import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.janettewallace.comments.model.Role;
import com.janettewallace.comments.model.User;
import com.janettewallace.comments.repository.UserRepository;
import com.janettewallace.comments.service.UserServiceImpl;



@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {

	@Autowired
	public UserRepository userRepo;
	
	//testing save user - below should populate to database with email as NULL
	@Test
	public void saveUserTest() {
		
		User user = new User();
	       user.setFirstName("Janette");
	       user.setLastName("Wallace");
	       user.setEmail("jwallace@email.com");
	       
	       
	     userRepo.save(user);
	       
	     Assertions.assertThat(user.getId()).isGreaterThan(1);
	}
	
		
}
