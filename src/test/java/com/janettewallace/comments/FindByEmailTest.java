package com.janettewallace.comments;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.janettewallace.comments.model.User;
import com.janettewallace.comments.repository.UserRepository;
import com.janettewallace.comments.service.UserService;



public class FindByEmailTest {
	
	UserService  userDtls;
	
	User u = new User();
	
	
    
	
	@Test
	public void test() {
		
		u.setEmail("jw@gmail.com");
				
		String actualEmail = u.getEmail();
		
		assertEquals("jw@gmail.com", actualEmail);
		
		System.out.println("Expected and actual results matched. Test passed!");
	}
	
/*
	@Test
    public void test() {
    	
		u.setEmail("jw@gmail.com");
		
        String actualEmail = "jw@gmail.com";
          
        assertEquals("jw@gmail.com", actualEmail); //the email returned should match the email expected for J Marie Wallace
        
        System.out.println("Expected and actual results matched. Test passed!");
    }

*/	
}
