package com.cts.ba2.service;

import java.util.List;
import java.util.Optional;

import com.cts.ba2.model.Employee;

public interface IEmployeeService {

	public void addEmployee(Employee employee);

	public  List<Employee> listOfEmployee();
	
	public Optional<Employee> getEmployeeById(Long id);

	public String updateEmployee(Long id, Employee employee);

	public String deleteEmployee(Long id);
	
	public List<Employee> allEmployeeWithProjectId(Long id);
	

}
