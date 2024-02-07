package com.questoesCM.DAO;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import com.questoesCM.model.User;

public interface UserDAO extends JpaRepository<User, Long> {
	
    @Query("SELECT u FROM User u")
    ArrayList<User> recuperarTodos();

	ArrayList<User> findByCidade(String cidade);
	
	UserDetails findByLogin(String username);

//	User findById(int idUsuario);

	User findByIdUsuario(int idUsuario);


}
