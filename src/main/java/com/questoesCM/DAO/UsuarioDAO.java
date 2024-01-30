package com.questoesCM.DAO;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.questoesCM.model.Usuario;

public interface UsuarioDAO extends JpaRepository<Usuario, Integer>{

	ArrayList<Usuario> findByCidade(String cidade);
	
	UserDetails findByEmail(String email);
}
