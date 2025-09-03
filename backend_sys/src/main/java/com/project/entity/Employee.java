package com.project.entity;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empId;

	@NotBlank
	private String empName;

	@NotBlank
	private String empDepartment;

	@Email
	private String empEmail;

	@NotBlank
	private String empGender;

	@Size(min = 8)
	private String empPassword;

	@NotNull
	private Double empSalary;

	@NotBlank
	private String empHeader;

	@NotNull
	private Integer empNoOfProjectsDone;

	@NotBlank
	private String empOnGoingProject;

	@NotNull
	private Integer empPerformance;

	@NotBlank
	private String empDesignation;

	private String empRole;

	@CreationTimestamp
	@Column(updatable = false, insertable = true)
	private Date empJoinDate;

}