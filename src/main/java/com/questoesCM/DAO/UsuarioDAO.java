package com.questoesCM.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.questoesCM.model.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer>{

	ArrayList<Usuario> findByCidade(String cidade);
	
	

}
