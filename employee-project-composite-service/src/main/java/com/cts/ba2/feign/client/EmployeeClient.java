package com.cts.ba2.feign.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.ba2.model.Employee;

@FeignClient(url="localhost:8099/employee", name="Employee-Service")
public interface EmployeeClient {

	
	//to get the detail of employee using its id from Employee-Service
	@GetMapping("/user/{id}")
	public Employee getEmployeeById(@PathVariable("id") Long id);
	
	
	//to get the list of all employee tag to project with particular projectId
	@GetMapping("/user/projectId/{pid}")
	public List<Employee> allEmployeeWithProjectId(@PathVariable("pid") Long pid);

}

