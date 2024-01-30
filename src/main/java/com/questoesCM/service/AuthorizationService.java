package com.questoesCM.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.questoesCM.DAO.UserDAO;

@Service
public class AuthorizationService implements UserDetailsService{
	
	@Autowired
	UserDAO DAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return DAO.findByLogin(username);
	}


	
}
