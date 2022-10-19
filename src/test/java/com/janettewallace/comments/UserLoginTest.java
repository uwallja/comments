package com.janettewallace.comments;

import org.junit.jupiter.api.Test;

import com.janettewallace.comments.model.User;
import com.janettewallace.comments.repository.UserRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class UserLoginTest {
    
    User u = new User();
    UserRepository userRepo;

    @Test
    public void testGetPassword() {
    	
    	User u = new User();
    	u.setPassword("1234");
        u.setEmail("jw@gmail.com");
        
        assertEquals("1234", u.getPassword()); //J M's actual password so should be true (encrypted in database)
        
        assertNotEquals("5678", u.getPassword()); //using Glitter's password so this should be true
        
        System.out.println("Expected and actual results matched. Test passed!");
        
    }

}