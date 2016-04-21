package com.app.UI.main;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.app.controller.main.ReLoginControl;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class ReLogin extends JDialog {
	public JButton button;
	public JButton btnNewButton;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public  JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ReLogin dialog = new ReLogin();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ReLogin() {
		setTitle("系统配置");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		button = new JButton("保存");
		button.setBounds(214, 228, 93, 23);
		contentPanel.add(button);
		
		btnNewButton = new JButton("取消");
		btnNewButton.setBounds(331, 228, 93, 23);
		contentPanel.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(129, 86, 75, 23);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("无操作");
		label_1.setFont(new Font("微软雅黑", Font.BOLD, 16));
		label_1.setBounds(51, 76, 80, 41);
		contentPanel.add(label_1);
		
		JLabel lblNewLabel = new JLabel("重新登录");
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblNewLabel.setBounds(278, 139, 113, 23);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("秒后");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblNewLabel_1.setBounds(214, 87, 68, 19);
		contentPanel.add(lblNewLabel_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ReLogin.class.getResource("/res/1.jpg")));
		label.setBounds(0, 0, 458, 275);
		contentPanel.add(label);
		
		ReLoginControl tlc = new ReLoginControl(this);
		tlc.init();
		
	}
}
