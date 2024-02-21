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
			if (this.dao.findByLogin(user.getLogin()) != null) {
				return ResponseEntity.badRequest().body("Login já utilizado");
			}
			if(user.getNome() == null || user.getNome().isEmpty()) {
				return ResponseEntity.badRequest().body("Não permetido adicionar um novo usuário sem nome");
			}
			if(user.getEmail() == null|| user.getEmail().isEmpty()) {
				return ResponseEntity.badRequest().body("Não permetido adicionar um novo usuário sem informar o email");
			}
			if(user.getLogin() == null|| user.getLogin().isEmpty()) {
				return ResponseEntity.badRequest().body("Não permetido adicionar um novo usuário sem informar um login");
			}
			if(user.getPassword() == null|| user.getPassword().isEmpty()) {
				return ResponseEntity.badRequest().body("Não permetido adicionar um novo usuário sem informar um password");
			}
			if(user.getDataNascimento() == null) {
				return ResponseEntity.badRequest().body("Não permetido adicionar um novo usuário sem informar a data de nascimento");
			}
			if(user.getCidade() == null|| user.getCidade().isEmpty()) {
				return ResponseEntity.badRequest().body("Não permetido adicionar um novo usuário sem informar a cidade de residencia");
			}
			if(user.getWhatsapp() == null|| user.getWhatsapp().isEmpty()) {
				return ResponseEntity.badRequest().body("Não permetido adicionar um novo usuário sem informar o whatsapp");
			}
			if(user.getNome() == null|| user.getNome().isEmpty()) {
				return ResponseEntity.badRequest().body("Não permetido adicionar um novo usuário sem informar para qual escola fará a prova");
			}
			
			String encryptedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
			user.setPassword(encryptedPassword);

			dao.save(user);
	        return ResponseEntity.ok().body(user);
		} catch (Exception e) {
			// Tratar exceções, se necessário
			return ResponseEntity.badRequest().build();
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

	@Override
	public User arualizaUsers(int idUsuario, User user) {

		User userExistente = dao.findByIdUsuario(idUsuario);
		if (userExistente == null) {
			return null;
		}
		if (user.getEmail() != null) {
			userExistente.setEmail(user.getEmail());
		}
		if (user.getPassword() != null) {
			// Criptografa a nova senha
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String senhaCriptografada = passwordEncoder.encode(user.getPassword());

			// Atualiza a senha criptografada no usuário existente
			userExistente.setPassword(senhaCriptografada);
		}

		if (user.getDataCompra() != null) {
			userExistente.setDataCompra(user.getDataCompra());
		}
		if (user.getEscolaDaProva() != null) {
			userExistente.setEscolaDaProva(user.getEscolaDaProva());
		}

		return dao.save(userExistente);
	}

}
