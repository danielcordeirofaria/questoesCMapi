package com.questoesCM.service;

import java.util.ArrayList;

import com.questoesCM.model.User;

public interface IUsuarioService {


	ArrayList<User> buscarAlunosPorCidade(String cidade);

	ArrayList<User> recuperarTodos();

	String cadastrarUsuario(User user);

	public void save(User user);
	
	
}
