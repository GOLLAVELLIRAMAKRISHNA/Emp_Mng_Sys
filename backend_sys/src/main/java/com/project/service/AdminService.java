package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Admin;
import com.project.entity.Employee;
import com.project.repository.AdminRepository;
import com.project.repository.EmployeeRepository;
import com.project.request.AdminRequest;
import com.project.request.EmployeeRequest;
import com.project.response.AdmRegisterResponse;
import com.project.response.EmpRegisterResponse;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private EmployeeRepository empRepo;

	public AdmRegisterResponse saveAdmDetails(AdminRequest adminDetails) {

		List<Admin> getalladmindetails = adminRepository.findAll();
		
		for (Admin admin : getalladmindetails) {
			if (admin.getEmail().compareTo(adminDetails.getEmail()) == 0) {
				return AdmRegisterResponse.builder().code(1).message("Email as already registered...").build();
			}
		}

		adminRepository.save(Admin.builder().email(adminDetails.getEmail()).password(adminDetails.getPassword())
				.userName(adminDetails.getUserName()).role("Admin").build());
		
		return AdmRegisterResponse.builder().code(0).message("Admin is Added...").build();
	}

	public EmpRegisterResponse saveEmpDetails(EmployeeRequest employee) {
		
		List<Employee> getallempdetails = empRepo.findAll();
		
		for (Employee emp : getallempdetails) {
			if (emp.getEmpEmail().compareTo(employee.getEmpEmail()) == 0) {
				return EmpRegisterResponse.builder().code(1).message("Email as already registered...").build();
			}
		}

		empRepo.save(Employee.builder().empName(employee.getEmpName()).empDepartment(employee.getEmpDepartment())
				.empEmail(employee.getEmpEmail()).empSalary(employee.getEmpSalary())
				.empPassword(employee.getEmpPassword()).empGender(employee.getEmpGender())
				.empHeader(employee.getEmpHeader()).empNoOfProjectsDone(employee.getEmpNoOfProjectsDone())
				.empOnGoingProject(employee.getEmpOnGoingProject()).empPerformance(employee.getEmpPerformance())
				.empRole("Employee").empDesignation(employee.getEmpDesignation()).build());
		
		return EmpRegisterResponse.builder().code(0).message("Employee is Added...").build();
	}

}