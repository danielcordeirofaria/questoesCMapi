package com.questoesCM.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.questoesCM.model.Aluno;

public interface alunoDAO extends CrudRepository<Aluno, Integer>{

	ArrayList<Aluno> findByCidade(String cidade);
	
	

}
