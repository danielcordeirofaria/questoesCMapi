package com.questoesCM.DAO;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.questoesCM.model.User;

public interface UserDAO extends JpaRepository<User, Integer>{

	ArrayList<User> findByCidade(String cidade);
	
	UserDetails findByLogin(String username);

}
