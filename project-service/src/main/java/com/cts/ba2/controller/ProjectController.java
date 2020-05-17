package com.cts.ba2.controller;

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
import com.cts.ba2.model.Project;
import com.cts.ba2.service.IProjectService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ProjectController {
	
	//get logger variable
	private Logger logger = LoggerFactory.getLogger(ProjectController.class);


	@Autowired
	IProjectService projectService;
	
	
	//to add project detail
	@PostMapping("/admin")
	public ResponseEntity<Object> addProject(@Valid @RequestBody Project project) {
		
		//loging
		String methodName = "addProject()";
		logger.info(methodName+" called");
		
		projectService.addProject(project);
		return new ResponseEntity<>("Project is added successfully", HttpStatus.CREATED);
	}
	
	
	
	//to get list of project
	@GetMapping("/user")
	@HystrixCommand(fallbackMethod="listOfProject_Fallback")
	public ResponseEntity<Object> listOfProject(){
		
		//loging
		String methodName = "listOfProject()";
		logger.info(methodName+" called");

		return new ResponseEntity<>(projectService.listOfProject(), HttpStatus.OK);
	}
	
	
	
	//to get project detail using project project id
	@GetMapping("/user/{id}")
	@HystrixCommand(fallbackMethod="getProjectById_Fallback")
	public ResponseEntity<Object> getProjectById(@PathVariable("id") Long id) {
		
		//loging
		String methodName = "getProjectById()";
		logger.info(methodName+" called");

		return new ResponseEntity<>(projectService.getProjectById(id), HttpStatus.OK);
	}
	
	
	
	//to update project details using project id
	@PutMapping("/admin/{id}")
	public ResponseEntity<Object> updateProject(@PathVariable("id") Long id, @Valid @RequestBody Project project) {
	      
		//loging
		String methodName = "updateProject()";
		logger.info(methodName+" called");

	    projectService.updateProject(id, project);
	    return new ResponseEntity<>(projectService.updateProject(id, project), HttpStatus.OK);
	 }
	
	
	//to delete project detail using project id
	@DeleteMapping("/admin/{id}")
	@HystrixCommand(fallbackMethod="deleteProject_Fallback")
	public ResponseEntity<Object> deleteProject(@PathVariable("id") Long id) {
		
		//loging
		String methodName = "deleteProject()";
		logger.info(methodName+" called");

	    return new ResponseEntity<>(projectService.deleteProject(id), HttpStatus.OK);
	} 
	
	
	//fallback method of listOfProject()
	public ResponseEntity<Object> listOfProject_Fallback() {
		
		//loging
		String methodName = "listOfProject_Fallback()";
		logger.info(methodName+" called");
		
		Project project = new Project(999L, "fallback", "fallback");
		return new ResponseEntity<>(project, HttpStatus.OK);
	}
	
	
	//fallback method of getProjectById()
	public ResponseEntity<Object> getProjectById_Fallback(@PathVariable("id") Long id) {
			
		//loging
		String methodName = "getProjectById_Fallback()";
		logger.info(methodName+" called");
		
		Project project = new Project(id, "fallback", "fallback");
		return new ResponseEntity<>(project, HttpStatus.OK);
	}
	

}
