package com.school_project.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.school_project.lms.entity.User;
import com.school_project.lms.service.impl.UserService;
import com.school_project.lms.web.dto.UserRegistrationDto;
@RequestMapping("/update")
@Controller
public class UpdateUserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/editProfile")
    public String showProfileForm(Model model) {
        User user = userService.getCurrentUser();
        model.addAttribute("user", user);
        return "editProfile";
    }

    @PostMapping("/editProfile")
    public String updateProfile(@ModelAttribute("user") UserRegistrationDto userDto) {
        userService.updateUser(userDto);
        return "redirect:/";
    }
}
