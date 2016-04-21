package com.app.UI.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
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
import javax.swing.border.EmptyBorder;

import com.app.UI.Manager.EmployeeManager.OperatorPanel;
import com.app.UI.Manager.FlightManager.FlightPanel;
import com.app.UI.Manager.Query.ChartPanelForFlight;
import com.app.UI.Manager.Query.OrderPanel;
import com.app.UI.singleton.ManagerSingleton;
import com.app.utils.TipTest;

public class ManagerFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private FlightPanel flightPanel = null;
	private OperatorPanel operatorPanel = null;
	private OrderPanel orderPanel = null;
	private ChartPanelForFlight cpff = null;
	public static long lastActiveTime;
	public static long remindTime;
	private JTabbedPane tabbedPane;
	public ReLogin rl=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerFrame frame = new ManagerFrame();
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
	public ManagerFrame() {
		lastActiveTime = System.currentTimeMillis();
		ManagerSingleton.getInstance().setMf(this);
		ImageIcon closeIcon1 = new ImageIcon(ManagerFrame.class.getResource("/res/close.gif"));
		ImageIcon closeIcon7 = new ImageIcon(ManagerFrame.class.getResource("/res/close.gif"));
		ImageIcon closeIcon9 = new ImageIcon(ManagerFrame.class.getResource("/res/close.gif"));
		ImageIcon closeIcon4 = new ImageIcon(ManagerFrame.class.getResource("/res/close.gif"));
		ImageIcon closeIcon2 = new ImageIcon(ManagerFrame.class.getResource("/res/close.gif"));
		ImageIcon closeIcon3 = new ImageIcon(ManagerFrame.class.getResource("/res/close.gif"));
		ImageIcon closeIcon6 = new ImageIcon(ManagerFrame.class.getResource("/res/close.gif"));
		String s = "欢迎您，管理员" + ManagerSingleton.getInstance().getUsername();
		setTitle(s);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = getToolkit().getScreenSize(); // 设置成适应的屏幕大小
		setBounds(0, 0, (int) screenSize.getWidth(), (int) screenSize.getHeight());
		// setResizable(false);
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menu = new JMenu("系统管理");
		menuBar.add(menu);
		
		

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("系统设置");
		menu.add(mntmNewMenuItem_1);
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			
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
		menu.add(menuItem_1);

		JMenu mnNewMenu_1 = new JMenu("信息管理");
		menuBar.add(mnNewMenu_1);

		JMenuItem menuItem_4 = new JMenuItem("航班查询");
		mnNewMenu_1.add(menuItem_4);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("销售统计");
		mnNewMenu_1.add(mntmNewMenuItem_3);

		JMenuItem menuItem_2 = new JMenuItem("员工信息");
		mnNewMenu_1.add(menuItem_2);

		JMenu mnNewMenu_3 = new JMenu("总结报表");
		menuBar.add(mnNewMenu_3);

		JMenuItem menuItem = new JMenuItem("销售统计");
		mnNewMenu_3.add(menuItem);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JToolBar toolBar = new JToolBar();

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.LIGHT_GRAY);

		JLabel lblNewLabel = new JLabel(""); // 航班查询 监听器
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (flightPanel == null) {
					flightPanel = new FlightPanel();
					tabbedPane.addTab("航班查询", closeIcon6, flightPanel, null); // 带叉号
					// 将其设置为即时弹出
				}
				tabbedPane.setSelectedComponent(flightPanel);
				// 将其设置为即时弹出
			}
		});
		lblNewLabel.setIcon(new ImageIcon(ManagerFrame.class.getResource("/res/2-2.JPG")));
		toolBar.add(lblNewLabel);

		menuItem_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				if (flightPanel == null) {
					flightPanel = new FlightPanel();
					tabbedPane.addTab("航班查询", closeIcon2, flightPanel, null); // 带叉号
					// 将其设置为即时弹出
				}
				tabbedPane.setSelectedComponent(flightPanel);
				// 将其设置为即时弹出
			}
		});

		mntmNewMenuItem_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				if (orderPanel == null) {
					orderPanel = new OrderPanel();
					tabbedPane.addTab("销售统计", closeIcon3, orderPanel, null); // 带叉号
					// 将其设置为即时弹出
				}
				tabbedPane.setSelectedComponent(orderPanel); // 将其设置为即时弹出
			}
		});

		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (cpff == null) {
					cpff = new ChartPanelForFlight();
					tabbedPane.addTab("报表", closeIcon4, cpff, null); // 带叉号
					// 将其设置为即时弹出
				}
				tabbedPane.setSelectedComponent(cpff);
			}
		});

		menuItem_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				if (operatorPanel == null) {
					operatorPanel = new OperatorPanel();
					tabbedPane.addTab("员工信息", closeIcon9, operatorPanel, null); // 带叉号
				}
				tabbedPane.setSelectedComponent(operatorPanel);
			}
		});

		JPanel panel = new JPanel();
		tabbedPane.addTab("New tab", null, panel, null);
		tabbedPane.add(panel, "首页");

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(ManagerFrame.class.getResource("/res/10.jpg")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_panel.createSequentialGroup()
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 1427, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_panel.createSequentialGroup().addContainerGap()
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 519, GroupLayout.PREFERRED_SIZE)
						.addGap(2)));
		panel.setLayout(gl_panel);

		JLabel lblNewLabel_2 = new JLabel("");
		toolBar.add(lblNewLabel_2);
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (orderPanel == null) {
					orderPanel = new OrderPanel();
					tabbedPane.addTab("销售统计", closeIcon1, orderPanel, null); // 带叉号
					// 将其设置为即时弹出
				}
				tabbedPane.setSelectedComponent(orderPanel); // 将其设置为即时弹出

			}
		});
		lblNewLabel_2.setIcon(new ImageIcon(ManagerFrame.class.getResource("/res/2-4.JPG")));

		JLabel lblNewLabel_1 = new JLabel("");
		toolBar.add(lblNewLabel_1);
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (operatorPanel == null) {
					operatorPanel = new OperatorPanel();
					tabbedPane.addTab("员工信息", closeIcon7, operatorPanel, null); // 带叉号
				}
				tabbedPane.setSelectedComponent(operatorPanel);
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon(ManagerFrame.class.getResource("/res/2-3.JPG")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(10).addComponent(tabbedPane,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(6)
						.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 560, GroupLayout.PREFERRED_SIZE)));
		contentPane.setLayout(gl_contentPane);
		this.tabbedPane.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent arg0) {
				lastActiveTime = System.currentTimeMillis();
			}

			@Override
			public void mouseDragged(MouseEvent arg0) {
				// TODO Auto-generated method stub
				lastActiveTime = System.currentTimeMillis();
			}
		});
		this.contentPane.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent arg0) {
				lastActiveTime = System.currentTimeMillis();
			}

			@Override
			public void mouseDragged(MouseEvent arg0) {
				// TODO Auto-generated method stub
				lastActiveTime = System.currentTimeMillis();
			}
		});
		this.contentPane.addMouseListener(new MouseListener() {

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
			}
		});
		remindTime = 20 *60* 1000;
		lock thread = new lock();
		thread.start();
		show thread1= new show();
		thread1.start();
	}
		

	class lock extends Thread {
		public void run() {
			while (true) {

				long nowTime = System.currentTimeMillis();
				if (nowTime - lastActiveTime > remindTime) {
					ManagerSingleton.getInstance().getLf().setVisible(true);
					ManagerSingleton.getInstance().getMf().dispose();
					break;
				} else {
					try {
						// 设置定时时间为1000毫秒
						Thread.sleep(500);
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
