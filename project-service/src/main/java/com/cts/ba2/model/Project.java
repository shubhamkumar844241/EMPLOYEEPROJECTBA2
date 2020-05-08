package com.cts.ba2.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@NonNull
@Entity
public class Project {
	
	@Id
	@NotNull(message="employee id is not null")
	private Long projectId;
	
	@Size(min=5,message="name atleast have 5 characters")
	@Size(max=20, message="name should not exceed 20 character")
	private String projectName;
	
	@Size(min=5,message="name atleast have 5 characters")
	@Size(max=20, message="name should not exceed 20 character")
	private String projectOwner;

}

