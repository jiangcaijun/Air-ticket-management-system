package com.app.UI.Manager.EmployeeManager;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.app.controller.employeeControl.EmployeeAddDialogControl;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class EmployeeAddDialog extends JDialog {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	public DefaultTableModel dtm = new DefaultTableModel() ;
	public JButton deleteNewButton;
	public JButton addNewButton;
	public JButton okButton;
	public JButton cancelButton;
	private final JPanel contentPanel = new JPanel();
	public JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			EmployeeAddDialog dialog = new EmployeeAddDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public EmployeeAddDialog() {
		setBounds(100, 100, 600, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.EAST);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{57, 0};
			gbl_panel.rowHeights = new int[]{23, 0, 0, 0, 0, 0, 0, 0};
			gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			{
				addNewButton = new JButton("添加记录");
				GridBagConstraints gbc_addNewButton = new GridBagConstraints();
				gbc_addNewButton.fill = GridBagConstraints.BOTH;
				gbc_addNewButton.insets = new Insets(0, 0, 5, 0);
				gbc_addNewButton.gridx = 0;
				gbc_addNewButton.gridy = 1;
				panel.add(addNewButton, gbc_addNewButton);
			}
			{
				deleteNewButton = new JButton("删除记录");
				GridBagConstraints gbc_deleteNewButton = new GridBagConstraints();
				gbc_deleteNewButton.insets = new Insets(0, 0, 5, 0);
				gbc_deleteNewButton.fill = GridBagConstraints.BOTH;
				gbc_deleteNewButton.gridx = 0;
				gbc_deleteNewButton.gridy = 4;
				panel.add(deleteNewButton, gbc_deleteNewButton);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					table = new JTable();
					scrollPane.setViewportView(table);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("批量添加");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("取消");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		EmployeeAddDialogControl eadc = new EmployeeAddDialogControl(this);
		eadc.init();

		table.setModel(dtm);
	}

}
