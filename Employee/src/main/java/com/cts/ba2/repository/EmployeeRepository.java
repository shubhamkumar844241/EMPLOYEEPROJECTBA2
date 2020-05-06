package com.cts.ba2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.ba2.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	
//	@Query(value = "select * from Employee e where e.projectId = :id", nativeQuery = true)
//	List<Employee> findAllByProjectId(@Param("id") Long id);
	
	@Query(value = "select * from Employee as e where e.project_Id = ?1", nativeQuery = true)
	List<Employee> findAllByProjectId(Long id);

}
