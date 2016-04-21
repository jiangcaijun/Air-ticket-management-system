package com.app.controller.employeeControl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.app.UI.Manager.EmployeeManager.EmployeeAddDialog;
import com.app.UI.Manager.EmployeeManager.EmployeeUpdateDialog;
import com.app.UI.Manager.EmployeeManager.OperatorPanel;
import com.app.UI.singleton.ManagerSingleton;
import com.app.bean.Employee;

public class OperatorPanellControl extends EmployeeControlModel{
	
	private OperatorPanel op;

	private EmployeeAddDialog ead ;
	
	private EmployeeUpdateDialog eup;
	
	public OperatorPanellControl() {
		super();
	}

	public OperatorPanellControl(OperatorPanel opl){
		this.op = opl;
	}
	
	public void init(){
		setModelType();
		setTable(model, null);
		op.dtm = model;
		query();
		delete();
		add();
		update();
	}
	
	public void query(){
		op.queryButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = op.IDTextField.getText().trim();
				Employee employee = new Employee();
				if(id.equals("")){
					id = null;
				}
				employee.setEmployeeId(id);
				Vector<Employee> ve = edi.queryEmployee(employee);
				vv = new Vector<Vector<Object>>();
				vv = toVector(ve);
				setTable(model, vv);
				op.dtm = model;
			}
		});
	}
	
	public void delete(){
		op.deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int[] rows = op.table.getSelectedRows();
				if(rows.length==0){
					JOptionPane.showMessageDialog(null, "请选定信息行");
				}else{
					int k =JOptionPane.showConfirmDialog(null, "确定删除？");
					System.out.println(k);
					if(k==0){
						int len = rows.length;
						Vector<Employee> e1 = new Vector<Employee>();
						for (int i = 0; i < len; i++) {
							Employee emp = new Employee();
							emp.setEmployeeId((String) op.dtm.getValueAt(rows[i], 0));
							if(!e1.contains(emp)){
								e1.add(emp);
							}
						}
						edi.deleteEmployee(e1);
						int size = op.dtm.getRowCount();
						for (int i = size-1; i >= 0; i--) {
							for (int j = 0; j < len; j++) {
								if(i==rows[j]){
									op.dtm.removeRow(i);
								}
							}
						}
					}
				}
			}
		});
	}
	
	public void add(){
		op.addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(ead==null){
					ead = new EmployeeAddDialog();
				}
				op.setEnabled(false);
				ead.setVisible(true);
			}
		});
	}
	
	public void update(){
		op.updateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int[] rows = op.table.getSelectedRows();
				System.out.println(rows[0]);
				if(rows.length==0){
					JOptionPane.showMessageDialog(null, "请选定信息行");
				}else{
					int len = rows.length;
					Vector<Employee> e1 = new Vector<Employee>();
					vv = new Vector<Vector<Object>>();
					int column = op.dtm.getColumnCount();
					for (int i = 0; i < len; i++) {
						Vector<Object> v = new Vector<Object>();
						for (int j = 0; j < column; j++){
							v.add(op.dtm.getValueAt(rows[i], j));
						}
						vv.addElement(v);
					}
					e1 = toEmployee(vv);
					ManagerSingleton.getInstance().setVv(e1);
					eup  = new EmployeeUpdateDialog();
					op.setEnabled(false);
					eup.setVisible(true);
				}
			}
		});
	}
	
	public void setModelType(){
		model = new DefaultTableModel(){
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				return getValueAt(0, columnIndex).getClass();
			}
		};
	}
}
