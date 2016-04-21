package com.app.UI.singleton;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import com.app.UI.main.LoginFrame;
import com.app.UI.main.ManagerFrame;
import com.app.bean.Employee;
import com.app.bean.Flight;

public class ManagerSingleton {
	private static ManagerSingleton singleton;
	private Vector<Employee> vv;
	private String username;
	private DefaultTableModel dtm;
	private ManagerFrame mf;
	private Vector<Flight> vf;
	private LoginFrame lf;
	private boolean date;
	private ManagerSingleton(){}
	
	public static synchronized ManagerSingleton getInstance(){
		if(singleton==null){
			singleton = new ManagerSingleton();
		}
		return singleton;
	}

	public Vector<Employee> getVv() {
		return vv;
	}

	public void setVv(Vector<Employee> vv) {
		this.vv = vv;
	}

	public DefaultTableModel getDtm() {
		return dtm;
	}

	public void setDtm(DefaultTableModel dtm) {
		this.dtm = dtm;
	}

	public ManagerFrame getMf() {
		return mf;
	}

	public void setMf(ManagerFrame mf) {
		this.mf = mf;
	}

	public Vector<Flight> getVf() {
		return vf;
	}

	public void setVf(Vector<Flight> vf) {
		this.vf = vf;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public LoginFrame getLf() {
		return lf;
	}

	public void setLf(LoginFrame lf) {
		this.lf = lf;
	}

	public boolean isDate() {
		return date;
	}

	public void setDate(boolean date) {
		this.date = date;
	}
	
	
}
