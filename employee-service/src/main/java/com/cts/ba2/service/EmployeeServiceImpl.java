package com.cts.ba2.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cts.ba2.exception.EmployeeNotFoundException;
import com.cts.ba2.model.Employee;
import com.cts.ba2.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
	
	//get logger variable
	private Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
		
	@Autowired
	EmployeeRepository employeeRepository;
	

	//to add employee data to the database
	@Override
	public void addEmployee(Employee employee) {
		

		//loging
		String methodName = "addEmployeeService()";
		logger.info(methodName+" called");
		
		employeeRepository.save(employee);
	}


	//to get the list of employee from database
	@Override
	public List<Employee> listOfEmployee() {
		

		//loging
		String methodName = "listOfEmployeeService()";
		logger.info(methodName+" called");
		
		return employeeRepository.findAll();
	}
	
	
	
	//to get employee data using id
	@Override
	public Optional<Employee> getEmployeeById(Long id) {
		
		//loging
		String methodName = "getEmployeeByIdService()";
		logger.info(methodName+" called");
				
		if(employeeRepository.findById(id).isPresent()) {
			return employeeRepository.findById(id);
		}
		
		else {
			throw new EmployeeNotFoundException("Employee ID : "+id+" Not Found");
		}
	}
		
	
	
	
	//to update the employee detail using its id
	@Override
	public String updateEmployee(Long id, Employee employee) {
	
		//loging
		String methodName = "updateEmployeeService()";
		logger.info(methodName+" called");
				
		if(employeeRepository.findById(id).isPresent()) {
			
			Employee existingEmployee = employeeRepository.findById(id).get();
			existingEmployee.setEmployeeAddress(employee.getEmployeeAddress());
			existingEmployee.setEmployeeName(employee.getEmployeeName());
			existingEmployee.setEmployeeSalary(employee.getEmployeeSalary());
			existingEmployee.setProjectId(employee.getProjectId());
			
			employeeRepository.save(existingEmployee);
			return "Employee with id "+id+" is updated";
		}
		
		else {
			throw new EmployeeNotFoundException("Employee ID : "+id+" Not Found");
			
		}
	}
	
	
	//to delete the employee detail using its id 
	@Override
	public String deleteEmployee(Long id) {
		
		//loging
		String methodName = "deleteEmployeeService()";
		logger.info(methodName+" called");
				
		if(employeeRepository.findById(id).isPresent()) {
			employeeRepository.deleteById(id);
			
			return "Employee id with "+id+" is deleted";
		}
		
		else {
			throw new EmployeeNotFoundException("Employee ID : "+id+" Not Found");
			
		}		
	}
	
	
	
	//to get the list of employee with given project id
	@Override
	public List<Employee> allEmployeeWithProjectId(Long id) {
		
		//loging
		String methodName = "allEmployeeWithProjectIdService()";
		logger.info(methodName+" called");
				
		return employeeRepository.findAllByProjectId(id);
		
	}
}
