package com.questoesCM.model;

//endereco_imagempackage com.questoesCM.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_alunos")
public class Aluno {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_aluno")
	private int id;
	
	@Column(name = "nome_aluno", length = 45, nullable = false)
	private String nome;
	
	@Column(name = "login", length = 40, nullable = false, unique = true)
	private String login;

	
	@Column(name = "data_nascimento", nullable = false)
	private Date dataNascimento;
	
	@Column(name = "cidade", nullable = false)
	private String cidade;
	
	@Column(name = "email", length = 40, nullable = false)
	private String email;
	
	@Column(name = "whatsapp", length = 13, nullable = false)
	private String whatsapp;
	
	@Column(name = "data_compra", nullable = false)
	private Date dataCompra;
	
	@Column(name = "escola_da_prova", length = 40, nullable = false)
	@Enumerated(EnumType.STRING)
//	opções de escolas ('CMC', 'CMRJ', 'CMSP', 'CMBel', 'CMBH', 'CMB', 'CMCG', 'CMF', 'CMJF', 'CMM', 'CMPA', 'CMR', 'CMS', 'CMSM')
	private ColegioEnum escolaDaProva;

	public Aluno(int id, String nome, String login, Date dataNascimento, String cidade, String email, String whatsapp,
			Date dataCompra, ColegioEnum escolaDaProva) {
		super();
		this.id = id;
		this.nome = nome;
		this.login = login;
		this.dataNascimento = dataNascimento;
		this.cidade = cidade;
		this.email = email;
		this.whatsapp = whatsapp;
		this.dataCompra = dataCompra;
		this.escolaDaProva = escolaDaProva;
	}

	public Aluno() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
		public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public ColegioEnum getEscolaDaProva() {
		return escolaDaProva;
	}

	public void setEscolaDaProva(ColegioEnum escolaDaProva) {
		this.escolaDaProva = escolaDaProva;
	}
	
	
	
	
	
	
}
