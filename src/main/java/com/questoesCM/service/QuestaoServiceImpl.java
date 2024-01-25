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

    
    @Override
    public String salvarQuestao(Questao q) {
        try {
            // Validações
            StringBuilder errorMessage = new StringBuilder();

            if (q.getIdQuestao() == 0) {
                errorMessage.append("Id está sendo 0. Como isso aconteceu?\n");
            }

            if (q.getAnoProva() <= 0) {
                errorMessage.append("Ano da prova inválido.\n");
            }

            if (q.getNumeroQuestao() <= 0) {
                errorMessage.append("Número da questão inválido.\n");
            }

            if (q.getEnunciado() == null || q.getEnunciado().isEmpty()) {
                errorMessage.append("Enunciado não pode ser vazio.\n");
            }
            if (q.getRespostaA() == null || q.getRespostaA().isEmpty()) {
                errorMessage.append("A Resposta A não pode ser vazia.\n");
            }

            if (q.getRespostaB() == null || q.getRespostaB().isEmpty()) {
                errorMessage.append("A Resposta B não pode ser vazia.\n");
            }

            if (q.getRespostaC() == null || q.getRespostaC().isEmpty()) {
                errorMessage.append("A Resposta C não pode ser vazia.\n");
            }

            if (q.getRespostaD() == null || q.getRespostaD().isEmpty()) {
                errorMessage.append("A Resposta D não pode ser vazia.\n");
            }

            if (q.getRespostaE() == null || q.getRespostaE().isEmpty()) {
                errorMessage.append("A Resposta E não pode ser vazia.\n");
            }
            if (q.getGabarito() == null) {
                errorMessage.append("O gabarito não pode ser vazio.\n");
            }
            if (q.getMateria() == null) {
                errorMessage.append("Você precisa selecionar uma matéria.\n");
            }
            if (q.getEnderecoVideo() == null || q.getEnderecoVideo().isEmpty()) {
                errorMessage.append("Você precisa enviar o link do video.\n");
            }

            // Se houver mensagens de erro, retorna-as
            if (errorMessage.length() > 0) {
                return errorMessage.toString();
            }

            // Salvando a questão se todas as validações passarem
            dao.save(q);
            return "Questão adicionada com sucesso!";
        } catch (Exception e) {
            return "Erro ao adicionar a questão: " + e.getMessage();
        }
    }


//	Montar um simulado por ano
//	@Override
//	public ArrayList<Questao> simuladoPorAno(int anoProva) {
//
//		return dao.findByAnoProva(anoProva);
//	}



	@Override
	public ArrayList<Questao> recuperarQuestoes() {

		return (ArrayList<Questao>) dao.findAll();
	}




}
