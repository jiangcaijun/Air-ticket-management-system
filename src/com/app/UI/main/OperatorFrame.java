package com.app.UI.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.app.UI.operator.Discount;
import com.app.UI.operator.IssuePanel;
import com.app.UI.operator.ListQuery;
import com.app.UI.operator.OperatorPanelLineChart;
import com.app.UI.operator.RefundPanel;
import com.app.UI.operator.SalesQuery;
import com.app.UI.singleton.OperatorSingleton;
import com.app.utils.TipTest;

public class OperatorFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private IssuePanel issuePanel=null;
	private RefundPanel refundPanel=null;
	private OperatorPanelLineChart operatorPanelLineChart;
	private SalesQuery salesQuery=null;
	private ListQuery listQuery=null;
	private Discount discount=null;
	public static long lastActiveTime ;
	public static long remindTime;
	OperatorSingleton mySingleton = OperatorSingleton.getInstance();              //单例模式
	public ReLogin rl;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OperatorFrame frame = new OperatorFrame();
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
	public OperatorFrame() {
		lastActiveTime = System.currentTimeMillis();
		OperatorSingleton.getInstance().setOp(this);
		setTitle("操作员界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(150, 150, 900, 600);
		Dimension screenSize=getToolkit().getScreenSize();               //设置成适应的屏幕大小
		setBounds(0,0,(int) screenSize.getWidth(),(int) screenSize.getHeight());
		setResizable(true);
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("系统管理");
		menu.setMnemonic('A');
		menuBar.add(menu);
		
		menu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(rl==null){
					rl = new ReLogin();
				}
				rl.setVisible(true);
			}
		});
		
		JMenuItem mntmNewMenuItem = new JMenuItem("系统配置");
		//mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke("F1"));
		menu.add(mntmNewMenuItem);
		
		mntmNewMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(rl==null){
					rl = new ReLogin();
				}
				rl.setVisible(true);
			}
		});
		
		JSeparator separator = new JSeparator();
		menu.add(separator);
		
		JMenuItem menuItem_1 = new JMenuItem("退出系统");
		//menuItem_1.setAccelerator(KeyStroke.getKeyStroke((char)KeyEvent.VK_E));
		menu.add(menuItem_1);
		
		JMenu menu_2 = new JMenu("基本业务");
		menuBar.add(menu_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("出票");
		
		menu_2.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("退票");
	
		menu_2.add(mntmNewMenuItem_4);
		
		JMenu menu_1 = new JMenu("信息查询");
		menuBar.add(menu_1);
		
		JMenuItem menuItem_2 = new JMenuItem("销售查询");                  //小胖子：计划出现--此操作员已销售的机票Table
		
		menu_1.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("订单查询");                  //小胖子：计划出现--此操作员已退票的机票Table
	
		menu_1.add(menuItem_3);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("业绩报表");
		menu_1.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("活动信息");
		
		menuBar.add(mnNewMenu_1);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblNewLabel = new JLabel("");
		
		lblNewLabel.setIcon(new ImageIcon(OperatorFrame.class.getResource("/res/5.JPG")));
		toolBar.add(lblNewLabel);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 1330, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 498, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(92, Short.MAX_VALUE))
		);
		
				JLabel lblNewLabel_1 = new JLabel("");
				toolBar.add(lblNewLabel_1);
				lblNewLabel_1.setIcon(new ImageIcon(OperatorFrame.class.getResource("/res/3-3.JPG")));
		
		JPanel pannel1 = new JPanel();
		pannel1.setBackground(SystemColor.textHighlightText);
		//tabbedPane.addTab("首页", closeIcon1, pannel1, null);		
		tabbedPane.add(pannel1, "首页");
		pannel1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("欢迎登陆机票预订系统");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblNewLabel_3.setBounds(1018, 66, 179, 42);
		pannel1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(0, 0, 1336, 430);
		lblNewLabel_2.setIcon(new ImageIcon(OperatorFrame.class.getResource("/res/8.jpg")));
		pannel1.add(lblNewLabel_2);
				
		JPanel pannel2 = new JPanel();
		pannel2.setBackground(SystemColor.textHighlightText);
		//tabbedPane.addTab("退票", closeIcon2, pannel2, null);
		
		GroupLayout gl_pannel2 = new GroupLayout(pannel2);
		gl_pannel2.setHorizontalGroup(
			gl_pannel2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1325, Short.MAX_VALUE)
		);
		gl_pannel2.setVerticalGroup(
			gl_pannel2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 400, Short.MAX_VALUE)
		);
		pannel2.setLayout(gl_pannel2);

		lblNewLabel.addMouseListener(new MouseAdapter() {          //工具栏中“出票”监视器
			@Override
			public void mouseClicked(MouseEvent e) {
				if(issuePanel==null){
					issuePanel=new IssuePanel();   
					//tabbedPane.add(issuePanel, "出票");				        //不带叉号
					ImageIcon closeIcon3 = new ImageIcon(OperatorFrame.class.getResource("/res/close.gif"));
					tabbedPane.addTab("出票", closeIcon3, issuePanel, null);	//带叉号			
					tabbedPane.setSelectedComponent(issuePanel);                //将其设置为即时弹出
				}
				else{
					tabbedPane.setSelectedComponent(issuePanel);                //将其设置为即时弹出
				}
			}
		});
		mntmNewMenuItem_3.addMouseListener(new MouseAdapter() {    //MenuItem菜单栏中“出票”监视器
			@Override
			public void mousePressed(MouseEvent e) {
				if(issuePanel==null){
					issuePanel=new IssuePanel(); 
					//tabbedPane.add(issuePanel, "出票");				        //不带叉号
					ImageIcon closeIcon3 = new ImageIcon(OperatorFrame.class.getResource("/res/close.gif"));
					tabbedPane.addTab("出票", closeIcon3, issuePanel, null);	//带叉号			
					tabbedPane.setSelectedComponent(issuePanel);                //将其设置为即时弹出
				}
				else{
					tabbedPane.setSelectedComponent(issuePanel);                //将其设置为即时弹出
				}
			}
		});
		
		lblNewLabel_1.addMouseListener(new MouseAdapter() {           //工具栏中“退票”监视器
			@Override
			public void mouseClicked(MouseEvent e) {
				if(refundPanel==null){   
					refundPanel=new RefundPanel();
					ImageIcon closeIcon4 = new ImageIcon(OperatorFrame.class.getResource("/res/close.gif"));
					tabbedPane.addTab("退票", closeIcon4, refundPanel, null);	//带叉号			
					tabbedPane.setSelectedComponent(refundPanel);                //将其设置为即时弹出
				}
				else{
					tabbedPane.setSelectedComponent(refundPanel);                //将其设置为即时弹出
				}		
			}
		});
		
		mntmNewMenuItem_4.addMouseListener(new MouseAdapter() {           //MenuItem菜单栏中“退票”监视器
			@Override
			public void mousePressed(MouseEvent e) {
				if(refundPanel==null){   
					//tabbedPane.add(refundPanel, "退票");				        //不带叉号
					refundPanel=new RefundPanel();
					ImageIcon closeIcon4 = new ImageIcon(OperatorFrame.class.getResource("/res/close.gif"));
					tabbedPane.addTab("退票", closeIcon4, refundPanel, null);	//带叉号			
					tabbedPane.setSelectedComponent(refundPanel);                //将其设置为即时弹出
				}
				else{
					tabbedPane.setSelectedComponent(refundPanel);                //将其设置为即时弹出
				}	
			}
		});
		contentPane.setLayout(gl_contentPane);
		
		mntmNewMenuItem_1.addMouseListener(new MouseAdapter() {          
			@Override
			public void mousePressed(MouseEvent e) {	
				if(operatorPanelLineChart==null){     
					operatorPanelLineChart=new OperatorPanelLineChart();
					ImageIcon closeIcon8 = new ImageIcon(OperatorFrame.class.getResource("/res/close.gif"));
					tabbedPane.addTab("业绩报表", closeIcon8, operatorPanelLineChart, null);	//带叉号			
					tabbedPane.setSelectedComponent(operatorPanelLineChart);                //将其设置为即时弹出
				}
				else{
					tabbedPane.setSelectedComponent(operatorPanelLineChart);                //将其设置为即时弹出
				}
			}
		});
		
		menuItem_2.addMouseListener(new MouseAdapter() {          
			@Override
			public void mousePressed(MouseEvent e) {	
				if(salesQuery==null){     
					salesQuery=new SalesQuery();
					ImageIcon closeIcon4 = new ImageIcon(OperatorFrame.class.getResource("/res/close.gif"));
					tabbedPane.addTab("销售查询", closeIcon4, salesQuery, null);	//带叉号			
					tabbedPane.setSelectedComponent(salesQuery);                //将其设置为即时弹出
				}
				else{
					tabbedPane.setSelectedComponent(salesQuery);                //将其设置为即时弹出
				}
			}
		});
		
		menuItem_3.addMouseListener(new MouseAdapter() {  
			@Override
			public void mousePressed(MouseEvent e) {
				if(listQuery==null){     
					listQuery=new ListQuery();
					ImageIcon closeIcon4 = new ImageIcon(OperatorFrame.class.getResource("/res/close.gif"));
					tabbedPane.addTab("订单查询", closeIcon4, listQuery, null);
					tabbedPane.setSelectedComponent(listQuery);
				}
				else{
					tabbedPane.setSelectedComponent(listQuery);  
				}
			}
		});		
		mnNewMenu_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(discount==null){     
					discount=new Discount();
					ImageIcon closeIcon4 = new ImageIcon(OperatorFrame.class.getResource("/res/close.gif"));
					tabbedPane.addTab("活动信息", closeIcon4, discount, null);
					tabbedPane.setSelectedComponent(discount);
				}
				else{
					tabbedPane.setSelectedComponent(discount);  
				}
			}
		});
		contentPane.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent arg0) {
				// TODO Auto-generated method stub
				lastActiveTime = System.currentTimeMillis();
			}
			
			@Override
			public void mouseDragged(MouseEvent arg0) {
				// TODO Auto-generated method stub
				lastActiveTime = System.currentTimeMillis();
			}
		});

		contentPane.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				lastActiveTime = System.currentTimeMillis();
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				lastActiveTime = System.currentTimeMillis();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				lastActiveTime = System.currentTimeMillis();
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				lastActiveTime = System.currentTimeMillis();
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				lastActiveTime = System.currentTimeMillis();
			}
		});
		remindTime = 20*60*1000;
		lock thread = new lock();
		thread.start();
		show thread1= new show();
		thread1.start();
	}
	class lock extends Thread{
		public void run() {
			while(true){
				
				long nowTime = System.currentTimeMillis();
				if (nowTime - lastActiveTime > remindTime){
					OperatorSingleton.getInstance().getOp().dispose();
					OperatorSingleton.getInstance().getLoginFrame().setVisible(true);
					break;
				}else{
					try {
						//设置定时时间为1000毫秒
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	class show extends Thread {
		public void run() {
			while (true) {

				long nowTime = System.currentTimeMillis();
				if (nowTime - lastActiveTime > remindTime-10) {
					TipTest t = new TipTest();
					t.start();
					break;
				} else {
					try {
						// 设置定时时间为1000毫秒
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}
