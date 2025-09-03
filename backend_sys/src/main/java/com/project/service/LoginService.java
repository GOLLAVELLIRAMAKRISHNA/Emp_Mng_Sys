package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Admin;
import com.project.entity.Employee;
import com.project.repository.AdminRepository;
import com.project.repository.EmployeeRepository;
import com.project.request.LoginRequest;
import com.project.response.LoginResponse;

@Service
public class LoginService {

	@Autowired
	private EmployeeRepository empRepo;
	
	@Autowired
	private AdminRepository adminRepo;

	public LoginResponse checkLoginCredincials(LoginRequest loginRequest) {
		List<Employee> getallempdetails = empRepo.findAll();
		for(Employee emp:getallempdetails) {
			if(emp.getEmpEmail().compareTo(loginRequest.getEmpEmail())==0&&emp.getEmpPassword().compareTo(loginRequest.getEmpPassword())==0) {
				return LoginResponse.builder()
						.empId(emp.getEmpId())
						.empRole(emp.getEmpRole())
						.build();
			}
		}
		
		List<Admin> getalladmindetails = adminRepo.findAll();
		for(Admin admin:getalladmindetails) {
			if(admin.getEmail().compareTo(loginRequest.getEmpEmail())==0&&admin.getPassword().compareTo(loginRequest.getEmpPassword())==0) {
				return LoginResponse.builder()
						.empId(admin.getUserId())
						.empRole(admin.getRole())
						.build();
			}
		}
		
		return LoginResponse.builder()
				.empId(0)
				.empRole(null)
				.build();
	}
	


}
