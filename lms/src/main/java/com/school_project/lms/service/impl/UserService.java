package com.school_project.lms.service.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.school_project.lms.entity.Role;
import com.school_project.lms.entity.User;
import com.school_project.lms.repository.UserRepo;
import com.school_project.lms.web.dto.UserRegistrationDto;



@Service
public class UserService implements UserDetailsService {
    
    private UserRepo userRepo;

	@Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepo userRepo) {
		super();
		this.userRepo = userRepo;
	}

    public User save(UserRegistrationDto userdto) {
        User user = new User(userdto.getUserId(), userdto.getUserType(), userdto.getUserName(), userdto.getEmail(),
                userdto.getAdress(), userdto.getMobile(), passwordEncoder.encode(userdto.getPassword()),Arrays.asList(new Role("ROLE_USER")));
        return userRepo.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
       
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }
    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
    	return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    	
    }
    
    public User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return userRepo.findByEmail(auth.getName());
    }

    
    public void updateUser(UserRegistrationDto userDto) {
        User user = getCurrentUser();
        user.setUserName(userDto.getUserName());
        user.setEmail(userDto.getEmail());
        user.setAdress(userDto.getAdress());
        user.setMobile(userDto.getMobile());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepo.save(user);
    }
}
