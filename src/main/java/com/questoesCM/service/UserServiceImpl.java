package com.questoesCM.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.questoesCM.DAO.UserDAO;
import com.questoesCM.model.User;

@Service
public class UserServiceImpl implements IUsuarioService {

	@Autowired
    private UserDAO dao;

    @Override
    public String cadastrarUsuario(User user) {
        try {
        	dao.save(user);
            return "Aluno salvo com sucesso!";
        } catch (Exception e) {
            // Tratar exceções, se necessário
            return "Erro ao salvar o aluno: " + e.getMessage();
        }
    }

    @Override
    public ArrayList<User> buscarAlunosPorCidade(String cidade) {
        return dao.findByCidade(cidade);
    }


    @Override
    public ArrayList<User> recuperarTodos() {
        return (ArrayList<User>) dao.findAll();
    }

	@Override
	public void save(User user) {
		dao.save(user);
		
	}


}
