package com.cts.ba2.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.ba2.model.Employee;
import com.cts.ba2.service.iEmployeeService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
//	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());

	@Autowired
	iEmployeeService employeeService;
	
	
	
	//to add employee data to the database
	@PostMapping()
	public ResponseEntity<Object>addEmployee(@RequestBody Employee employee) {
		
			employeeService.addEmployee(employee);
			return new ResponseEntity<>("Employee is added successfully", HttpStatus.CREATED);
		}
	
	
	
	//to get the list of employee from database
	@GetMapping()
	@HystrixCommand(fallbackMethod="fallBack1")
	public ResponseEntity<Object> listOfEmployee(){
		logger.info("{}",employeeService.listOfEmployee());
		return new ResponseEntity<>(employeeService.listOfEmployee(), HttpStatus.OK);
	}
	
	
	
	//to get the employee detail using employee id
	@GetMapping("/{id}")
	@HystrixCommand(fallbackMethod="fallBack2")
	public ResponseEntity<Object> getEmployeeById(@PathVariable("id") Long id) {
		logger.info("{}",employeeService.getEmployeeById(id));
		return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
	}
	
	
	
	//to update the employee detail using its id
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
	      
	      employeeService.updateEmployee(id, employee);
	      return new ResponseEntity<>(employeeService.updateEmployee(id, employee), HttpStatus.OK);
	 }
	
	
	
	//to delete the employee detail using its id 
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable("id") Long id) {
	      
	      return new ResponseEntity<>(employeeService.deleteEmployee(id), HttpStatus.OK);
	}
	
	
	//to get all employee details using project id
	@GetMapping("/projectId/{pid}")
	@HystrixCommand(fallbackMethod="fallBack3")
	public ResponseEntity<Object> allEmployeeWithProjectId(@PathVariable("pid") Long pid) {
		logger.info("{}",employeeService.allEmployeeWithProjectId(pid)	);
		return new ResponseEntity<>(employeeService.allEmployeeWithProjectId(pid),HttpStatus.OK);
	}
	
	
	public ResponseEntity<Object> fallBack1(){
		return new ResponseEntity<>(employeeService.listOfEmployee(), HttpStatus.OK);
	}
	
	
	public ResponseEntity<Object> fallBack2(@PathVariable("id") Long id){
		return new ResponseEntity<>(0, HttpStatus.OK);
	}
	
	public ResponseEntity<Object> fallBack3(@PathVariable("pid") Long pid){
		return new ResponseEntity<>(employeeService.listOfEmployee(), HttpStatus.OK);
	}

}
