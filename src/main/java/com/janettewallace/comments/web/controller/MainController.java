package com.janettewallace.comments.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

//pages that are viewable without logging in
@Controller
public class MainController {

	//home page
	@GetMapping("/")
    public String home() {
        return "home";
    }
	
	//portfolio
	@GetMapping("/portfolio")
	public String portfolio() {
		return "portfolio";	
	}
	
	//project from portfolio
	@GetMapping("/viewCalculator")
	public String calculator() {
		return "view_calculator";	
	}
	
	//project from protfolio
	@GetMapping("/viewGrid")
	public String grid() {
		return "view_grid";	
	}	
	
	//login form
	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	} 
	
	//terms and conditions page accessible from registration
	@GetMapping("/terms")
	public String terms() {
		return "terms";
	}


}
