package com.questoesCM.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.questoesCM.model.Questao;
import com.questoesCM.service.IQuestaoService;

@RestController
public class QuestaoController {

	@Autowired
	private IQuestaoService service;

    @PostMapping("/questoes")
    public ResponseEntity<String> salvarQuestao(@RequestBody Questao q) {
        String respostaServico = service.salvarQuestao(q);
        if (respostaServico.startsWith("Erro")) {
            // Se a resposta do serviço começar com "Erro", significa que ocorreu um erro
            return ResponseEntity.status(500).body(respostaServico);
        } else {
            // Caso contrário, a operação foi bem-sucedida
            return ResponseEntity.ok(respostaServico);
        }
    }

    
    @GetMapping("/questoes")
    public ResponseEntity<ArrayList<Questao>> recuperarQuestoes(){
    	ArrayList<Questao> questoes = (ArrayList<Questao>)service.recuperarQuestoes();
    	return ResponseEntity.ok(questoes);
    }

    @PutMapping("/questoes/{id}")
    public ResponseEntity<Questao> atualizarQuestao(@PathVariable("id") int id, @RequestBody Questao q) {
        Questao res = service.atualizarQuestao(id, q);
        if (res != null){
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }
}
