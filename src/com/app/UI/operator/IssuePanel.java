package com.app.UI.operator;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.table.DefaultTableModel;

import com.app.UI.singleton.OperatorSingleton;
import com.app.bean.Flight;
import com.app.dao.impl.FlightDaoImpl;
import com.app.utils.DateChooserJButton;
import com.eltima.components.ui.DatePicker;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IssuePanel extends JPanel {
	/**出票 Table表
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_4;

	private JScrollPane sp;
	private DefaultTableModel model;
	private JTable table ;  
	private static Vector<Vector<Object>> rowData;
	private Vector<String> ColumnNames =new Vector<String>();
	Vector<Flight> vec;
	FlightDaoImpl flightDaoImpl=new FlightDaoImpl();
	Flight flight=new Flight();
	OperatorSingleton mySingleton = OperatorSingleton.getInstance();    //单例模式
	/**
	 * Create the panel.
	 */
	public IssuePanel() {
		ColumnNames.add("航班号");
		ColumnNames.add("起飞机场");
		ColumnNames.add("落地机场");
		ColumnNames.add("出发时间");
		ColumnNames.add("到达时间");
		ColumnNames.add("头等舱原价格");
		ColumnNames.add("经济舱原价格");
		ColumnNames.add("公务舱原价格");
		ColumnNames.add("头等舱实际价格");
		ColumnNames.add("公务舱实际价格");
		ColumnNames.add("经济舱实际价格");
		
		JRadioButton rdbtnDanCheng = new JRadioButton("单程");
		rdbtnDanCheng.setBounds(61, 50, 90, 23);
		rdbtnDanCheng.setSelected(true);
		
	    ButtonGroup entreeGroup = new ButtonGroup();    //性别选择的唯一性
			entreeGroup.add(rdbtnDanCheng);
		JLabel lblNewLabel = new JLabel("出发城市");
		lblNewLabel.setBounds(61, 102, 48, 15);
		
		JLabel label = new JLabel("目的城市");
		label.setBounds(61, 167, 48, 15);
		
		textField = new JTextField();
		textField.setBounds(119, 99, 106, 21);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(118, 164, 106, 21);
		textField_1.setColumns(10);
		
		JLabel label_1 = new JLabel("出发日期");
		label_1.setBounds(61, 237, 48, 15);
		
		JLabel label_3 = new JLabel("航班查询");
		label_3.setBounds(61, 309, 48, 15);
		
		textField_4 = new JTextField();
		textField_4.setBounds(119, 306, 106, 21);
		textField_4.setColumns(10);
		
		
		DatePicker btnStart= new DatePicker(this);
		btnStart.setPattern("yyy-MM-d");
		btnStart.setBounds(119, 233, 105, 23);
		add(btnStart);
		
		JButton btnNewButton = new JButton("点击查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//System.out.println(btnStart.getText());     //查询出发时间的值，年月日 结构
				if(rdbtnDanCheng.isSelected()){
					flight.setOriginStation(textField.getText().toString());
					flight.setTerminalStation(textField_1.getText().toString());
					flight.setFlightId(textField_4.getText().toString());
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");		
					try {
						//sdf.parse(btnStart.getText());
						flight.setStartTime(sdf.parse(btnStart.getText()));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					setTable();
				}				
			}
		});
		btnNewButton.setBounds(103, 373, 81, 23);
		setLayout(null);
		add(rdbtnDanCheng);
		add(label_1);
		add(label);
		add(lblNewLabel);
		add(textField_1);
		add(textField);
		add(label_3);
		add(textField_4);
		add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(251, 63, 1074, 333);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		JPanel panTop=new JPanel();
		panel.add(panTop, BorderLayout.NORTH);
		
		JPanel panEnd=new JPanel();
		panel.add(panEnd, BorderLayout.SOUTH);
		JButton btnRef = new JButton("刷新");
		btnRef.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setTable();				
			}
		});
		

		JLabel lblNewLabel_1 = new JLabel("New label");        
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String change=textField_1.getText();
				textField_1.setText(textField.getText());
				textField.setText(change);
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon(IssuePanel.class.getResource("/res/12.jpg")));
		lblNewLabel_1.setBounds(22, 121, 34, 43);
		add(lblNewLabel_1);
		
		JButton btnGet = new JButton("选中");
		btnGet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i=table.getSelectedRow();    
				if(i>=0){
					Object obj=model.getValueAt(i,0);           //获取选中行的第0列的值，即flightid
					String flightId;
					flightId =obj.toString();
					mySingleton.setMyFlightId(flightId);
					Vector<?> flightVector = rowData.elementAt(i);   //获取此行所有数据										
					Reg reg = new Reg(flightVector);					
					reg.setVisible(true);
				}
			}
		});
		panEnd.add(btnRef);
		panEnd.add(btnGet);
				
		sp =new JScrollPane();	
		model=new DefaultTableModel(rowData, ColumnNames);  //设置为默认模型
		table=new JTable(model);    //可以用数组或Vector对Table进行初始化
		sp.setViewportView(table);
		panel.add(sp,BorderLayout.CENTER);
		

	}
	public  void initData(){
		vec=flightDaoImpl.queryFlight(flight);
		try {
			for(int i=0;i<vec.size();i++){	
				Vector<Object> v=new Vector<Object>();
				v.add(vec.get(i).getFlightId());
				v.add(vec.get(i).getOriginAirport());
				v.add(vec.get(i).getTerminalAirport());
				v.add(vec.get(i).getStartTime());
				v.add(vec.get(i).getEndTime());
				v.add(vec.get(i).getFirstClassPrice());
				v.add(vec.get(i).getBusinessClassPrice());
				v.add(vec.get(i).getEconomyClassPrice());
				//实际价格，考虑折扣								
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
