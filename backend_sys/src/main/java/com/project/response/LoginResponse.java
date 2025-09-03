package com.project.response;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {

	private Integer empId;
	private String empRole;
	
}
