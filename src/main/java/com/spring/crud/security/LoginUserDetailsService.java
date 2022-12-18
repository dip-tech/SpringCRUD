package com.spring.crud.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.crud.model.User;
import com.spring.crud.repo.UserRepo;

@Service
public class LoginUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User> loginUser = userRepo.findById(username);
		if (loginUser.get() != null) {
			return new LoginUserDetails(loginUser.get());
		}
		return null;
	}

}
