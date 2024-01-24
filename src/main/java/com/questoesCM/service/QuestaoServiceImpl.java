package com.questoesCM.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.questoesCM.DAO.QuestaoDAO;
import com.questoesCM.model.Questao;
import com.questoesCM.model.Usuario;

@Service
public class QuestaoServiceImpl implements IQuestaoService {


    @Autowired
    private QuestaoDAO dao;

    public ResponseEntity<String> salvarQuestao(Questao q) {
        try {
        	if(q.getIdQuestao() == 0) {
                return ResponseEntity.status(400).body("Id está sendo 0Como isso aconteceu?");
        	}
        	
            if (q.getAnoProva() <= 0) {
                return ResponseEntity.status(400).body("Ano da prova inválido.");
            }

            if (q.getNumeroQuestao() <= 0) {
                return ResponseEntity.status(400).body("Número da questão inválido.");
            }

            if (q.getEnunciado() == null || q.getEnunciado().isEmpty()) {
                return ResponseEntity.status(400).body("Enunciado não pode ser vazio.");
            }
            if (q.getRespostaA() == null || q.getRespostaA().isEmpty()) {
                return ResponseEntity.status(400).body("A Resposta A não pode ser vazia.");
            }

            if (q.getRespostaB() == null || q.getRespostaB().isEmpty()) {
                return ResponseEntity.status(400).body("A Resposta B não pode ser vazia.");
            }

            if (q.getRespostaC() == null || q.getRespostaC().isEmpty()) {
                return ResponseEntity.status(400).body("A Resposta C não pode ser vazia.");
            }

            if (q.getRespostaD() == null || q.getRespostaD().isEmpty()) {
                return ResponseEntity.status(400).body("A Resposta D não pode ser vazia.");
            }

            if (q.getRespostaE() == null || q.getRespostaE().isEmpty()) {
                return ResponseEntity.status(400).body("A Resposta E não pode ser vazia.");
            }
            if(q.getGabarito() == null) {
                return ResponseEntity.status(400).body("O gabarito não pode ser vazia.");
            }
            if(q.getMateria() == null) {
            	return ResponseEntity.status(400).body("Você precisa selecionar uma matéria");
            }
            if(q.getEnderecoVideo() == null || q.getEnderecoVideo().isEmpty()) {
            	return ResponseEntity.status(400).body("Você precisa enviar o link do video");

            }

        	dao.save(q);
            return  ResponseEntity.ok("Questão adicionada com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao adicionar a questão: " + e.getMessage());
        }
    }
	


//	Montar um simulado por ano
	@Override
	public ArrayList<Questao> simuladoPorAno(int anoProva) {

		return dao.findByAnoProva(anoProva);
	}



	@Override
	public ArrayList<Questao> recuperarTodasQuestoes() {

		return dao.findAll();
	}



	@Override
	public void save(Questao q) {
		dao.save(q);		
	}



}
