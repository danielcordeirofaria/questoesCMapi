package com.questoesCM.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.questoesCM.DAO.QuestaoDAO;
import com.questoesCM.model.Questao;

@Service
public class QuestaoServiceImpl implements IQuestaoService {


	@Autowired
	private QuestaoDAO DAO;

//	Adicionar uma questão no db
	public String adicionarQuestao(Questao questao) {
		try {
			DAO.save(questao);
			return "Questão salva com sucesso!";

		} catch (Exception e) {
			// TODO: handle exception
			return "Erro ao salvar a questão: " + e.getMessage();
		}
	}
	


//	Montar um simulado por ano
	@Override
	public ArrayList<Questao> simuladoPorAno(int anoProva) {

		return DAO.findByAnoProva(anoProva);
	}



}
