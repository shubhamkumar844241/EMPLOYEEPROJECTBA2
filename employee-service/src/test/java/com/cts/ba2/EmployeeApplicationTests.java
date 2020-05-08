package com.cts.ba2;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.ba2.model.Employee;
import com.cts.ba2.repository.EmployeeRepository;
import com.cts.ba2.service.EmployeeServiceImpl;

//for link between spring boot test feature and junit
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeApplicationTests {

	//mocking repository to test method
	@MockBean
	EmployeeRepository employeeRepository;
	
	@Autowired
	EmployeeServiceImpl employeeservice;
	
	
	//test to get all employee
	@Test
	public void  testfetchEmployeeList()
	{
		when(employeeRepository.findAll()).thenReturn(Stream.of(new Employee(110L,"Divrit","bengaluru",100000,20201l),new Employee(112l,"mani","delhi",6767,20202l)).collect(Collectors.toList()));
	
		assertEquals(2, employeeservice.listOfEmployee().size());
	}
	
	
	
	//test to save employee details
	@Test
	public void saveEmployeeToDBTest() throws Exception
	{
		Employee employee=new Employee(112l,"rajput","delhi",10000,20207l);
        when(employeeRepository.save(employee)).thenReturn(employee);
		
	}
	
	
	
		//test to get employee detail using its id
		@Test
		public void fetchEmployeeByIdTest() 
		{   
			Employee employee=new Employee(115l,"srk","mumbai",100000,20209l);
	        when(employeeRepository.findById(employee.getEmployeeId())).thenReturn(Optional.of(employee)).getMock();
		}
	
}
