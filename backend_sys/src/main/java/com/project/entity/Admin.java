package com.project.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	@NotBlank(message="Not Empty")
	private String userName;
	
	@Size(min=8,message="password must be 8 or more")
	private String password;
	
	@Email(message = "Invalid email")
	private String email;
	private String role;
	
}