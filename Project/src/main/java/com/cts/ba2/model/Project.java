package com.cts.ba2.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@NonNull
@Entity
public class Project {
	
	@Id
	private Long projectId;
	
	private String projectName;
	
	private String projectOwner;

}
