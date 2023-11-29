package com.example.demo.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import com.example.demo.repo.DepartmentRepository;
@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository dr ;
	@Override
	public void employeeWithDepartment( Department department) {
		// TODO Auto-generated method stub
		//Session session=sf.openSession();
		//session.save(department);
		
		System.out.println("In Service Lear"+department);
		dr.save(department);
	}
	@Override
	public List<Department> getEmployeeDsingDepartment() {
		// TODO Auto-generated method stub
		List<Department> elist=dr.findAll();
		return elist;
	}
	@Override
	public Department updateEmployee(int id, Department department) {
		// TODO Auto-generated method stub
		
	Department d=dr.findById(id)
         .orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + id));
	
	d.setId( department.getId());
	d.setDepartmentName( department.getDepartmentName());
	d.setDepartmentCode( department.getDepartmentCode());
	d.setElist(department.getElist());
		return dr.save(d);
	}
	@Override
	public void deleteDepartment(int id) {
		// TODO Auto-generated method stub
		dr.deleteById(id);
	}

	

}
