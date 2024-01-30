package com.questoesCM.model;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_users")
public class User implements UserDetails{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private int idUsuario;
	
	@Column(name = "nome_usuario", length = 45, nullable = false)
	private String nome;
	
	@Column(name = "email", length = 40, nullable = false)
	private String email;
	
	@Column(name = "login", length = 40, nullable = false)
	private String login;
	
	@Column(name = "password", length = 40, nullable = false)
	private String password; 
	
	@Column(name = "data_nascimento", nullable = false)
	private Date dataNascimento;
	
	@Column(name = "cidade", nullable = false)
	private String cidade;
		
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
    private UserRole role;


	public User(int idUsuario, String nome, String email, String login, String password, Date dataNascimento, String cidade, String whatsapp,
			Date dataCompra, ColegioEnum escolaDaProva, UserRole role) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.email = email;
		this.password = password;
		this.dataNascimento = dataNascimento;
		this.cidade = cidade;
		this.whatsapp = whatsapp;
		this.dataCompra = dataCompra;
		this.escolaDaProva = escolaDaProva;
		this.role = role;
	}
	
	public User(String login, String password, UserRole role) {
		this.login = login;
		this.password = password;
		
	}

	public User() {
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

	public void setRole(UserRole role) {
		this.role = role;
	}

	public void setPassword(String senha) {
		this.password = senha;
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


	public UserRole getRole() {
		return role;
	}

	public void setRoles(UserRole role) {
		this.role = role;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		if(this.role == UserRole.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
		else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return login;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	
	
	
	
	
}
