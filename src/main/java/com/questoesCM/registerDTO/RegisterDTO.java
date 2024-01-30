package com.questoesCM.registerDTO;

import com.questoesCM.model.UserRole;

public record RegisterDTO(String email, String password, UserRole role) {
		
	

}
