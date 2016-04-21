package com.app.UI.operator;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.app.UI.singleton.OperatorSingleton;
import com.app.bean.Orderer;
import com.app.bean.Ticket;
import com.app.dao.impl.OrderDaoImpl;
import com.app.dao.impl.TicketDaoImpl;

public class Reg extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JScrollPane sp;
	private DefaultTableModel model;
	private JTable table ;  
	private static Vector<Vector<Object>> rowData;
	private Vector<String> ColumnNames =new Vector<String>();
	OperatorSingleton mySingleton = OperatorSingleton.getInstance();              //单例模式
	public static int flag=0;
	JComboBox<?> comboBox;
	Vector<?> flightVector;                 //所选中的航班信息
	Orderer orderer;
	OrderDaoImpl orderDaoImpl;
	public String str;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reg frame = new Reg();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Reg(Vector<?> flightVector) {
		this();//update biao set  字段1 = 值1,字段1 = 值1 where 条件
		this.flightVector = flightVector;
		if(getFlightVector()!=null) {
			//system.out.println(getFlightVector().elementAt(8));
			//system.out.println(getFlightVector().elementAt(9));
			//system.out.println(getFlightVector().elementAt(10));
		}
	}
	/**
	 * Create the frame.
	 */
	public Reg() {
		
		rowData = new Vector<Vector<Object>>();
		
		ColumnNames.add("姓名");
		ColumnNames.add("身份证号");
		ColumnNames.add("联系电话");
		ColumnNames.add("舱位号");
		ColumnNames.add("实际价格");

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 850, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5, BorderLayout.WEST);
		
		JLabel lblNewLabel = new JLabel("姓名");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("身份证号");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("联系电话");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("用户信息输入");
		lblNewLabel_4.setFont(new Font("微软雅黑", Font.BOLD, 18));
		
		JButton btnNewButton = new JButton("确认并添加新用户");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				setTable();		
				textField.setText("");                            //姓名 清空
				textField_1.setText("");                          //身份证号 清空
				textField_2.setText("");                          //联系电话 清空
			}
		});
		
		JLabel lblNewLabel_5 = new JLabel("舱位选择");
		
		String flightId=mySingleton.getMyFlightId().toString();
		flightId="航班编号"+flightId;
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"头等舱", "公务舱","经济舱"}));
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_5.createParallelGroup(Alignment.TRAILING)
							.addComponent(lblNewLabel_2)
							.addComponent(lblNewLabel_1))
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_5))
					.addGap(39)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
					.addGap(57))
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGap(24)
					.addComponent(lblNewLabel_4)
					.addContainerGap(168, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_panel_5.createSequentialGroup()
					.addGap(66)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(97, Short.MAX_VALUE))
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGap(21)
					.addComponent(lblNewLabel_4)
					.addGap(74)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(32)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addGap(29)
					.addComponent(btnNewButton)
					.addGap(22))
		);
		panel_5.setLayout(gl_panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(new BorderLayout(0, 0));
		model=new DefaultTableModel(rowData, ColumnNames);  //设置为默认模型
		
		JPanel panel = new JPanel();
		panel_2.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
				
		sp =new JScrollPane();
		panel.add(sp, BorderLayout.CENTER);
		table=new JTable(model);    //可以用数组或Vector对Table进行初始化
		sp.setViewportView(table);
		
		JPanel panEnd=new JPanel();
		panel.add(panEnd, BorderLayout.SOUTH);
		JButton btnGet = new JButton("选中，删除");
		btnGet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i=table.getSelectedRow();  
				if(i>=0){
					String sno=(String) model.getValueAt(i,0);           //获取选中行的第0列的值，即sno
					model.removeRow(i);                                   //删除选中行
				}
			}
		});
		panEnd.add(btnGet);
		JButton btnSave = new JButton("确认信息并购买");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {					
				int k = JOptionPane.showConfirmDialog(null, "是否确认出票", null,JOptionPane.OK_CANCEL_OPTION);
				if(k==0){
					JOptionPane.showMessageDialog(null, "出票成功");
					setOrderer();
					setTicket();
					Reg.this.dispose();
				}
			}
		});
		panEnd.add(btnSave);
		JLabel LabelId = new JLabel(flightId);
		LabelId.setFont(new Font("微软雅黑", Font.BOLD, 18));
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addContainerGap(60, Short.MAX_VALUE)
					.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
						.addComponent(LabelId)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 492, GroupLayout.PREFERRED_SIZE))
					.addGap(29))
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addGap(21)
					.addComponent(LabelId)
					.addGap(18)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(38, Short.MAX_VALUE))
		);
		panel_6.setLayout(gl_panel_6);
	
	}
	public  void initData(){	
		Vector<Vector> vec2=new Vector<Vector>();		
		Vector<Object> vec=new Vector<Object>();		
			//Vector<Object> v=new Vector<Object>();
			vec.add(textField.getText());                   //姓名
			vec.add(textField_1.getText());                 //身份证号
			vec.add(textField_2.getText());                 //联系电话
			vec.add(comboBox.getSelectedItem().toString()); //舱位
			if(comboBox.getSelectedItem().toString().equals("头等舱")){
				vec.add(getFlightVector().elementAt(8));
			}
			else if(comboBox.getSelectedItem().toString().equals("公务舱")){
				vec.add(getFlightVector().elementAt(9));
			}
			else if(comboBox.getSelectedItem().toString().equals("经济舱")){
				vec.add(getFlightVector().elementAt(10));
			}			
			vec2.add(vec);
			rowData.add(vec);			
	}
	public void setTable(){
		initData();
		model = new DefaultTableModel(rowData,ColumnNames);
		table.setModel(model);
	}

	public Vector getFlightVector() {
		return flightVector;
	}

	public void setFlightVector(Vector flightVector) {
		this.flightVector = flightVector;
	}
	public void setOrderer(){	                          //生成 order表，即订单详情
		OrderDaoImpl orderDaoImpl=new OrderDaoImpl();	
		Orderer orderer=new Orderer();	
		str=getRandomId();
		orderer.setOrderId(str);
		orderer.setName(rowData.get(0).get(0).toString());
		orderer.setId(rowData.get(0).get(1).toString());
		orderer.setTel(rowData.get(0).get(2).toString());
		orderer.setFlightId(mySingleton.getMyFlightId().toString());	
		BigDecimal bigDecimal = new BigDecimal(rowData.size());
		orderer.setTicketSum(bigDecimal);
		int j=0,k;
		for(int i=0;i<rowData.size();i++){	
			 k = Integer.parseInt(rowData.get(0).get(4).toString());
			 j=j+k;	
		}
		bigDecimal = new BigDecimal(j);
		orderer.setTotalPrice(bigDecimal);
		Date d = new Date();
		java.sql.Date p = new java.sql.Date(d.getTime());
		orderer.setOrderTime(p);
		orderer.setFlightDate((Date)getFlightVector().elementAt(3));              //航班起飞时间
		orderer.setOperatorId(mySingleton.getLoginFrameUserName());
		orderDaoImpl.addOrder2(orderer);                                     //方法调用
	}
	public void setTicket(){	
		Ticket ticket=new Ticket();		//生成 Ticket表
		TicketDaoImpl ticketDaoImpl=new TicketDaoImpl();
		for(int i=0;i<rowData.size();i++){	
			ticket.setTicketId(getRandomId());
			ticket.setOrderId(str);
			ticket.setId(rowData.get(i).get(1).toString());        //身份证号
			ticket.setStatus("1");
			ticket.setIsCancel("0");
			ticket.setSeatType(rowData.get(i).get(3).toString());
			ticket.setTel(rowData.get(i).get(2).toString());       //联系电话
			ticket.setName(rowData.get(i).get(0).toString());      //姓名
			
			ticketDaoImpl.addTicket2(ticket);
		}
	}
	public String getRandomId(){
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");   //设置日期格式
		String str=df.format(new Date()).toString(); 
		int a=(int)(Math.random()*9000+1000);
		str+=a;   
		return str;
	}
}
