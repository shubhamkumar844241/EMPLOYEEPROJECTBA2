package com.cts.ba2.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.ba2.exception.ProjectNotFoundException;
import com.cts.ba2.model.Project;
import com.cts.ba2.repository.ProjectRepository;



@Service
public class ProjectServiceImpl implements IProjectService{
	
	//get logger variable
	private Logger logger = LoggerFactory.getLogger(ProjectServiceImpl.class);
		
	@Autowired
	ProjectRepository projectRepository;

	
	//to add project detail
	@Override
	public void addProject(Project project) {
		
		//loging
		String methodName = "addProjectService()";
		logger.info(methodName+" called");
		
		projectRepository.save(project);
	}

	
	//to get list of project
	@Override
	public List<Project> listOfProject() {
		
		//loging
		String methodName = "listOfProjectService()";
		logger.info(methodName+" called");
		return projectRepository.findAll();
	}
	
	
	
	//to get project detail using project id
	@Override
	public Optional<Project> getProjectById(Long id) {
		
		//loging
		String methodName = "getProjectByIdService()";
		logger.info(methodName+" called");
		
		if(projectRepository.findById(id).isPresent()) {
			return projectRepository.findById(id);
		}
		
		else {
			throw new ProjectNotFoundException("Project id : "+id+" does not exist.");
		}
	}
	
	
	
	//to update project details using project id
	@Override
	public String updateProject(Long id, Project project) {
		
		//loging
		String methodName = "updateProjectService()";
		logger.info(methodName+" called");

		if(projectRepository.findById(id).isPresent()) {
			
			Project existingProject = (Project) projectRepository.findById(id).get();
			existingProject.setProjectName(project.getProjectName());
			existingProject.setProjectOwner(project.getProjectOwner());
			
			projectRepository.save(existingProject);
			
			return "Project with id "+id+" is updated";
		}
		
		else {
			throw new ProjectNotFoundException("Project id : "+id+" does not exist.");
		}
	}
	
	
	//to delete project detail using project id
	@Override
	public String deleteProject(Long id) {
		
		//loging
		String methodName = "deleteProjectService()";
		logger.info(methodName+" called");
		
		if(projectRepository.findById(id).isPresent()) {
			projectRepository.deleteById(id);
			
			return "project id with "+id+" is deleted";
		}
		
		else {
			throw new ProjectNotFoundException("Project id : "+id+" does not exist");
		}
		
	}
	
}
