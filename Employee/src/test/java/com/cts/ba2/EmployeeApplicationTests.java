package com.cts.ba2;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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


@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeApplicationTests {

	@MockBean
	EmployeeRepository employeeRepository;
	
	@Autowired
	EmployeeServiceImpl employeeservice;
	
	
	@Test
	public void  testfetchEmployeeList()
	{
		when(employeeRepository.findAll()).thenReturn(Stream.of(new Employee(110L,"Divrit","bengaluru",100000,20201l),new Employee(112l,"mani","delhi",6767,20202l)).collect(Collectors.toList()));
	
		assertEquals(2, employeeservice.listOfEmployee().size());
	}
	
	
	
	//Working
		@Test
		public void deleteEmployeeByIdTest()
		{
			Employee employee=new Employee(101l,"delhi","shubham",50000,20201l);
			employeeservice.deleteEmployee(employee.getEmployeeId());
			verify(employeeRepository,times(1)).deleteById(101l);
		}
		
	
	
	
	
	
	
}