package com.app.UI.Manager.FlightManager;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.app.controller.flightControl.FlightPanellControl;

import javax.swing.JTable;
import javax.swing.JScrollPane;

public class FlightPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTextField flightIdTextField;
	public JTextField flightCompanyTextField;
	public JTextField originStationTextField;
	public JTextField TerminalStationTextField;
	public JTable table;
	public DefaultTableModel dtm = new DefaultTableModel();
	public JButton queryButton;
	public JButton deleteButton;
	public JButton addButton;
	public JButton updateButton;

	/**
	 * Create the panel.
	 */
	public FlightPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{93, 93, 93, 93, 0};
		gbl_panel.rowHeights = new int[]{23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0};
		gbl_panel.columnWeights = new double[]{0.5, 1.0, 1.0, 0.5, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{ 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,1.0,1.0};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel_4 = new JLabel("航班号：  ");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 1;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		flightIdTextField = new JTextField();
		GridBagConstraints gbc_flightIdTextField = new GridBagConstraints();
		gbc_flightIdTextField.insets = new Insets(0, 0, 5, 5);
		gbc_flightIdTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_flightIdTextField.gridx = 2;
		gbc_flightIdTextField.gridy = 1;
		panel.add(flightIdTextField, gbc_flightIdTextField);
		flightIdTextField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("航空公司：  ");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 3;
		panel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		flightCompanyTextField = new JTextField();
		GridBagConstraints gbc_flightCompanyTextField = new GridBagConstraints();
		gbc_flightCompanyTextField.insets = new Insets(0, 0, 5, 5);
		gbc_flightCompanyTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_flightCompanyTextField.gridx = 2;
		gbc_flightCompanyTextField.gridy = 3;
		panel.add(flightCompanyTextField, gbc_flightCompanyTextField);
		flightCompanyTextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("出发地：  ");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 5;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		originStationTextField = new JTextField();
		GridBagConstraints gbc_originStationTextField = new GridBagConstraints();
		gbc_originStationTextField.insets = new Insets(0, 0, 5, 5);
		gbc_originStationTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_originStationTextField.gridx = 2;
		gbc_originStationTextField.gridy = 5;
		panel.add(originStationTextField, gbc_originStationTextField);
		originStationTextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("目的地：  ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 7;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		TerminalStationTextField = new JTextField();
		GridBagConstraints gbc_TerminalStationTextField = new GridBagConstraints();
		gbc_TerminalStationTextField.insets = new Insets(0, 0, 5, 5);
		gbc_TerminalStationTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_TerminalStationTextField.gridx = 2;
		gbc_TerminalStationTextField.gridy = 7;
		panel.add(TerminalStationTextField, gbc_TerminalStationTextField);
		TerminalStationTextField.setColumns(10);
		
		queryButton = new JButton("航线查询");
		GridBagConstraints gbc_queryButton = new GridBagConstraints();
		gbc_queryButton.fill = GridBagConstraints.VERTICAL;
		gbc_queryButton.anchor = GridBagConstraints.WEST;
		gbc_queryButton.insets = new Insets(0, 0, 5, 5);
		gbc_queryButton.gridx = 1;
		gbc_queryButton.gridy = 9;
		panel.add(queryButton, gbc_queryButton);
		
		deleteButton = new JButton("航线删除");
		GridBagConstraints gbc_deleteButton = new GridBagConstraints();
		gbc_deleteButton.fill = GridBagConstraints.VERTICAL;
		gbc_deleteButton.anchor = GridBagConstraints.EAST;
		gbc_deleteButton.insets = new Insets(0, 0, 5, 5);
		gbc_deleteButton.gridx = 2;
		gbc_deleteButton.gridy = 9;
		panel.add(deleteButton, gbc_deleteButton);
		
		addButton = new JButton("航线添加");
		GridBagConstraints gbc_addButton = new GridBagConstraints();
		gbc_addButton.fill = GridBagConstraints.VERTICAL;
		gbc_addButton.anchor = GridBagConstraints.WEST;
		gbc_addButton.insets = new Insets(0, 0, 5, 5);
		gbc_addButton.gridx = 1;
		gbc_addButton.gridy = 11;
		panel.add(addButton, gbc_addButton);
		
		updateButton = new JButton("航线编辑");
		GridBagConstraints gbc_updateButton = new GridBagConstraints();
		gbc_updateButton.fill = GridBagConstraints.VERTICAL;
		gbc_updateButton.insets = new Insets(0, 0, 5, 5);
		gbc_updateButton.anchor = GridBagConstraints.EAST;
		gbc_updateButton.gridx = 2;
		gbc_updateButton.gridy = 11;
		panel.add(updateButton, gbc_updateButton);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_3.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(dtm);
		
		FlightPanellControl fudc = new FlightPanellControl(this);
		fudc.init();
		table.setModel(dtm);
	}

}
