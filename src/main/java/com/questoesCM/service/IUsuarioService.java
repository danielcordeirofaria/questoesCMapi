package com.questoesCM.service;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;

import com.questoesCM.model.User;

public interface IUsuarioService {


	ArrayList<User> buscarAlunosPorCidade(String cidade);

	ArrayList<User> recuperarTodos();

	ResponseEntity cadastrarUsuario(User user);

	public void save(User user);

	User arualizaUsers(int idUsuario, User user);
	
	
}
