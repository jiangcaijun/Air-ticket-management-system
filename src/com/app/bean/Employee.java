package com.app.bean;
import java.math.BigDecimal;
import java.util.Date;

public class Employee {
	private String employeeId ;
	private String employeePassword;
	private String isRoot;
	private String isLock;//1锁定，0 不锁定
	private BigDecimal errorInput;//输入失败5次锁定账户
	private Date lastLogin;//记录最后一次登录时间，配合输入失败使用
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getPassword() {
		return employeePassword;
	}
	public void setPassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}
	public String getIsRoot() {
		return isRoot;
	}
	public void setIsRoot(String isRoot) {
		this.isRoot = isRoot;
	}
	public String getIsLock() {
		return isLock;
	}
	public void setIsLock(String isLock) {
		this.isLock = isLock;
	}
	public BigDecimal getErrorInput() {
		return errorInput;
	}
	public void setErrorInput(BigDecimal errorInput) {
		this.errorInput = errorInput;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	
	public Employee(String employeeId, String employeePassword, String isRoot) {
		super();
		this.employeeId = employeeId;
		this.employeePassword = employeePassword;
		this.isRoot = isRoot;
	}
	
	public Employee() {
	}

}
