package com.school_project.lms.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.school_project.lms.entity.User;
import com.school_project.lms.service.impl.UserService;

@Controller
@CrossOrigin
public class MyBibController {
	
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	@GetMapping("/aboutUs")
	public String aboutUs() {
		return "aboutUs";
	}
	@GetMapping("/login")
	public String login() {
		return "login";
	}

}
