package com.app.UI.operator;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import com.app.UI.singleton.OperatorSingleton;
import com.app.bean.Flight;
import com.app.dao.impl.FlightDaoImpl;


import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Font;

import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class Discount extends JPanel {
	/**订单查询，查询的是order表查询，加入点击选中，输出此orderID对应的ticket中的用户信息
	 * 
	 */
	private static final long serialVersionUID = 1L;
	OperatorSingleton mySingleton = OperatorSingleton.getInstance();    //单例模式
	private JScrollPane sp;
	private DefaultTableModel model;
	private JTable table;  
	private static Vector<Vector<Object>> rowData;                  
	private Vector<String> ColumnNames =new Vector<String>();
	Vector<Flight> vec;
	FlightDaoImpl flightDaoImpl=new FlightDaoImpl();
	Flight flight=new Flight();

	private JTextField textDiscount;          
	
	public static String str;
	public static int i,j;
	public static String str2, rowList;
	JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	/**
	 * Create the panel.
	 */
	public Discount() {
		ColumnNames.add("航班号");         //orderer    orderer_id
		ColumnNames.add("起飞时间"); 
		ColumnNames.add("出发地");
		ColumnNames.add("目的地");        
		ColumnNames.add("头等舱折扣");       
		ColumnNames.add("经济舱折扣");    
		ColumnNames.add("公务舱折扣"); 
		ColumnNames.add("头等舱实际价格");       
		ColumnNames.add("经济舱实际价格");    
		ColumnNames.add("公务舱实际价格"); 
		
		//ColumnNames.add("订单时间");      //orderer    order_time
		JButton btnNewButton = new JButton("查询");
		btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 16));
	
		btnNewButton.setBounds(82, 217, 92, 23);
		setLayout(null);
		add(btnNewButton);
		
		model=new DefaultTableModel(rowData, ColumnNames);  //设置为默认模型
		
		JLabel lblNewLabel = new JLabel("折扣");
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblNewLabel.setBounds(31, 155, 54, 18);
		add(lblNewLabel);
		
		textDiscount = new JTextField();                     //机票票号，即ticket_id
		textDiscount.setBounds(95, 155, 124, 21);
		add(textDiscount);
		textDiscount.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(307, 150, 955, 221);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
	
		lblNewLabel_1 = new JLabel("  ");       
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblNewLabel_1.setBounds(307, 10, 244, 27);
		add(lblNewLabel_1);
		
		sp =new JScrollPane();	
		table=new JTable(model);                       //可以用数组或Vector对Table进行初始化
		sp.setViewportView(table);
		panel.add(sp,BorderLayout.CENTER);
		
		lblNewLabel_2 = new JLabel("请输入折扣值，展示头等舱、公务舱、经济舱任意一个舱位低于此折扣的航班");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblNewLabel_2.setBounds(31, 28, 589, 38);
		add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("    ");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblNewLabel_3.setBounds(307, 109, 136, 23);
		add(lblNewLabel_3);
		
		btnNewButton.addActionListener(new ActionListener() {       //“查询” 监视器
			public void actionPerformed(ActionEvent arg0) {
				if(!textDiscount.getText().isEmpty()){
					BigDecimal bigDecimal = new BigDecimal(textDiscount.getText());
					flight.setFirstClassDiscount(bigDecimal);
					flight.setBusinessClassDiscount(bigDecimal);
					flight.setEconomyClassDiscount(bigDecimal);
					setTable();
				}	
			}
		});
		
	}	
	/*根据折扣值查询
	 * 
	 */
	public  void initData(){
		//public Vector<Flight> queryFlight(Flight flight) 
		vec=flightDaoImpl.queryFlight2(flight);
		lblNewLabel_3.setText("查询到 "+vec.size()+" 条记录");
		try {
			for(int i=0;i<vec.size();i++){				
				Vector<Object> v=new Vector<Object>();
				v.add(vec.get(i).getFlightId());
				v.add(vec.get(i).getStartTime());
				v.add(vec.get(i).getOriginStation());
				v.add(vec.get(i).getTerminalStation());
				v.add(vec.get(i).getFirstClassDiscount());
				v.add(vec.get(i).getBusinessClassDiscount());
				v.add(vec.get(i).getEconomyClassDiscount());
				/*v.add(vec.get(i).getFirstClassPrice());
				v.add(vec.get(i).getBusinessClassPrice());
				v.add(vec.get(i).getEconomyClassPrice());*/
				int d1 = Integer.parseInt(vec.get(i).getFirstClassPrice().toString());
				int d2 = Integer.parseInt(vec.get(i).getFirstClassDiscount().toString());
				int d3 =d1*d2/10;
				
				v.add(d3);
				int e1 = Integer.parseInt(vec.get(i).getBusinessClassPrice().toString());
				int e2 = Integer.parseInt(vec.get(i).getBusinessClassDiscount().toString());
				int e3 =e1*e2/10;
				v.add(e3);
				
				int f1 = Integer.parseInt(vec.get(i).getEconomyClassPrice().toString());
				int f2 = Integer.parseInt(vec.get(i).getEconomyClassDiscount().toString());
				int f3 =f1*f2/10;
				v.add(f3);		
				
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
