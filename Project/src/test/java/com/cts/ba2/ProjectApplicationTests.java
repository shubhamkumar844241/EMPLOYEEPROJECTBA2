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

import com.cts.ba2.model.Project;
import com.cts.ba2.repository.ProjectRepository;
import com.cts.ba2.service.ProjectServiceImpl;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProjectApplicationTests {

	@MockBean
	ProjectRepository projectRepository;
	
	@Autowired
	ProjectServiceImpl projectService;
	
	
	
//working for get/post
	@Test
	public void  testfetchProjectList()
	{
		when(projectRepository.findAll()).thenReturn(Stream.of(new Project(20201l,"fsejava","microsoft")).collect(Collectors.toList()));
	
		assertEquals(1,projectService.listOfProject().size());
	}
	
	
	
	
	//Working
	@Test
	public void saveProjectToDBTest() throws Exception
	{
		Project project=new Project(202015l,"html","adobe");
        when(projectRepository.save(project)).thenReturn(project);
		
	}
	
	
	
	//Working
		@Test
		public void fetchProjectByIdTest() 
		{   
			Project project=new Project(202015l,"html","adobe");
	        when(projectRepository.findById(project.getProjectId())).thenReturn(Optional.of(project)).getMock();
		}
	
	
	
	
	
	
	
	
	
	
	//working for delete
	//working for delete
//	
//	@Test
//	public void deleteProjectByIdTest()
//	{
//		Project project=new Project(20202l,"sap","cisco");
//		projectService.deleteProject(project.getProjectId());
//		verify(projectRepository,times(1)).deleteById(20202l);
//	}
//	
	
}

