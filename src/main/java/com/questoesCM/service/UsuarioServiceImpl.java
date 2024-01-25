package com.questoesCM.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.questoesCM.DAO.UsuarioDAO;
import com.questoesCM.model.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
    private UsuarioDAO dao;

    @Override
    public String cadastrarUsuario(Usuario usuario) {
        try {
            dao.save(usuario);
            return "Aluno salvo com sucesso!";
        } catch (Exception e) {
            // Tratar exceções, se necessário
            return "Erro ao salvar o aluno: " + e.getMessage();
        }
    }

    @Override
    public ArrayList<Usuario> buscarAlunosPorCidade(String cidade) {
        return dao.findByCidade(cidade);
    }


    @Override
    public ArrayList<Usuario> recuperarTodos() {
        return (ArrayList<Usuario>) dao.findAll();
    }

	@Override
	public void save(Usuario usuario) {
		dao.save(usuario);
		
	}


}
