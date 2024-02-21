package com.questoesCM.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.questoesCM.DAO.QuestaoDAO;
import com.questoesCM.model.Questao;

@Service
public class QuestaoServiceImpl implements IQuestaoService {


    @Autowired
    private QuestaoDAO dao;

    
    @Override
    public String salvarQuestao(Questao q) {
        try {
            // Validações
            StringBuilder errorMessage = new StringBuilder();

            if (q.getAnoProva()  == null || q.getAnoProva().isEmpty()) {
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

            String escolaDaProva = q.getEscolaDaProva().name();
            int numeroQuestaoInt = q.getNumeroQuestao();
            String numeroQuestao;
            if (numeroQuestaoInt < 9){
                 numeroQuestao = "0" + Integer.toString(q.getNumeroQuestao());
            } else {
                 numeroQuestao = Integer.toString(q.getNumeroQuestao());
            }
            String codigoQuestao = escolaDaProva + q.getAnoProva() + numeroQuestao;
            q.setCodigoQuestao(codigoQuestao);

            if (q.getCodigoQuestao() != null && !q.getCodigoQuestao().isEmpty()) {
                // Verifica se já existe uma questão com o mesmo código no banco de dados
                if (dao.existsByCodigoQuestao(q.getCodigoQuestao())) {
                    return("Já existe uma questão com o mesmo código.\n");
                }
            }
                System.out.println(q.getIdQuestao());

            // Salvando a questão se todas as validações passarem
            dao.save(q);
            return "Questão " + q.getCodigoQuestao() + " adicionada com sucesso!";
        } catch (Exception e) {
            return "Erro ao adicionar a questão: " + e.getMessage();
        }
    }

    @Override
	public ArrayList<Questao> recuperarQuestoes() {

		return (ArrayList<Questao>) dao.findAll();
	}

    @Override
    public Questao atualizarQuestao(int id, Questao q) {
        Questao questaoExistente = dao.findById(id).orElse(null);

        if (q.getCodigoQuestao() != null){
            questaoExistente.setCodigoQuestao(q.getCodigoQuestao());
        }

        if (q.getEscolaDaProva() != null){
            questaoExistente.setEscolaDaProva(q.getEscolaDaProva());
        }

        if (q.getAnoProva() != null){
            questaoExistente.setAnoProva(q.getAnoProva());
        }

        if (q.getNumeroQuestao() != 0 && q.getNumeroQuestao() != questaoExistente.getNumeroQuestao()) {
            questaoExistente.setNumeroQuestao(q.getNumeroQuestao());
        }

        if (q.getEnunciado() != null){
            questaoExistente.setEnunciado(q.getEnunciado());
        }

        if(q.getRespostaA() != null){
            questaoExistente.setRespostaA(q.getRespostaA());
        }

        if(q.getRespostaB() != null){
            questaoExistente.setRespostaB(q.getRespostaB());
        }

        if(q.getRespostaC() != null){
            questaoExistente.setRespostaC(q.getRespostaC());
        }

        if(q.getRespostaD() != null){
            questaoExistente.setRespostaD(q.getRespostaD());
    }

        if(q.getRespostaE() != null){
            questaoExistente.setRespostaE(q.getRespostaE());
        }

        if(q.getGabarito() != null){
            questaoExistente.setGabarito(q.getGabarito());
        }

        if (q.getMateria() != null){
            questaoExistente.setMateria(q.getMateria());
        }

        if(q.getEnderecoVideo() != null){
            questaoExistente.setEnderecoVideo(q.getEnderecoVideo());
        }

        return dao.save(questaoExistente);
    }

}
