package com.questoesCM.service;

import java.util.ArrayList;

import com.questoesCM.model.Questao;

public interface IQuestaoService {

	String adicionarQuestao(Questao q);


	ArrayList<Questao> simuladoPorAno(int anoProva);

}
