package com.spring.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.crud.jwt.JwtUtills;
import com.spring.crud.model.User;
import com.spring.crud.repo.UserRepo;
import com.spring.crud.security.LoginUserDetails;
import com.spring.crud.security.LoginUserDetailsService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200/")
public class SpringController {

	@Autowired
	UserRepo userRepo;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	LoginUserDetailsService loginUserDetailsService;
	@Autowired
	JwtUtills jwtutils;

	@PostMapping("/login")
	public String authenticateUser(@RequestBody User u) {
		try {
			Authentication authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(u.getUsername(), u.getPassword()));
			if (authentication.getName().equalsIgnoreCase(u.getUsername())) {
				SecurityContextHolder.getContext().setAuthentication(authentication);
				LoginUserDetails loginUserDetails = (LoginUserDetails) loginUserDetailsService
						.loadUserByUsername(u.getUsername());

				String TOKEN = jwtutils.generateJwtToken(loginUserDetails);
				return TOKEN;
			} else {
				return "YOU ARE NOT REGISTERED USER";
			}

		} catch (Exception x) {
			return "YOU ARE NOT REGISTERED USER | CHECK USERNAME AND PASSWORD";
		}

	}

	@PostMapping("/adduser")
	public String addUser(@RequestBody User u) {
		String encPassword = new BCryptPasswordEncoder().encode(u.getPassword());
		u.setPassword(encPassword);
		userRepo.save(u);
		return "USER CREATED";
	}

	@GetMapping("/get-all-users")
	public List<User> getAllUsers() {
		List<User> usersList = userRepo.findAll();
		return usersList;
	}

	@GetMapping("/get-token-validity")
	public Boolean checkTokenValidity(@RequestParam("token") String token) {
		try {
			String username = jwtutils.getUsernameFromToken(token);
			LoginUserDetails loginUserDetails = (LoginUserDetails) loginUserDetailsService.loadUserByUsername(username);
			if (jwtutils.validateJwtToken(token, loginUserDetails)) {
				return true;
			}
		} catch (Exception x) {
			return false;
		}
		return false;

	}

}
