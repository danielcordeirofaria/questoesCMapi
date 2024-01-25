package com.questoesCM.service;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;

import com.questoesCM.model.Questao;
import com.questoesCM.model.Usuario;

public interface IQuestaoService {

//	ArrayList<Questao> simuladoPorAno(int anoProva);

	ArrayList<Questao> recuperarQuestoes();

	String salvarQuestao(Questao q);

	public void save(Questao q);

	
}
