package com.questoesCM.service;

import java.util.ArrayList;

import com.questoesCM.model.Aluno;

public interface IAlunoService {
	

	ArrayList<Aluno> buscarAlunosPorCidade(String cidade);

	ArrayList<Aluno> recuperarTodos();

	String salvarAluno(Aluno aluno);

	void save(Aluno aluno);
	
	
}
