package com.questoesCM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.questoesCM.DAO.UsuarioDAO;
import com.questoesCM.model.Usuario;
import com.questoesCM.registerDTO.RegisterDTO;

import DTO.AuthenticationDTO;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired 
	private UsuarioDAO DAO;
	
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody @Validated  AuthenticationDTO data) {
		
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
		return ResponseEntity.ok().build();
		
	}
	
	@PostMapping("/register")
	public ResponseEntity register(@RequestBody @Validated RegisterDTO data) {
		if(this.DAO.findByEmail(data.email()) !=null) return ResponseEntity.badRequest().build();
		
		String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
		Usuario newUsuario = new Usuario(data.email(), encryptedPassword, data.role());
		
		this.DAO.save(newUsuario);
		
		return ResponseEntity.ok().build();
	}
}
