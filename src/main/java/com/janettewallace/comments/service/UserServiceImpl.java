package com.janettewallace.comments.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.janettewallace.comments.model.Role;
import com.janettewallace.comments.model.User;
import com.janettewallace.comments.repository.UserRepository;
import com.janettewallace.comments.web.controller.dto.UserRegistrationDto;

import lombok.extern.slf4j.Slf4j;


@Service
public class UserServiceImpl implements UserService {

   @Autowired
   private UserRepository userRepository;

   @Autowired
   private BCryptPasswordEncoder passwordEncoder; //password encoder

   public User findByEmail(String email){
       return userRepository.findByEmail(email);
   }

   //user registration information - set and save
   public User save(UserRegistrationDto registration){
       User user = new User();
       user.setFirstName(registration.getFirstName());
       user.setLastName(registration.getLastName());
       user.setEmail(registration.getEmail());
       user.setPassword(passwordEncoder.encode(registration.getPassword()));
       user.setRoles(Arrays.asList(new Role("ROLE_USER")));
       return userRepository.save(user);
   }

   @Override
   public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       User user = userRepository.findByEmail(email);
       if (user == null){
           throw new UsernameNotFoundException("Invalid username or password.");
       }
       return new org.springframework.security.core.userdetails.User(user.getEmail(),
               user.getPassword(),
               mapRolesToAuthorities(user.getRoles()));
   }

   private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
       return roles.stream()
               .map(role -> new SimpleGrantedAuthority(role.getName()))
               .collect(Collectors.toList());
   }
}