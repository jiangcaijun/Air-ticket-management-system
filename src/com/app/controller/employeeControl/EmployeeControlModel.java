package com.app.controller.employeeControl;

import java.awt.Dialog;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

import com.app.UI.singleton.ManagerSingleton;
import com.app.bean.Employee;
import com.app.dao.impl.EmployeeDaoImpl;

public class EmployeeControlModel {
	public EmployeeDaoImpl edi = new EmployeeDaoImpl();
	public DefaultTableModel model;
	public Vector<Vector<Object>> vv;
	public static Vector<String> columnIdentifiers;
	static{
		columnIdentifiers = new Vector<String>();
		columnIdentifiers.add("操作员编号");
		columnIdentifiers.add("密码");
		columnIdentifiers.add("是否管理员");
		columnIdentifiers.add("是否锁定");
		columnIdentifiers.add("误操作次数");
		columnIdentifiers.add("最后登录时间");
	}
	
	public void setTable(DefaultTableModel dtm,Vector<Vector<Object>> vv){
		dtm.setDataVector(vv,columnIdentifiers );	
	}
	
	public void close(Dialog d){
		d.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				ManagerSingleton.getInstance().getMf().setEnabled(true);
			}
		});
	}
	
	public Vector<Employee> toEmployee(Vector<Vector<Object>> vv){
		int size = vv.size();
		Vector<Employee> ve = new Vector<Employee>();
		for (int i = 0; i < size; i++) {
			Employee e = new Employee();
			e.setEmployeeId((String)vv.get(i).get(0));	
			e.setPassword((String)vv.get(i).get(1));
			if((Boolean)vv.get(i).get(2))
				e.setIsRoot("1");
			else
				e.setIsRoot("0");
			if((Boolean)vv.get(i).get(3))
				e.setIsLock("1");
			else
				e.setIsLock("0");
			e.setErrorInput((BigDecimal)vv.get(i).get(4));
			e.setLastLogin((Date)vv.get(i).get(5));
			ve.add(e);
		}
		return ve;
	}
	
	public Vector<Vector<Object>> toVector(Vector<Employee> ve){
		int size = ve.size();
		vv = new Vector<Vector<Object>>();
		for (int i = 0; i < size; i++) {
			Employee e = ve.get(i);
			Vector<Object> v = new Vector<Object>();
			v.add(e.getEmployeeId());
			v.add(e.getPassword());
			boolean root=false;
			if(e.getIsRoot().equals("1")){
				root = true;
			}else{
				root = false;
			}
			v.add(root);
			boolean lock=false;
			if(e.getIsLock().equals("1")){
				lock = true;
			}else{
				lock = false;
			}
			v.add(lock);
			v.add(e.getErrorInput());
			v.add(e.getLastLogin());
			vv.add(v);
		}
		return vv;
	}
	
}
