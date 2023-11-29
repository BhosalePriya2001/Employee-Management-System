package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String departmentName;
	
	private int departmentCode;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "e_id")
	private List<Employee> elist=new ArrayList<Employee>();
	



	public List<Employee> getElist() {
		return elist;
	}



	public void setElist(List<Employee> elist) {
		this.elist = elist;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getDepartmentName() {
		return departmentName;
	}



	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}



	public int getDepartmentCode() {
		return departmentCode;
	}



	public void setDepartmentCode(int departmentCode) {
		this.departmentCode = departmentCode;
	}



	@Override
	public String toString() {
		return "Department [id=" + id + ", departmentName=" + departmentName + ", departmentCode=" + departmentCode
				+ ", elist=" + elist + "]";
	}


	
}
