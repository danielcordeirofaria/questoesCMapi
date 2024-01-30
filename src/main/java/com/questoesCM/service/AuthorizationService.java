package com.questoesCM.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.questoesCM.DAO.UsuarioDAO;

@Service
public class AuthorizationService implements UserDetailsService{
	
	@Autowired
	UsuarioDAO DAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return DAO.findByEmail(username);
	}


	
}
