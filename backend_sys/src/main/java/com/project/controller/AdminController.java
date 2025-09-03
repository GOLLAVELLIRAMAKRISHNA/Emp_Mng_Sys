package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.project.request.AdminRequest;
import com.project.request.EmployeeRequest;
import com.project.response.AdmRegisterResponse;
import com.project.response.EmpRegisterResponse;
import com.project.service.AdminService;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = { "*" })
public class AdminController {

	@Autowired
	private AdminService adminService;

	@PostMapping("/employee/add")
	public ResponseEntity<EmpRegisterResponse> saveEmployeeDetails(@RequestBody EmployeeRequest empDetails) {
		return new ResponseEntity<EmpRegisterResponse>(adminService.saveEmpDetails(empDetails),HttpStatus.CREATED);
	}

	@PostMapping("/add")
	public ResponseEntity<AdmRegisterResponse> saveAdminDetails(@RequestBody AdminRequest admDetails) {
		return new ResponseEntity<AdmRegisterResponse>(adminService.saveAdmDetails(admDetails),HttpStatus.CREATED);
	}

}