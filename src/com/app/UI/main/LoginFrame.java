package com.app.UI.main;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.app.controller.main.LoginFrameControl;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.ButtonGroup;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class LoginFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField employeeIdTextField;
	public JLabel lblNewLabel_1;
	public JLabel lblNewLabel_3;
	public JButton btnNewButton;
	public JRadioButton radioButton;
	private LoginFrameControl lfc;
	public JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setTitle("机票预订系统登录界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize=getToolkit().getScreenSize();               //设置成适应的屏幕大小
		setBounds((int) screenSize.getWidth()/4,(int) screenSize.getHeight()/4,670,370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JLabel lblNewLabel_2 = new JLabel("机票预订系统登录界面");
		lblNewLabel_2.setBounds(233, 43, 212, 35);
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.BOLD, 20));
		lblNewLabel_2.setBackground(Color.BLACK);
		contentPane.add(lblNewLabel_2);
		
		JLabel label = new JLabel("用户编号");
		label.setBounds(195, 115, 93, 35);
		label.setFont(new Font("微软雅黑", Font.BOLD, 20));
		label.setBackground(Color.BLACK);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("密   码");
		label_1.setBounds(195, 174, 93, 35);
		label_1.setFont(new Font("微软雅黑", Font.BOLD, 20));
		label_1.setBackground(Color.BLACK);
		contentPane.add(label_1);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(529, 135, 114, 15);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBounds(529, 194, 114, 15);
		contentPane.add(lblNewLabel_3);
		
		employeeIdTextField = new JTextField();
		employeeIdTextField.setBounds(325, 120, 152, 31);
		employeeIdTextField.setText("请输入用户名");
		employeeIdTextField.setBackground(Color.WHITE);
		contentPane.add(employeeIdTextField);
		employeeIdTextField.setColumns(10);
		
		radioButton = new JRadioButton("管理员");
		radioButton.setBounds(224, 236, 99, 23);
		radioButton.setFont(new Font("微软雅黑", Font.BOLD, 16));
		radioButton.setBackground(SystemColor.activeCaption);
		contentPane.add(radioButton);
		
		JRadioButton radioButton1 = new JRadioButton("操作员");
		radioButton1.setSelected(true);
		radioButton1.setBounds(358, 236, 99, 23);
		radioButton1.setFont(new Font("微软雅黑", Font.BOLD, 16));
		radioButton1.setBackground(SystemColor.activeCaption);
		contentPane.add(radioButton1);
		
	    ButtonGroup entreeGroup = new ButtonGroup(); 
		entreeGroup.add(radioButton);      
		entreeGroup.add(radioButton1);
		
		btnNewButton = new JButton("登录");
		btnNewButton.setBounds(278, 279, 100, 31);
		btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 18));
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setBounds(325, 184, 152, 31);
		contentPane.add(passwordField);
	
		JLabel lblNewLabel = new JLabel("");           //此字段目前来看，须放在程序末尾，保证其为背景图片
		lblNewLabel.setBounds(0, 0, 668, 348);
		lblNewLabel.setIcon(new ImageIcon(LoginFrame.class.getResource("/res/2_2.jpg")));
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(325, 100, 152, 10);
		contentPane.add(panel);
		
		lfc = new  LoginFrameControl();
		lfc.init(this);
	}
}
