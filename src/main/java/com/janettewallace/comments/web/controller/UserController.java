package com.janettewallace.comments.web.controller;

import java.security.Principal;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.janettewallace.comments.model.Comments;
import com.janettewallace.comments.model.User;
import com.janettewallace.comments.repository.CommentsRepository;
import com.janettewallace.comments.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CommentsRepository commentsRepository;
	
	@ModelAttribute
	public void addCommData(Principal principal, Model model) {
		String email = principal.getName();
		User user = userRepository.findByEmail(email);
		model.addAttribute("user", user);		
	}
		
	@GetMapping("/addComments")
	public String home() {
		return "user/add_comments";
	}
	
	@RequestMapping("/saveComments")
	public String saveComments(@ModelAttribute Comments comments, HttpSession session, Principal principal) {
		
		String email = principal.getName();
		User user = userRepository.findByEmail(email);
		comments.setUser(user);
		
		Comments c = commentsRepository.save(comments);
		
		if(c != null) {
			session.setAttribute("msg", "comments saved successfully");
		}else {
			session.setAttribute("msg", "something went wrong, comments did not save");
		}

		return "redirect:/user/addComments";
	}
	
	@GetMapping("/viewComments/{page}")
	public String viewComments(@PathVariable int page, Model model, Principal principal) {
		
		String email = principal.getName();
		User user = userRepository.findByEmail(email);
		
		Pageable pageable = PageRequest.of(page,  5, Sort.by("id").descending());
		Page<Comments> comments = commentsRepository.findCommentsByUser(user.getId(), pageable);
		
		model.addAttribute("pageNumber", page);
		model.addAttribute("totalPage", comments.getTotalPages());
		model.addAttribute("Comments", comments);
		model.addAttribute("totalElement", comments.getTotalElements());
		
		return "user/view_comments";
	}
	
	@GetMapping("/editComments/{id}")
	public String editComments(@PathVariable int id, Model model) {
		
		Optional<Comments> c = commentsRepository.findById(id);
		if(c != null) {
			Comments comments = c.get();
			model.addAttribute("comments", comments);
		}
		
		return "user/edit_comments";
	}
	
	@PostMapping("/updateComments")
	public String updateComments(@ModelAttribute Comments comments, HttpSession session, Principal principal) {
		
		String email = principal.getName();
		User user = userRepository.findByEmail(email);
		
		comments.setUser(user);
		
		Comments updateComments = commentsRepository.save(comments);
		if(updateComments != null) {
			session.setAttribute("msg", "update saved successfully");
		}else {
			session.setAttribute("msg", "something went wrong, update did not save");
		}
		
		return "redirect:/user/viewComments/0";
	}
	
	@GetMapping("/deleteComments/{id}")
	public String deleteComments(@PathVariable int id, HttpSession session) {
		
		Optional<Comments> comments = commentsRepository.findById(id);
		if(comments != null) {
			commentsRepository.delete(comments.get());
			session.setAttribute("msg", "comment successfully deleted");
		}
		
		return "redirect:/user/viewComments/0";
	}
	
	
	@GetMapping("/viewProfile")
	public String viewProfile() {
		return "user/view_profile";
	}
	
	@PostMapping("/updateUser")
	public String updateUser(@ModelAttribute User user, HttpSession session, Model model) {
		
		Optional <User> oldDtls = userRepository.findById(user.getId());
		if(oldDtls != null) {
			user.setPassword(oldDtls.get().getPassword());
			user.setRoles(oldDtls.get().getRoles());
			user.setEmail(oldDtls.get().getEmail());
			
			User updateUser = userRepository.save(user);
			if(updateUser != null) {
				model.addAttribute("user", updateUser);
				session.setAttribute("msg", "profile update successful");
			}else {
				session.setAttribute("msg", "something went wrong, profile was not updated");
			}
		}
		
		return "redirect:/user/viewProfile";
	}
	
}

