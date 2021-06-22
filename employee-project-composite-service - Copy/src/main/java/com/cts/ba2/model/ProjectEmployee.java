package com.cts.ba2.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProjectEmployee {
	
	private Long projectId;

	private String projectName;

	private String projectOwner;
	
	private List<Employee> employeeList;


}



