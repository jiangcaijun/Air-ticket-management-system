package com.app.UI.operator;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import com.app.UI.singleton.OperatorSingleton;
import com.app.bean.Flight;
import com.app.bean.Refund;
import com.app.bean.Ticket;
import com.app.dao.impl.RefundDaoImpl;
import com.app.dao.impl.TicketDaoImpl;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Font;

import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class RefundPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	OperatorSingleton mySingleton = OperatorSingleton.getInstance();    //单例模式
	private JScrollPane sp;
	private DefaultTableModel model;
	private JTable table ;  
	private static Vector<Vector<Object>> rowData;
	private Vector<String> ColumnNames =new Vector<String>();
	private JTextField textField;            //身份证号
	private JTextField textField_1;          //订单号
	TicketDaoImpl ticketDaoImpl=new TicketDaoImpl();
	Ticket ticket=new Ticket();
	Vector<Ticket> vec;
	Vector<Flight> vector;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	public static String str;
	public static int i,j;
	public static String str2;
	private JTextField textField_5;
	/**
	 * Create the panel.
	 */
	public RefundPanel() {
		ColumnNames.add("票号");
		ColumnNames.add("姓名");
		ColumnNames.add("身份证");
		ColumnNames.add("电话");
		ColumnNames.add("舱位");		
		JButton btnNewButton = new JButton("点击查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				String str=textField.getText().toString()+"%";
				ticket.setId(str);			
				str=textField_1.getText().toString()+"%";
				ticket.setTicketId(str);
				setTable();			
			}
		});
		btnNewButton.setBounds(132, 267, 81, 23);
		setLayout(null);
		add(btnNewButton);
		model=new DefaultTableModel(rowData, ColumnNames);  //设置为默认模型
		
		JLabel lblNewLabel = new JLabel("身份证号");
		lblNewLabel.setBounds(95, 98, 54, 15);
		add(lblNewLabel);
		
		JLabel label = new JLabel("或    订单号");
		label.setBounds(67, 188, 72, 15);
		add(label);
		
		textField = new JTextField();
		textField.setBounds(159, 95, 131, 21);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(159, 185, 131, 21);
		add(textField_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(314, 32, 955, 240);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		JPanel panTop=new JPanel();
		panel.add(panTop, BorderLayout.NORTH);		

		textField_2 = new JTextField();
		textField_2.setFont(new Font("微软雅黑", Font.BOLD, 15));
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("微软雅黑", Font.BOLD, 12));
		textField_3.setColumns(10);
			
		textField_4 = new JTextField();
		textField_4.setFont(new Font("微软雅黑", Font.BOLD, 15));
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();               //退票备注
		textField_5.setFont(new Font("微软雅黑", Font.BOLD, 15));
		textField_5.setColumns(10);
				
		JPanel panEnd=new JPanel();
		panel.add(panEnd, BorderLayout.SOUTH);
		JButton btnRef = new JButton("刷新");
		JButton btnGet = new JButton("选中");
		btnGet.addActionListener(new ActionListener() {           //“选中”监视器
			public void actionPerformed(ActionEvent arg0) {					
				//textField_2     //原价格			
				i=table.getSelectedRow();    
				if(i>=0){
					Object obj=model.getValueAt(i,0);             //获取选中行的第0列的值，即票号ticketId
					ticket.setTicketId(obj.toString());
					vector=ticketDaoImpl.selectTicket1(ticket);		//根据ticket的ticket_id查找			
					Object obj2=model.getValueAt(i,4);             //获取选中行的第0列的值，即票号ticketId					
	
					if(obj2.toString().equals("经济舱")){
						str=vector.get(0).getEconomyClassPrice().toString();
					}else if(obj2.toString().equals("公务舱")){
						str=vector.get(0).getBusinessClassPrice().toString();
						}else if(obj2.toString().equals("头等舱")){
							str=vector.get(0).getFirstClassPrice().toString();	
						}
					textField_2.setText(str);
					j=Integer.parseInt(str);
					j=j*2/10;					
					//textField_3.setText(String.valueOf(j));
					textField_3.setText("20");
					j=j*4;
					textField_4.setText(String.valueOf(j));
				}		
			}
		});
		panEnd.add(btnRef);
		panEnd.add(btnGet);
		
		sp =new JScrollPane();	
		table=new JTable(model);    //可以用数组或Vector对Table进行初始化
		sp.setViewportView(table);
		panel.add(sp,BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(314, 282, 1008, 104);
		add(panel_1);
		
		JLabel label_1 = new JLabel("原价格");
		label_1.setFont(new Font("微软雅黑", Font.BOLD, 15));
		
		JLabel label_2 = new JLabel("手续费率(%)");
		label_2.setFont(new Font("微软雅黑", Font.BOLD, 15));
				
		JLabel lblNewLabel_1 = new JLabel("实际退还");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 15));
		
		JButton btnNewButton_1 = new JButton("确认退票");
		btnNewButton_1.setFont(new Font("微软雅黑", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(i>=0){
					Object obj=model.getValueAt(i,0);             //获取选中行的第0列的值，即票号ticketId
					ticket.setTicketId(obj.toString());
					//String result = ticketDaoImpl.deleteTicket2(ticket)?"退票成功":"删除失败,发生未知错误";
					boolean flag = ticketDaoImpl.updateTicket(ticket);        //将ticket表中的is_cancel 状态改为1，即“已退票”
					setOrderer();                             // 将数据插入 refund表
					if(flag==true){						
						int k = JOptionPane.showConfirmDialog(null, "是否确认退票", null,JOptionPane.OK_CANCEL_OPTION);
						if(k==0){
							JOptionPane.showMessageDialog(null, "退票成功");
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "退票失败,发生未知错误");
					}				
				}		
			}
		});
		
		JLabel label_3 = new JLabel("退票备注");
		label_3.setFont(new Font("微软雅黑", Font.BOLD, 15));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(label_2)
							.addGap(18)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE))
					.addGap(147)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addGap(18)
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(165))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(label_2)
						.addComponent(lblNewLabel_1)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(13))
		);
		panel_1.setLayout(gl_panel_1);
	}
	//*****************根据订单号查询******************//
	public  void initData(){
		vec=ticketDaoImpl.queryTicket3(ticket);
		try {
			for(int i=0;i<vec.size();i++){	
				Vector<Object> v=new Vector<Object>();
				v.add(vec.get(i).getTicketId());
				v.add(vec.get(i).getName());
				v.add(vec.get(i).getId());
				v.add(vec.get(i).getTel());
				v.add(vec.get(i).getSeatType());				
				rowData.add(v);				
				}
		} catch (Exception e) {
		}
	}
	public void setTable(){
		rowData = new Vector<Vector<Object>>();
		initData();
		model = new DefaultTableModel(rowData,ColumnNames);
		table.setModel(model);
	}
	
	//*****************************填入数据到退票Refund************************
	public void setOrderer(){	                          //生成 order表，即订单详情
		RefundDaoImpl refundDaoImpl=new RefundDaoImpl();	
		Refund refund=new Refund();	
		
		Object obj=model.getValueAt(i,0);             //获取选中行的第0列的值，即票号ticketId
		refund.setTicketId(obj.toString());
		obj=model.getValueAt(i,1); 
		refund.setRefundPerson(obj.toString());
		obj=model.getValueAt(i,2); 
		refund.setRefundPersonId(obj.toString());
		obj=model.getValueAt(i,3); 
		refund.setRefundTel(obj.toString());
	
		BigDecimal bigDecimal = new BigDecimal(j);
		refund.setBackMoney(bigDecimal);
		bigDecimal = new BigDecimal(4*j);
		refund.setRefundFee(bigDecimal);                               //手续费
		
		//*******************util下的date转成sql下的date***********************		
		Date d = new Date();
		java.sql.Date p = new java.sql.Date(d.getTime());
		refund.setRefundTime(p);
		refund.setReson(textField_5.getText());
		refund.setOperatorId(mySingleton.getLoginFrameUserName());      
			
		refundDaoImpl.addRefund(refund);                                //方法调用
	}	
}
