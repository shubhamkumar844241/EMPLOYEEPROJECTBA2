package com.cts.ba2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Project {
	
    private Long projectId;
	
	private String projectName;
	
	private String projectOwner;

}
