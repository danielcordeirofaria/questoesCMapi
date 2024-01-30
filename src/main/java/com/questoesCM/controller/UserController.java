package com.questoesCM.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.questoesCM.model.User;
import com.questoesCM.service.IUsuarioService;

@RestController
public class UserController {
	
	@Autowired
	private IUsuarioService service;

    @PostMapping("/usuarios")
    public ResponseEntity<String> cadastrarUsuario(@RequestBody User user) {
        try {
            service.cadastrarUsuario(user);
            return ResponseEntity.ok("Aluno adicionado com sucesso!");
        } catch (Exception e) {
            // Aqui você pode lidar com a exceção de maneira apropriada, como logá-la ou retornar uma mensagem de erro específica.
            return ResponseEntity.status(500).body("Erro ao cadastrar o aluno: " + e.getMessage());
        }
    }

    @GetMapping("/usuarios")
    public ResponseEntity<ArrayList<User>> recuperarTodos() {
    	ArrayList<User> user = (ArrayList<User>)service.recuperarTodos();
        return ResponseEntity.ok(user);
    }

    
}
