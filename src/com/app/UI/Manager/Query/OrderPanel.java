package com.app.UI.Manager.Query;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.app.UI.singleton.OperatorSingleton;
import com.app.bean.Orderer;
import com.app.bean.Ticket;
import com.app.dao.impl.OrderDaoImpl;
import com.app.dao.impl.TicketDaoImpl;

public class OrderPanel extends JPanel {
	/**订单查询，查询的是order表查询，加入点击选中，输出此orderID对应的ticket中的用户信息
	 * 
	 */
	private static final long serialVersionUID = 1L;
	OperatorSingleton mySingleton = OperatorSingleton.getInstance();    //单例模式
	private JScrollPane sp;
	private JScrollPane sp1;
	private DefaultTableModel model;
	private DefaultTableModel model1;
	private JTable table;  
	private JTable table1;  
	private static Vector<Vector<Object>> rowData;                   //Order表查询
	private Vector<String> ColumnNames =new Vector<String>();
	private static Vector<Vector<Object>> rowData1;                  //ticket查询
	private Vector<String> ColumnNames1 =new Vector<String>();
	Vector<Orderer> vecOrderer;
	Vector<Ticket> vecTicket;
	OrderDaoImpl orderDaoImpl=new OrderDaoImpl();
	TicketDaoImpl ticketDaoImpl=new TicketDaoImpl();
	Orderer orderer=new Orderer();
	Ticket ticket=new Ticket();
	private JTextField textOrderId;            //身份证号
	
	public static String str;
	public static int i,j;
	public static String str2, rowList;
	JLabel lblNewLabel_1;
	JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	/**
	 * Create the panel.
	 */
	public OrderPanel() {
		ColumnNames.add("订单号");         //orderer    orderer_id
		ColumnNames.add("航班号"); 
		ColumnNames.add("购买人姓名");
		ColumnNames.add("身份证");        
		ColumnNames.add("联系方式");       
		ColumnNames.add("票数");    
		
		ColumnNames1.add("姓名");        //ticket    name
		ColumnNames1.add("身份证");       //ticket     id
		ColumnNames1.add("联系方式");       //ticket     tel
		ColumnNames1.add("舱位");         //ticket     seat_type
		ColumnNames1.add("是否已退票");
		
		//ColumnNames.add("订单时间");      //orderer    order_time
		JButton btnNewButton = new JButton("查询");
	
		btnNewButton.setBounds(81, 268, 92, 23);
		setLayout(null);
		add(btnNewButton);
		
		model=new DefaultTableModel(rowData, ColumnNames);  //设置为默认模型
		model1=new DefaultTableModel(rowData1, ColumnNames1);  //设置为默认模型
		
		JLabel lblNewLabel = new JLabel("订单号");
		lblNewLabel.setBounds(31, 194, 54, 15);
		add(lblNewLabel);
		
		textOrderId = new JTextField();                     //机票票号，即ticket_id
		textOrderId.setBounds(98, 191, 118, 21);
		add(textOrderId);
		textOrderId.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(307, 47, 955, 183);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(307, 266, 955, 168);
		add(panel_1);
		JPanel panEnd=new JPanel();
		panel.add(panEnd, BorderLayout.SOUTH);
		JButton btnGet = new JButton("选中");
		panEnd.add(btnGet);	
		panel_1.setLayout(new BorderLayout(0, 0));
	
		lblNewLabel_1 = new JLabel("  ");       
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblNewLabel_1.setBounds(307, 10, 244, 27);
		add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("     ");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblNewLabel_2.setBounds(307, 240, 321, 25);
		add(lblNewLabel_2);
		
		btnGet.addActionListener(new ActionListener() {             //“选中”监视器
			public void actionPerformed(ActionEvent arg0) {						
				i=table.getSelectedRow();    
				if(i>=0){
					Object obj=model.getValueAt(i,0);               //获取选中行的第0列的值，即票号ticketId
					orderer.setOrderId(obj.toString());
					setTable1();
				}		
			}
		});
		btnNewButton.addActionListener(new ActionListener() {       //“查询” 监视器
			public void actionPerformed(ActionEvent arg0) {			
				String str=textOrderId.getText().toString()+"%";
				orderer.setOrderId(str);
				setTable();					
			}
		});
		
		sp =new JScrollPane();	
		table=new JTable(model);                       //可以用数组或Vector对Table进行初始化
		sp.setViewportView(table);
		panel.add(sp,BorderLayout.CENTER);
		
		sp1 =new JScrollPane();	
		table1=new JTable(model1);                       //可以用数组或Vector对Table进行初始化
		sp1.setViewportView(table1);
		panel_1.add(sp1);
		
		lblNewLabel_3 = new JLabel("查询所有操作员销售的订单");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblNewLabel_3.setBounds(31, 55, 254, 27);
		add(lblNewLabel_3);
	}	
	/*//用于当前管理员所有订单查询界面，查询orderid，包括退票的记录
	 * 
	 */
	public  void initData(){
		vecOrderer=orderDaoImpl.selectOrdererId2(orderer);
		lblNewLabel_1.setText("查询到 "+vecOrderer.size()+" 条记录");
		try {
			for(int i=0;i<vecOrderer.size();i++){				
				Vector<Object> v=new Vector<Object>();
				v.add(vecOrderer.get(i).getOrderId());
				v.add(vecOrderer.get(i).getFlightId());
				v.add(vecOrderer.get(i).getName());
				v.add(vecOrderer.get(i).getId());
				v.add(vecOrderer.get(i).getTel());
				v.add(vecOrderer.get(i).getTicketSum());
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
	
	/**根据orderer表中的order_id查找ticket表
	 * 
	 */
	public  void initData1(){
		vecTicket=ticketDaoImpl.selectOrdererId(orderer);
		lblNewLabel_2.setText("此订单表有 "+vecTicket.size()+" 条记录");
		try {
			for(int i=0;i<vecTicket.size();i++){				
				Vector<Object> v=new Vector<Object>();
				v.add(vecTicket.get(i).getName());
				v.add(vecTicket.get(i).getId());
				v.add(vecTicket.get(i).getTel());
				v.add(vecTicket.get(i).getSeatType());
				if(vecTicket.get(i).getIsCancel().toString().equals("1")){
					v.add("是");	
				}
				else{
					v.add("否");
				}
				rowData1.add(v);				
				}		
		} catch (Exception e) {
		}
	}
	public void setTable1(){
		rowData1 = new Vector<Vector<Object>>();
		initData1();
		model1 = new DefaultTableModel(rowData1,ColumnNames1);
		table1.setModel(model1);
	}
}
