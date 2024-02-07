package com.questoesCM.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.questoesCM.DAO.UserDAO;
import com.questoesCM.model.User;

@Service
public class UserServiceImpl implements IUsuarioService {

	@Autowired
    private UserDAO dao;
	
    @Override
    public ResponseEntity cadastrarUsuario(User user) {
        try {
        	if(this.dao.findByLogin(user.getLogin()) !=null) return ResponseEntity.badRequest().build();
        	
        	String encryptedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        	user.setPassword(encryptedPassword);
        	
        	dao.save(user);
    		return ResponseEntity.ok().build();
        } catch (Exception e) {
            // Tratar exceções, se necessário
        	return ResponseEntity.badRequest().build();        }
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

	@Override
	public User arualizaUsers(int idUsuario, User user) {
		
		User userExistente = dao.findByIdUsuario(idUsuario);
		if(userExistente == null) {
			return null;
		}
		if(user.getEmail() != null) {
			 userExistente.setEmail(user.getEmail());
		}
	    if (user.getPassword() != null) {
	        // Criptografa a nova senha
	        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	        String senhaCriptografada = passwordEncoder.encode(user.getPassword());

	        // Atualiza a senha criptografada no usuário existente
	        userExistente.setPassword(senhaCriptografada);
	    }
	    
		if(user.getDataCompra() != null) {
			 userExistente.setDataCompra(user.getDataCompra());
		}
		if(user.getEscolaDaProva() != null) {
			 userExistente.setEscolaDaProva(user.getEscolaDaProva());
		}		
		
		return dao.save(userExistente);
	}


}
