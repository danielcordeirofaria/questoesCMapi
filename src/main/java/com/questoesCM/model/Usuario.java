package com.questoesCM.model;

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
@Table(name = "tbl_usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private int idUsuario;
	
	@Column(name = "nome_usuario", length = 45, nullable = false)
	private String nome;
	
	@Column(name = "login", length = 40, nullable = false, unique = true)
	private String login;
	
	@Column(name = "senha", length = 40, nullable = false)
	private String senha; 
	
	@Column(name = "data_nascimento", nullable = false)
	private Date dataNascimento;
	
	@Column(name = "cidade", nullable = false)
	private String cidade;
	
	@Column(name = "email", length = 40, nullable = false)
	private String email;
	
	@Column(name = "whatsapp", length = 13, nullable = false)
	private String whatsapp;
	
	@Column(name = "data_compra")
	private Date dataCompra;
	
	@Column(name = "escola_da_prova", length = 10)
	@Enumerated(EnumType.STRING)
//	opções de escolas ('CMC', 'CMRJ', 'CMSP', 'CMBel', 'CMBH', 'CMB', 'CMCG', 'CMF', 'CMJF', 'CMM', 'CMPA', 'CMR', 'CMS', 'CMSM')
	private ColegioEnum escolaDaProva;
	
	@Column(name = "roles", length = 10)
	@Enumerated(EnumType.STRING)
    private UserRole roles;


	public Usuario(int idUsuario, String nome, String login, String senha, Date dataNascimento, String cidade, String email, String whatsapp,
			Date dataCompra, ColegioEnum escolaDaProva, UserRole roles) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.dataNascimento = dataNascimento;
		this.cidade = cidade;
		this.email = email;
		this.whatsapp = whatsapp;
		this.dataCompra = dataCompra;
		this.escolaDaProva = escolaDaProva;
		this.roles = roles;
	}

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
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
	
	

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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


	public UserRole getRoles() {
		return roles;
	}

	public void setRoles(UserRole roles) {
		this.roles = roles;
	}
	
	
	
	
	
	
	
}
