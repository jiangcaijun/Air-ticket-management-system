package com.app.UI.Manager.EmployeeManager;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.app.controller.employeeControl.OperatorPanellControl;
public class OperatorPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private static final long serialVersionUID = 1L;
	public JTextField IDTextField;
	public JTable table;
	public JLabel lblNewLabel_5;
	public JButton queryButton;
	public JButton addButton;
	public JButton updateButton;
	public JButton deleteButton;
	public DefaultTableModel dtm = new DefaultTableModel();
	private JLabel lblNewLabel;
	
	public OperatorPanel() {
		setDtm();
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_3.add(panel_2, BorderLayout.SOUTH);
		
		lblNewLabel_5 = new JLabel("操作员ID：  ");
		panel_2.add(lblNewLabel_5);
		
		IDTextField = new JTextField();
		panel_2.add(IDTextField);
		IDTextField.setColumns(10);
		
		lblNewLabel = new JLabel("                  ");
		panel_2.add(lblNewLabel);
		
		queryButton = new JButton("查询信息");
		panel_2.add(queryButton);
		
		addButton = new JButton("添加记录");
		panel_2.add(addButton);
		
		deleteButton = new JButton("删除记录");
		panel_2.add(deleteButton);
		
		updateButton = new JButton("修改记录");
		panel_2.add(updateButton);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_3.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		OperatorPanellControl opc = new OperatorPanellControl(this);
		opc.init();
		
		table.setModel(dtm);
	}
	
	public void setDtm(){
		dtm = new DefaultTableModel(){
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
