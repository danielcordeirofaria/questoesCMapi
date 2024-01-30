package com.questoesCM.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.questoesCM.model.Questao;
import com.questoesCM.service.IQuestaoService;

@RestController
public class QuestaoController {

	@Autowired
	private IQuestaoService service;
	
    @PostMapping("/questoes")
    public ResponseEntity<String> salvarQuestao(@RequestBody Questao q) {
        try {
            System.out.println("Id_questao antes de salvar: " + q.getIdQuestao());

            service.salvarQuestao(q);
            
            System.out.println("Id_questao após salvar: " + q.getIdQuestao());

            return ResponseEntity.ok("Questao adicionada com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao adicionar a questao: " + e.getMessage());
        }
    }
    
    @GetMapping("/questoes")
    public ResponseEntity<ArrayList<Questao>> recuperarQuestoes(){
    	ArrayList<Questao> questoes = (ArrayList<Questao>)service.recuperarQuestoes();
    	return ResponseEntity.ok(questoes);
    }
    
//    @GetMapping("/questao/{anoProva}")
//    public ResponseEntity<ArrayList<Questao>> simuladoPorAno(@PathVariable int anoProva){
//    	ArrayList<Questao> simulado = (ArrayList<Questao>)service.simuladoPorAno(anoProva);
//    	return ResponseEntity.ok(simulado);
//    }
//    
   

}
