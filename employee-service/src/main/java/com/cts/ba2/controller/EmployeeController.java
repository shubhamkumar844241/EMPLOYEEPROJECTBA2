package com.cts.ba2.controller;



import java.util.List;

import javax.validation.Valid;

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
import com.cts.ba2.service.IEmployeeService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	

	//get logger variable
	private Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	List<Employee> listEmployee;

	@Autowired
	IEmployeeService employeeService;
	
	
	
	//to add employee data to the database
	@PostMapping()
	public ResponseEntity<Object> addEmployee(@Valid @RequestBody Employee employee) {
		
			//loging
			String methodName = "addEmployee()";
			logger.info(methodName+" called");
			
			employeeService.addEmployee(employee);
			return new ResponseEntity<>("Employee is added successfully", HttpStatus.CREATED);
		}
	
	
	
	//to get the list of employee from database
	@GetMapping()
	@HystrixCommand(fallbackMethod="listOfEmployee_Fallback")
	public ResponseEntity<Object> listOfEmployee(){
		
		//loging
		String methodName = "listOfEmployee()";
		logger.info(methodName+" called");
		
		return new ResponseEntity<>(employeeService.listOfEmployee(), HttpStatus.OK);
	}
	
	
	
	//to get the employee detail using employee id
	@GetMapping("/{id}")
	@HystrixCommand(fallbackMethod="getEmployeeById_Fallback")
	public ResponseEntity<Object> getEmployeeById(@PathVariable("id") Long id) {
		
		//loging
		String methodName = "getEmployeeById()";
		logger.info(methodName+" called");
				
		return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
	}
	
	
	
	//to update the employee detail using its id
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateEmployee(@PathVariable("id") Long id, @Valid @RequestBody Employee employee) {
	      
		//loging
		String methodName = "updateEmployee()";
		logger.info(methodName+" called");
				
	    employeeService.updateEmployee(id, employee);
	    return new ResponseEntity<>(employeeService.updateEmployee(id, employee), HttpStatus.OK);
	 }
	
	
	
	//to delete the employee detail using its id 
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable("id") Long id) {
	      
		//loging
		String methodName = "deleteEmployee()";
		logger.info(methodName+" called");
						
	    return new ResponseEntity<>(employeeService.deleteEmployee(id), HttpStatus.OK);
	}
	
	
	//to get all employee details using project id
	@GetMapping("/projectId/{pid}")
	@HystrixCommand(fallbackMethod="allEmployeeWithProjectId_fallBack")
	public ResponseEntity<Object> allEmployeeWithProjectId(@PathVariable("pid") Long pid) {
		
		//loging
		String methodName = "allEmployeeWithProjectId()";
		logger.info(methodName+" called");
		return new ResponseEntity<>(employeeService.allEmployeeWithProjectId(pid),HttpStatus.OK);
	}
	
	
	
	//fallback for method listOfEmployee()
	public ResponseEntity<Object> listOfEmployee_Fallback(){
		
		//loging
		String methodName = "listOfEmployee_Fallback()";
		logger.info(methodName+" called");
		
		Employee employee = new Employee(999L, "fallback", "fallback", 999, 999L);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	
	
	
	//fallback method for getEmployeeById()
	public ResponseEntity<Object> getEmployeeById_Fallback(@PathVariable("id") Long id){
		
		//loging
		String methodName = "getEmployeeById_Fallback()";
		logger.info(methodName+" called");
		
		Employee employee = new Employee(id, "fallback", "fallback", 999, 999L);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	
	
	//fallback method for allEmployeeWithProjectId()
	public ResponseEntity<Object> allEmployeeWithProjectId_fallBack(@PathVariable("pid") Long pid){
		
		//loging
		String methodName = "allEmployeeWithProjectId_fallBack()";
		logger.info(methodName+" called");
		
		Employee employee = new Employee(pid, "fallback", "fallback", 999, 999L);
		listEmployee.add(employee);
		return new ResponseEntity<>(listEmployee, HttpStatus.OK);
	}

}
