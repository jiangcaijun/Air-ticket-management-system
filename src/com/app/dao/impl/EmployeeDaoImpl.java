package com.app.dao.impl;

import java.util.Vector;

import com.app.bean.Employee;
import com.app.dao.EmployeeDao;

public class EmployeeDaoImpl extends BaseDao implements EmployeeDao{
	@Override
	public boolean login(Employee employee) {
		if(employee.getEmployeeId().trim().equals("")||employee.getPassword().trim().equals("")){
			return false;
		}else{
			String sql = "select * from employee where employee_id =? and employee_password=? and is_root=?";
			Employee e = searchOne(sql, Employee.class,new Object[]{employee.getEmployeeId(),
					employee.getPassword(),employee.getIsRoot()});
			if(e==null){
				return false;
			}else{
				return true;
			}
		}
	}
	
	@Override
	public Vector<Employee> queryEmployee(Employee employee) {
		String sql = "select * from employee where 1=1";
		if(employee.getEmployeeId() != null){
			sql += "and employee_Id like '%"+employee.getEmployeeId()+"%'";
		}
		Vector<Employee> result = search(sql, Employee.class, new Object[]{});
		return result;
	}

	@Override
	public boolean addEmployee(Vector<Employee> employee) {
		String sql = "insert into employee (employee_Id,employee_password,"
				+ " is_Root,is_Lock,error_Input,last_Login) ";
		int size = employee.size();
		Object[] obj = new Object[size*6];
		for (int i = 0; i < size; i++) {
			if(i==0){
				sql += " select ?,?,?,?,?,? from dual";
			}else
			sql += " union all "
					+ "select ?,?,?,?,?,? from dual";
			obj[i*6] = employee.get(i).getEmployeeId();
			obj[i*6+1] = employee.get(i).getPassword();
			obj[i*6+2] = employee.get(i).getIsRoot();
			obj[i*6+3] = employee.get(i).getIsLock();
			obj[i*6+4] = employee.get(i).getErrorInput();
			obj[i*6+5] = new java.sql.Date(employee.get(i).getLastLogin().getTime());
		}
		int flag = update(sql, obj);
		if(flag==0){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public boolean deleteEmployee(Vector<Employee> employee) {
		String sql = "delete from employee where employee_Id in (?";
		int size = employee.size();
		Object[] obj = new Object[size];
		if(size!=0){
			obj[0] = employee.get(0).getEmployeeId();
		}
		for (int i = 1; i < size; i++) {
			sql = sql +",?";
			obj[i] = employee.get(i).getEmployeeId();
		}
		sql = sql + ")";
		int flag = update(sql, obj);
		if(flag==0){
			return false;
		}else{
			return true;
		}
	}
	/**
	 * 通过id修改雇员信息
	 */
	@Override
	public boolean updateEmployee(Vector<Employee> employee) {
		int size = employee.size();
		Object[] obj = new Object[size*6];
		String sql = "";
		for (int i = 0; i < size; i++) {
			sql = sql + "update employee set employee_password = ?,"
					+ "is_Root = ?,is_Lock = ?,error_input=?,last_Login = ? where  employee_Id = ?";
			obj[i*6] = employee.get(i).getPassword();
			obj[i*6+1] = employee.get(i).getIsRoot();
			obj[i*6+2] = employee.get(i).getIsLock();
			obj[i*6+3] = employee.get(i).getErrorInput();
			obj[i*6+4] = employee.get(i).getLastLogin();
			obj[i*6+5] = employee.get(i).getEmployeeId();
		}
		System.out.println(sql);
		int flag = update(sql,obj);
		if(flag==0){
			return false;
		}else{
			return true;
		}
	}

}
