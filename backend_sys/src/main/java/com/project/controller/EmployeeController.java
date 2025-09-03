package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.request.EmployeeRequest;
import com.project.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin(origins = { "*" })
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	@GetMapping("/get")
	public ResponseEntity<?> getEmployeeDetails() {
		return ResponseEntity.ok(empService.getEmpDetails());
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<?> getOneEmployeeDetails(@PathVariable Integer id) {
		return ResponseEntity.ok(empService.getOneEmpDetails(id));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmp(@PathVariable Integer id) {
		empService.deleteEmpById(id);
		return ResponseEntity.ok(HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateEmp(@PathVariable Integer id, @RequestBody EmployeeRequest empRequest) {
		empService.updateEmpById(id, empRequest);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}