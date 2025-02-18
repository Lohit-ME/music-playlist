package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	@NotBlank(message="username cannot be blank")
	@Size(min=3,max=16,message="username must be 3 to 16 charcters")
	private String username;
	
	
	
	@NotBlank(message="Password cannot be blank")
	@Size(min=6,message="password must be 6 characters")
	private String password;
	
	
	
	
	@NotBlank(message="ConfirmPassword is required")
	@Size(min=6,message="confirm password must be 6 charctes")
	private String confirmpassword;
	
	
	public boolean isPasswordMatching() {
		return this.password.equals(this.confirmpassword);
	}


//	public Long getId() {
//		return id;
//	}
//
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getConfirmpassword() {
		return confirmpassword;
	}


	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	
}
