package com.app.controller.employeeControl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.app.UI.Manager.EmployeeManager.EmployeeUpdateDialog;
import com.app.UI.singleton.ManagerSingleton;
import com.app.bean.Employee;

public class EmployeeUpdateDailogControl extends EmployeeControlModel{
	private EmployeeUpdateDialog eud;
	
	public EmployeeUpdateDailogControl(){}
	
	public EmployeeUpdateDailogControl(EmployeeUpdateDialog eud){
		this.eud = eud;
	}
	
	public void init(){
		setModelType();
		Vector<Vector<Object>> vv= toVector(ManagerSingleton.getInstance().getVv());
		setTable(model,vv);
		eud.dtm = model;
		save();
		cancel();
		close(eud);
	}
	
	public void save(){
		
		eud.okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean isnull = false;
				if(eud.dtm.getRowCount()==0){
					JOptionPane.showMessageDialog(null, "没有数据");
				}else{
					int row = eud.dtm.getRowCount();
					int column = eud.dtm.getColumnCount();
					vv = new Vector<Vector<Object>>();
					for (int i = 0; i < row; i++) {
						Vector<Object> v = new Vector<Object>();
						for (int j = 0; j < column; j++) {
							Object o = eud.dtm.getValueAt(i, j);
							if(o.equals("")){
								isnull = true;
							}
							v.add(o);
						}
						vv.add(v);
					}
					Vector<Employee> ve = toEmployee(vv);
					if(isnull){
						JOptionPane.showMessageDialog(null, "请将确保已填写所有值！！");
					}else{
						if(eud.table.isEditing()){
							JOptionPane.showMessageDialog(null, "请确保 表格未处于编辑状态！！");
						}else{
							boolean flag = edi.updateEmployee(ve);
							if(flag){
								JOptionPane.showMessageDialog(null, "更新成功");
								ManagerSingleton.getInstance().getMf().setEnabled(true);;
								eud.setVisible(false);
								model = null;
							}else
								JOptionPane.showMessageDialog(null, "更新失败");
						}
					}
				}
			}
		});
	}
	
	private void cancel(){
		eud.cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int k = JOptionPane.showConfirmDialog(null, "确定放弃编辑？");
				if(k==0){
					eud.dispose();
				}
			}
		});
	}
	
	public void setModelType(){
		model = new DefaultTableModel(){
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int row, int column) {
				if(column==0||column==4||column==5) return false;
				else return true;
			}
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				return getValueAt(0, columnIndex).getClass();
			}
		};
	}
	
}
