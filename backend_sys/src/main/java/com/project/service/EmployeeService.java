package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Employee;
import com.project.repository.EmployeeRepository;
import com.project.request.EmployeeRequest;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;

	public List<Employee> getEmpDetails() {
		return empRepo.findAll();
	}

	public Optional<Employee> getOneEmpDetails(Integer id) {
		return empRepo.findById(id);
	}

	public void deleteEmpById(Integer id) {
		empRepo.deleteById(id);
	}

	public void updateEmpById(Integer id, EmployeeRequest empRequest) {
		empRepo.findById(id).map(employee -> {
			employee.setEmpDepartment(empRequest.getEmpDepartment());
			employee.setEmpDesignation(empRequest.getEmpDesignation());
			employee.setEmpName(empRequest.getEmpName());
			employee.setEmpEmail(empRequest.getEmpEmail());
			employee.setEmpGender(empRequest.getEmpGender());
			employee.setEmpHeader(empRequest.getEmpHeader());
			employee.setEmpNoOfProjectsDone(empRequest.getEmpNoOfProjectsDone());
			employee.setEmpRole("Employee");
			employee.setEmpOnGoingProject(empRequest.getEmpOnGoingProject());
			employee.setEmpPerformance(empRequest.getEmpPerformance());
			employee.setEmpSalary(empRequest.getEmpSalary());
			return empRepo.save(employee);
		}).orElseThrow(() -> new RuntimeException("Employee not found with id " + id));
	}

}