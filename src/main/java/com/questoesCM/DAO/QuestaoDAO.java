package com.questoesCM.DAO;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;

import com.questoesCM.model.Questao;

public interface QuestaoDAO extends CrudRepository<Questao, Integer> {
	
    ArrayList<Questao> findByAnoProva(String anoProva);

    boolean existsByCodigoQuestao(String codigoQuestao);
}