package com.cts.ba2.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeId;
	@Size(min=2,message="Name should be atleast 2 characters")
	private String employeeName;
	@Past
	@ApiModelProperty(notes="BirthDay should be in past")
	private String employeeAddress;
	
	private int employeeSalary;
	
	private long projectId;

}


