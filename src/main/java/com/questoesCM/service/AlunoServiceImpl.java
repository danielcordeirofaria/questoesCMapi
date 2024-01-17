package com.questoesCM.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.questoesCM.DAO.alunoDAO;
import com.questoesCM.model.Aluno;

@Service
public class AlunoServiceImpl implements IAlunoService {

	@Autowired
    private alunoDAO dao;

    @Override
    public String salvarAluno(Aluno aluno) {
        try {
            dao.save(aluno);
            return "Aluno salvo com sucesso!";
        } catch (Exception e) {
            // Tratar exceções, se necessário
            return "Erro ao salvar o aluno: " + e.getMessage();
        }
    }

    @Override
    public ArrayList<Aluno> buscarAlunosPorCidade(String cidade) {
        return dao.findByCidade(cidade);
    }


    @Override
    public ArrayList<Aluno> recuperarTodos() {
        return (ArrayList<Aluno>) dao.findAll();
    }

	@Override
	public void save(Aluno aluno) {
		dao.save(aluno);
		
	}


}
