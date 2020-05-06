package com.cts.ba2.controller;

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
import com.cts.ba2.service.iProject;

@RestController
@RequestMapping("/project")
public class ProjectController {
	private Logger logger=LoggerFactory.getLogger(this.getClass());

	@Autowired
	iProject projectService;
	
	
	//to add project detail
	@PostMapping()
	public ResponseEntity<Object> addProject(@RequestBody Project project) {
		
		projectService.addProject(project);
			return new ResponseEntity<>("Project is added successfully", HttpStatus.CREATED);
	}
	
	
	
	//to get list of project
	@GetMapping()
	public ResponseEntity<Object> listOfProject(){
		logger.info("{}",projectService.listOfProject());
		return new ResponseEntity<>(projectService.listOfProject(), HttpStatus.OK);
	}
	
	
	
	//to get project detail using project project id
	@GetMapping("/{id}")
	public ResponseEntity<Object> getProjectById(@PathVariable("id") Long id) {
		logger.info("{}",projectService.getProjectById(id));
		return new ResponseEntity<>(projectService.getProjectById(id), HttpStatus.OK);
	}
	
	
	
	//to update project details using project id
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateProject(@PathVariable("id") Long id, @RequestBody Project project) {
	      
	      projectService.updateProject(id, project);
	      return new ResponseEntity<>(projectService.updateProject(id, project), HttpStatus.OK);
	 }
	
	
	//to delete project detail using project id
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteProject(@PathVariable("id") Long id) {
	      
	      return new ResponseEntity<>(projectService.deleteProject(id), HttpStatus.OK);
	}
	  
	 

}
