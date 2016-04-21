package com.app.UI.operator;

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

public class SalesQuery extends JPanel {
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
	Vector<Orderer> vec;
	Vector<Ticket> vec2;
	OrderDaoImpl orderDaoImpl=new OrderDaoImpl();
	TicketDaoImpl ticketDaoImpl=new TicketDaoImpl();
	Orderer orderer=new Orderer();
	Ticket ticket=new Ticket();
	private JTextField textFlight;            //身份证号
	private JTextField textId;          //订单号
	
	public static String str;
	public static int i,j;
	public static String str2, rowList;
	JLabel lblNewLabel_1;
	/**
	 * Create the panel.
	 */
	public SalesQuery() {
		ColumnNames.add("机票号");      //ticket    ticket_id
		ColumnNames.add("姓名");        //ticket    name
		ColumnNames.add("身份证");       //ticket     id
		ColumnNames.add("联系方式");       //ticket     tel
		ColumnNames.add("舱位");         //ticket     seat_type
		//ColumnNames.add("订单时间");      //orderer    order_time
		JButton btnNewButton = new JButton("点击查询");
	
		btnNewButton.setBounds(119, 332, 81, 23);
		setLayout(null);
		add(btnNewButton);
		model=new DefaultTableModel(rowData, ColumnNames);  //设置为默认模型
		
		JLabel lblNewLabel = new JLabel("机票号");
		lblNewLabel.setBounds(95, 98, 54, 15);
		add(lblNewLabel);
		
		JLabel label = new JLabel("或    身份证号");
		label.setBounds(57, 188, 92, 15);
		add(label);
		
		textFlight = new JTextField();                     //机票票号，即ticket_id
		textFlight.setBounds(159, 95, 131, 21);
		add(textFlight);
		textFlight.setColumns(10);
		
		textId = new JTextField();                   //身份证号
		textId.setColumns(10);
		textId.setBounds(159, 185, 131, 21);
		add(textId);
		
		JPanel panel = new JPanel();
		panel.setBounds(313, 66, 955, 315);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		JPanel panTop=new JPanel();
		panel.add(panTop, BorderLayout.NORTH);
		
		lblNewLabel_1 = new JLabel("  ");       
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblNewLabel_1.setBounds(309, 30, 244, 15);
		add(lblNewLabel_1);
	
		btnNewButton.addActionListener(new ActionListener() {       //“点击查询” 监视器
			public void actionPerformed(ActionEvent arg0) {
				String str=textFlight.getText().toString()+"%";
				ticket.setTicketId(str);
				str=textId.getText().toString()+"%";
				ticket.setId(str);
				setTable();	
			}
		});
	
		sp =new JScrollPane();	
		table=new JTable(model);    //可以用数组或Vector对Table进行初始化
		sp.setViewportView(table);
		panel.add(sp,BorderLayout.CENTER);

	}
	//*****************根据订单号查询******************//
	public  void initData(){
		vec2=ticketDaoImpl.queryTicket2(ticket);
		lblNewLabel_1.setText("查询到 "+vec2.size()+" 条记录");
		try {
			for(int i=0;i<vec2.size();i++){				
				Vector<Object> v=new Vector<Object>();
				v.add(vec2.get(i).getTicketId());
				v.add(vec2.get(i).getName());
				v.add(vec2.get(i).getId());
				v.add(vec2.get(i).getTel());
				v.add(vec2.get(i).getSeatType());				
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
}
