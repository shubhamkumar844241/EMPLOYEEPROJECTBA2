package com.cts.ba2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeProject {
	
	private Long employeeId;
	
	private String employeeName;
	
	private String employeeAddress;
	
	private int employeeSallary;
	
	private Long projectId;
	
	private String projectName;
	
	private String projectOwner;

}