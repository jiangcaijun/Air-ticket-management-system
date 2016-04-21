package com.app.controller.employeeControl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.app.UI.Manager.EmployeeManager.EmployeeAddDialog;
import com.app.UI.singleton.ManagerSingleton;
import com.app.bean.Employee;

public class EmployeeAddDialogControl extends EmployeeControlModel{

	private EmployeeAddDialog ead;
	
	public EmployeeAddDialogControl(){}
	
	public EmployeeAddDialogControl(EmployeeAddDialog ead){
		this.ead = ead;
	}
	
	public void init(){
		setModelType();
		setTable(model, null);
		ead.dtm = model;
		add();
		delete();
		save();
		cancel();
		close(ead);
	}
	
	private void add(){
		ead.addNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ead.dtm.addRow(new Object[]{"","",false,false,BigDecimal.valueOf(0),new Date()});
			}
		});
	}
	
	private void delete(){
		ead.deleteNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int[] rows = ead.table.getSelectedRows();
				if(rows.length==0){
					JOptionPane.showMessageDialog(null, "请选定信息行");
				}else{
					int len = rows.length;
					Vector<Employee> e1 = new Vector<Employee>();
					for (int i = 0; i < len; i++) {
						Employee emp = new Employee();
						emp.setEmployeeId((String) ead.dtm.getValueAt(rows[i], 0));
						if(!e1.contains(emp)){
							e1.add(emp);
						}
					}
					edi.deleteEmployee(e1);
					int size = ead.dtm.getRowCount();
					for (int i = size-1; i >= 0; i--) {
						for (int j = 0; j < len; j++) {
							if(i==rows[j]){
								ead.dtm.removeRow(i);
							}
						}
					}
				}
			}
		});
	}
	
	private void save(){
		ead.okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(ead.table.isEditing()){
					JOptionPane.showMessageDialog(null, "请确保表格未处于编辑状态！");
				}else{
					int row = ead.dtm.getRowCount();
					if(row==0){
						JOptionPane.showMessageDialog(null, "没有数据");
					}else{
						boolean isnull = false;
						int column = ead.dtm.getColumnCount();
						vv = new Vector<Vector<Object>>();
						for (int i = 0; i < row; i++) {
							Vector<Object> v = new Vector<Object>();
							for (int j = 0; j < column; j++) {
								Object o = ead.dtm.getValueAt(i, j);
								v.add(o);
								if(o.equals("")){
									isnull = true;
								}
							}
							vv.add(v);
						}
						if(isnull){
							JOptionPane.showMessageDialog(null, "请确保所有数据都已填写！！");
						}else{
							Vector<Employee> ve = toEmployee(vv);
							boolean flag = edi.addEmployee(ve);
							if(flag){
								JOptionPane.showMessageDialog(null, "添加成功");
								ead.setVisible(false);
								ManagerSingleton.getInstance().getMf().setEnabled(true);
							}else
								JOptionPane.showMessageDialog(null, "添加失败");
						}
					}
				}				
			}
		});
	}
	
	private void cancel(){
		ead.cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ead.setVisible(false);
				ManagerSingleton.getInstance().getMf().setEnabled(true);;
			}
		});
	}
	
	public void setModelType(){
		model = new DefaultTableModel(){
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int row, int column) {
				if(column==5||column==4) return false;
				else return true;
			}
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				return getValueAt(0, columnIndex).getClass();
			}
		};
	}
}
