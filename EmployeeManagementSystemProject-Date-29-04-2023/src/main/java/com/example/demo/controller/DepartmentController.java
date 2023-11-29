package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import com.example.demo.service.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService ds;
	
	@PostMapping(value = "/addData")
	public String addEmployeeData(@RequestBody Department department) {
		System.out.println("controller Lear.."+department);
		ds.employeeWithDepartment(department);
		
		return "Employee And Department Added";
	}
	
	@GetMapping(value = "/getData")
    public ResponseEntity<List<Department>> getAllEmployees() {
        List<Department> employees = ds.getEmployeeDsingDepartment();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
	
	 @PutMapping(value = "/{id}")
	    public ResponseEntity<Department> updateEmployee(@PathVariable int id, @RequestBody Department department) {
	       Department d= ds.updateEmployee(id, department);
	        return new ResponseEntity<>(d, HttpStatus.OK);
}
	 @DeleteMapping(value = "/{id}")
	    public ResponseEntity<Void> deleteDepartment(@PathVariable int id) {
	       ds.deleteDepartment(id);
	       System.out.println("delete department");
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
}