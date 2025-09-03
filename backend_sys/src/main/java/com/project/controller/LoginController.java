package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.request.LoginRequest;
import com.project.service.LoginService;

@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins= {"*"})
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/verify")
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
		return ResponseEntity.ok(loginService.checkLoginCredincials(loginRequest));
	}
	
}