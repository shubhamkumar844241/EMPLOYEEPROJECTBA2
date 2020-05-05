package com.cts.ba2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.ba2.exception.ProjectNotFoundException;
import com.cts.ba2.model.Project;
import com.cts.ba2.repository.ProjectRepository;



@Service
public class ProjectServiceImpl implements iProject{
	
	@Autowired
	ProjectRepository projectRepository;

	
	//to add project detail
	@Override
	public void addProject(Project project) {
		
		projectRepository.save(project);
	}

	
	//to get list of project
	@Override
	public List<Project> listOfProject() {
		// TODO Auto-generated method stub
		return projectRepository.findAll();
	}
	
	
	
	//to get project detail using project id
	@Override
	public Optional<Project> getProjectById(Long id) {
		
		if(projectRepository.findById(id).isPresent()) {
			return projectRepository.findById(id);
		}
		
		else {
			return null;
		}
	}
	
	
	
	//to update project details using project id
	@Override
	public String updateProject(Long id, Project project) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		if(projectRepository.findById(id).isPresent()) {
			projectRepository.deleteById(id);
			
			return "project id with "+id+" is deleted";
		}
		
		else {
			throw new ProjectNotFoundException("Project id : "+id+" does not exist");
		}
		
	}
	
}
