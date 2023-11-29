package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Department;

public interface DepartmentService {

	public void employeeWithDepartment(Department department);
	
	public List<Department> getEmployeeDsingDepartment();
	
	
	public Department updateEmployee(int id,Department department) ;
		
		
	public void deleteDepartment(int id);
	
	
}
