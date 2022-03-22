package com.homework.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.homework.entity.User;
import com.homework.service.EmailServiceForUser;
import com.homework.service.EmailServiceForUserImpl;
@Controller
public class UserController {
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	EmailServiceForUserImpl emailService;
	
	
	@RequestMapping("/LogIn")
		public String doCustumLogIn() {
		  
		  
		  return"log-in";
	  }
	// creating Sign up it will go processSignUp
	@GetMapping("/signUp")
	public String signUp(@ModelAttribute("user") User user) {
		
		return "sign-up";
	}
	// for Success sign up
	@PostMapping("/process-signup")
	public String processSignUp( @Valid @ModelAttribute("user") User user ,BindingResult result) {
		String passwordEncoded = passwordEncoder.encode(user.getPassword());
		
		user.setPassword(passwordEncoded);
		if(result.hasErrors()) {
			System.out.println("my page has error");
			List<ObjectError> allErrors = result.getAllErrors();			
			for(ObjectError error : allErrors) {
				System.out.println(error);
				
			}
    	   return "sign-up";
    	}
		emailService.saveUser(user);
		return "redirect:/LogIn";
	}
	   

}
