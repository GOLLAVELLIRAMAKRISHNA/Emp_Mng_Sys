package com.project.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeRequest {

	private String empName;
	private String empDepartment;
	private String empEmail;
	private Double empSalary;
	private String empGender;
	private String empPassword;
	private String empHeader;
	private Integer empNoOfProjectsDone;
	private String empOnGoingProject;
	private Integer empPerformance;
	private String empDesignation;

}