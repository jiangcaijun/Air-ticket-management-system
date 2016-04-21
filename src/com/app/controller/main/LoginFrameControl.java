package com.app.controller.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JOptionPane;

import com.app.UI.main.LoginFrame;
import com.app.UI.main.ManagerFrame;
import com.app.UI.main.OperatorFrame;
import com.app.UI.singleton.ManagerSingleton;
import com.app.UI.singleton.OperatorSingleton;
import com.app.bean.Employee;
import com.app.dao.impl.EmployeeDaoImpl;

public class LoginFrameControl {
	
	private EmployeeDaoImpl edi = new EmployeeDaoImpl();
	OperatorSingleton mySingleton = OperatorSingleton.getInstance();    //单例模式
	public void init(LoginFrame lf){
		checkPassword(lf);
		checkName(lf);
		login(lf);
		
	}
	
	public void checkPassword(LoginFrame lf){		
		lf.passwordField.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				char[] pass = lf.passwordField.getPassword();
				String s = new String(pass);
				if(s.trim().equals("")){
					lf.lblNewLabel_3.setText("密码未输入！！");
					lf.passwordField.setText("请输入密码");
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				lf.passwordField.setText("");
				lf.lblNewLabel_3.setText("");
			}
		});
	}
	
	public void checkName(LoginFrame lf){
		lf.employeeIdTextField.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if(lf.employeeIdTextField.getText().trim().equals("")){
					lf.lblNewLabel_1.setText("用户名未输入！！");
					lf.employeeIdTextField.setText("请输入用户名");
				}else{
					
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				lf.employeeIdTextField.setText("");
				lf.lblNewLabel_1.setText("");
			}
		});;
	}
	
	public void login(LoginFrame lf){
		lf.btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				char[] pass = lf.passwordField.getPassword();
				String s = new String(pass);
				if(lf.employeeIdTextField.getText().trim().equals("")||s.trim().equals("")){
					JOptionPane.showMessageDialog(null, "请填写用户名和密码");
				}else{
					Employee e = new Employee();
					e.setEmployeeId(lf.employeeIdTextField.getText().trim());
					e.setPassword(s);
					if(lf.radioButton.isSelected()){
						e.setIsRoot("1");
					}else{
						e.setIsRoot("0");
					}
					boolean flag = edi.login(e);
					if(flag){
						String username = lf.employeeIdTextField.getText().trim();
						if(lf.radioButton.isSelected()){
							ManagerSingleton.getInstance().setUsername(username);
							ManagerSingleton.getInstance().setLf(lf);
							lf.employeeIdTextField.setText("");
							lf.passwordField.setText("");
							ManagerFrame mf = new ManagerFrame();
							lf.setVisible(false);
							mf.setVisible(true);
						}else{
							mySingleton.setLoginFrameUserName(username);
							OperatorSingleton.getInstance().setLoginFrame(lf);
							OperatorFrame of = new OperatorFrame();
							lf.employeeIdTextField.setText("");
							lf.passwordField.setText("");
							lf.setVisible(false);
							of.setVisible(true);
						}
					}else{
						JOptionPane.showMessageDialog(null, "请确认用户名、密码和用户权限是否正确");
						
					}
				}
			}
		});
	}
}
