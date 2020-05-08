package com.cts.ba2.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.cts.ba2.feign.client.EmployeeClient;
import com.cts.ba2.feign.client.ProjectClient;
import com.cts.ba2.model.Employee;
import com.cts.ba2.model.EmployeeProject;
import com.cts.ba2.model.Project;
import com.cts.ba2.model.ProjectEmployee;

@RestController

public class FeignController {
	
	@Autowired
	private EmployeeClient employeeClient;
	
	@Autowired
	private ProjectClient projectClient;
	
	
	
	//to get the detail of employee and project to which that employee  tag to
	@GetMapping("/employee/{id}")
	public EmployeeProject employeeWithProject(@PathVariable("id") Long id) {
		
		Employee employee = employeeClient.getEmployeeById(id);
		Long pId = employee.getProjectId();
		Project project = projectClient.getProjectById(pId);
		
		EmployeeProject employeeProject = new EmployeeProject(employee.getEmployeeId(), 
				employee.getEmployeeName(),
				employee.getEmployeeAddress(),
				employee.getEmployeeSallary(),
				employee.getProjectId(),
				project.getProjectName(),
				project.getProjectOwner());

		
				return employeeProject;	
		}
	
	
	
	//to get the detail of project and list of all employee tag to that project
	@GetMapping("/project/{pid}")
	public ProjectEmployee projectWithEmployee(@PathVariable("pid") Long pid) {
		
		Project project = projectClient.getProjectById(pid);
		List<Employee> employeeList = employeeClient.allEmployeeWithProjectId(pid);
		ProjectEmployee projectEmployee = new ProjectEmployee(project.getProjectId(),
		project.getProjectName(),				
		project.getProjectOwner(),				
		employeeList);
		
		return projectEmployee;
	}
	
}
