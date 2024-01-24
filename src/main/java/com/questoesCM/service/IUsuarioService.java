package com.questoesCM.service;

import java.util.ArrayList;

import com.questoesCM.model.Usuario;

public interface IUsuarioService {


	ArrayList<Usuario> buscarAlunosPorCidade(String cidade);

	ArrayList<Usuario> recuperarTodos();

	String salvarAluno(Usuario usuario);

	public void save(Usuario usuario);
	
	
}
