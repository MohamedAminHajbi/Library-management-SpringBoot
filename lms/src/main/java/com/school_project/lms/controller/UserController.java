package com.school_project.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school_project.lms.entity.User;
import com.school_project.lms.service.impl.UserService;
import com.school_project.lms.web.dto.UserRegistrationDto;


@RequestMapping("/registration")
@Controller
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		super();
		this.userService=userService;
	}
	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto() {
		return new UserRegistrationDto();
	}
	@GetMapping
	public String register() {
		return "Registration";
	}
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto userdto) {
		userService.save(userdto);
		return "redirect:/registration?success";
	}
	
	
}
