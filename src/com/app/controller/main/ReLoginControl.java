package com.app.controller.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.app.UI.main.ManagerFrame;
import com.app.UI.main.OperatorFrame;
import com.app.UI.main.ReLogin;

public class ReLoginControl {
	private ReLogin rl;
	public ReLoginControl(){}
	public ReLoginControl(ReLogin rl){
		this.rl = rl;
	}
	
	public void init(){
		save();
		cancel();
	}
	private void cancel() {
		// TODO Auto-generated method stub
		rl.btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				rl.dispose();
			}
		});
		
	}
	private void save() {
		// TODO Auto-generated method stub
		rl.button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int k = Integer.parseInt(rl.textField.getText().trim());
				ManagerFrame.remindTime = k*1000;
				OperatorFrame.remindTime = k*1000;
				ManagerFrame.lastActiveTime = System.currentTimeMillis();
				OperatorFrame.lastActiveTime = System.currentTimeMillis();
				rl.dispose();
			}
		});
		
	}
}
