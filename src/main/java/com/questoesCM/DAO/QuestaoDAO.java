package com.questoesCM.DAO;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;

import com.questoesCM.model.Questao;

public interface QuestaoDAO extends CrudRepository<Questao, Long> {
	
    ArrayList<Questao> findByAnoProva(int anoProva);

	ArrayList<Questao> findAll();
	
}