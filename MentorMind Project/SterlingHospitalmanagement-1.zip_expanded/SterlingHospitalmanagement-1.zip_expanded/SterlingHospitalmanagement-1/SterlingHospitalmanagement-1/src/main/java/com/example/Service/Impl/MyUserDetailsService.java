package com.example.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Entity.User;
import com.example.Repository.UserLoginRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserLoginRepository userLoginRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { // TODO Auto-generated
																								// method stub
		User user = userLoginRepository.findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("user not found");
		}
		return new UserPrincipal(user);
	}

}
