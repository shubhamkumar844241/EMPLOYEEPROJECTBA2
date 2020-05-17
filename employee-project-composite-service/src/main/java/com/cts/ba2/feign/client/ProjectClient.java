package com.cts.ba2.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.ba2.model.Project;

@FeignClient(url="localhost:8099/project", name="Project-Service")
public interface ProjectClient {

	@GetMapping("/user/{id}")
	public Project getProjectById(@PathVariable("id") Long id);
}


