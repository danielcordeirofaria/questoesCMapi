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

import com.questoesCM.DAO.UserDAO;
import com.questoesCM.DTO.LoginResponseDTO;
import com.questoesCM.DTO.RegisterDTO;
import com.questoesCM.model.User;

import DTO.AuthenticationDTO;
import security.TokenService;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired 
	private UserDAO DAO;
	
	@Autowired
    private TokenService tokenService;
	
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Validated AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
	
	@PostMapping("/register")
	public ResponseEntity register(@RequestBody @Validated RegisterDTO data) {
		if(this.DAO.findByLogin(data.login()) !=null) return ResponseEntity.badRequest().build();
		
		String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
		User newUsuario = new User(data.login(), encryptedPassword, data.role());
		
		this.DAO.save(newUsuario);
		
		return ResponseEntity.ok().build();
	}
}
