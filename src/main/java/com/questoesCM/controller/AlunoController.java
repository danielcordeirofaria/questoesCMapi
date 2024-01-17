package com.questoesCM.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.questoesCM.model.Aluno;
import com.questoesCM.service.IAlunoService;

@RestController
public class AlunoController {
	
	@Autowired
	private IAlunoService service;

    @PostMapping("/alunos")
    public ResponseEntity<String> cadastrarAluno(@RequestBody Aluno aluno) {
    	service.save(aluno);
        return ResponseEntity.ok("Aluno adicionado com sucesso!");
    }

    @GetMapping("/alunos")
    public ResponseEntity<ArrayList<Aluno>> recuperarTodos() {
    	ArrayList<Aluno> alunos = (ArrayList<Aluno>)service.recuperarTodos();
        return ResponseEntity.ok(alunos);
    }

    
}
