package com.cts.ba2.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@NonNull
@ApiModel(description="All details about the Employee")
public class Employee {
	
	@Id
	@NotNull(message="employee id is not null")
	private Long employeeId;
	
	@Size(min=5,message="name atleast have 5 characters")
	@Size(max=20, message="name should not exceed 20 character")
	private String employeeName;

	@Size(min=5,message="name atleast have 5 characters")
	@Size(max=40, message="address should not exceed 40 character")
	private String employeeAddress;
	
	@NotNull(message="employee sallary should not be null")
	private int employeeSalary;
	
	@NotNull(message="project id shuold not be null")
	private long projectId;

}


