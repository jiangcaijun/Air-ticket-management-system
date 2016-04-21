package com.app.controller.flightControl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.app.UI.Manager.FlightManager.FilghtAddDialog;
import com.app.UI.singleton.ManagerSingleton;
import com.app.bean.Flight;

public class FlightAddDialogControl extends FlightControlModel{

	private FilghtAddDialog fad;
	
	boolean flag =true;
	
	public FlightAddDialogControl(){}
	
	public FlightAddDialogControl(FilghtAddDialog fad){
		this.fad = fad;
	}
	
	public void init(){
		setModelType();
		setTable(model, null);
		fad.dtm = model;
		save();
		cancel();
		close(fad);
	}
	
	private void add(){
			Object[] rowdate = new Object[21];
			boolean flag = true;
			rowdate = getFlightInfo();
			if(flag){
				if(time){
					model.addRow(rowdate);
				}
				else{
					JOptionPane.showMessageDialog(null, "请确定日期格式正确！！");
				}
			}
			else JOptionPane.showMessageDialog(null, "请确保每个字段都已被填写！");
		}

	private Object[] getFlightInfo(){
		
		Object[] obj1 = new Object[21];
		obj1[0] = fad.flightIdTextField.getText().trim();
		if(obj1[0]==null) flag = false;
		obj1[1] = fad.flightCompanytextField.getText().trim();
		if(obj1[1]==null) flag = false;
		String originStation =fad.originStationTextField.getText().trim();
		String originShort = fad.originShortTextField.getText().toUpperCase().trim();
		obj1[2] = (originStation+"("+originShort+")");
		if(originStation==null||originShort==null) flag = false;
		String terminalStation =fad.terminalStationTextField.getText().trim();
		String terminalShort = fad.terminalShortTextField.getText().toUpperCase().trim();
		obj1[3] = (terminalStation+"("+terminalShort+")");
		if(terminalStation==null||terminalShort==null) flag = false;
		obj1[4] = fad.originAirportTextField.getText().trim();
		if(obj1[4]==null) flag = false;
		obj1[5] = fad.terminalAirportTextField.getText().trim();
		if(obj1[5]==null) flag = false;
		obj1[6] = fad.StartTimeNewButton.getText().trim();
		if(obj1[6]==null) flag = false;
		obj1[7] = fad.endTimeNewButton.getText().trim();
		if(obj1[7]==null) flag = false;
		obj1[8] = fad.bordingGateTextField.getText().trim();
		if(obj1[8]==null) flag = false;
		try{
			obj1[9] = BigDecimal.valueOf(Double.parseDouble(fad.economySeatTextField.getText().trim()));
//			if(obj1[9].equals("")) flag = false;
			obj1[10] = BigDecimal.valueOf(Double.parseDouble(fad.economyPriceTextField.getText().trim()));
//			if(obj1[10].equals("")) flag = false;
			obj1[11] = BigDecimal.valueOf(Double.parseDouble(fad.economyDiscountTextField.getText().trim()));
//		if(obj1[11].equals("")) flag = false;
			obj1[12] = BigDecimal.valueOf(Double.parseDouble(fad.businessSeatTextField.getText().trim()));
//		if(obj1[12].equals("")) flag = false;
			obj1[13] = BigDecimal.valueOf(Double.parseDouble(fad.businessPriceTextField.getText().trim()));
//		if(obj1[13].equals("")) flag = false;
			obj1[14] = BigDecimal.valueOf(Double.parseDouble(fad.businessDiscountTextField.getText().trim()));
//		if(obj1[14].equals("")) flag = false;
			obj1[15] = BigDecimal.valueOf(Double.parseDouble(fad.firstSeatTextField.getText().trim()));
//		if(obj1[15].equals("")) flag = false;
			obj1[16] = BigDecimal.valueOf(Double.parseDouble(fad.firstPriceTextField.getText().trim()));
//		if(obj1[16].equals("")) flag = false;
			obj1[17] = BigDecimal.valueOf(Double.parseDouble(fad.firstDiscountTextField.getText().trim()));
//		if(obj1[17].equals("")) flag = false;
			obj1[18] = BigDecimal.valueOf(Double.parseDouble(fad.distanceTextField.getText().trim()));
//			if(obj1[18].equals("")) flag = false;
		}catch(Exception e){
			flag = false;
		}
		obj1[19] = fad.planeTypeTextField.getText().trim();
		if(obj1[19].equals("")) flag = false;
		if(fad.radioButton1.isSelected())obj1[20] = true;
		else obj1[20] = false;
		//		赋值，做chart，订单查询，	,关闭的监听事件
		return obj1;
	}

	
	private void save(){
		fad.okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				add();
				int row = fad.dtm.getRowCount();
				int column = fad.dtm.getColumnCount();
				vv = new Vector<Vector<Object>>();
				for (int i = 0; i < row; i++) {
					Vector<Object> v = new Vector<Object>();
					for (int j = 0; j < column; j++) {
						v.add(fad.dtm.getValueAt(i, j));
					}
					vv.add(v);
				}
				Vector<Flight> ve = toFlight(vv);
				if(fad.dtm.getRowCount()==0){
					JOptionPane.showMessageDialog(null, "没有数据");
				}else{
					boolean flag = edi.addFlight(ve);
					if(flag){
						JOptionPane.showMessageDialog(null, "添加成功");
						ManagerSingleton.getInstance().getMf().setVisible(true);
						fad.dispose();;
					}else
						JOptionPane.showMessageDialog(null, "添加失败");
				}
				
			}
		});
	}
	
	private void cancel(){
		fad.cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fad.setVisible(false);
				ManagerSingleton.getInstance().getMf().setVisible(true);
			}
		});
	}
	
	public void setModelType(){
		model = new DefaultTableModel(){
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
				@Override
				public Class<?> getColumnClass(int columnIndex) {
				return getValueAt(0, columnIndex).getClass();
			}
		};
	}
}
