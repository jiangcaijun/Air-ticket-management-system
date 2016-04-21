package com.app.dao;

import java.util.Vector;

import com.app.bean.Employee;

public interface EmployeeDao {
	public boolean login(Employee employee);
	
	public Vector<Employee> queryEmployee(Employee employee);
	
	public boolean addEmployee(Vector<Employee> employee);
	
	public boolean deleteEmployee(Vector<Employee> employee);
	
	public boolean updateEmployee(Vector<Employee> employee);
}
