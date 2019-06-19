package com.helpezee.microservices.EurekaServiceRegistryAndDiscovery.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EmpTable")
public class Employee {
	
	@GeneratedValue()
	@Id
	private int empno;
	
	private String name;
	private double salary;
	private double com;
	private String project;
	private Date bdate;

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getCom() {
		return com;
	}

	public void setCom(double com) {
		this.com = com;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public Date getBdate() {
		return bdate;
	}

	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}

	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", name=" + name + ", salary=" + salary + ", com=" + com + ", project=" + project
				+ ", bdate=" + bdate + "]";
	}

}
