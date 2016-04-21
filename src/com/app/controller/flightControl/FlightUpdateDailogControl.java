package com.app.controller.flightControl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.app.UI.Manager.FlightManager.FlightUpdateDialog;
import com.app.UI.singleton.ManagerSingleton;
import com.app.bean.Flight;

public class FlightUpdateDailogControl extends FlightControlModel{
	private FlightUpdateDialog fud;
	
	public FlightUpdateDailogControl(){}
	
	public FlightUpdateDailogControl(FlightUpdateDialog fud){
		this.fud = fud;
	}
	
	public void init(){
		setModelType();
		Vector<Vector<Object>> vv= toVector(ManagerSingleton.getInstance().getVf());
		setTable(model,vv);
		fud.dtm = model;
		save();
		cancel();
	}
	
	public void save(){
		fud.okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = fud.dtm.getRowCount();
				int column = fud.dtm.getColumnCount();
				vv = new Vector<Vector<Object>>();
				for (int i = 0; i < row; i++) {
					Vector<Object> v = new Vector<Object>();
					for (int j = 0; j < column; j++) {
						v.add(fud.dtm.getValueAt(i, j));
					}
					vv.add(v);
				}
				Vector<Flight> ve = toFlight2(vv);
				if(fud.dtm.getRowCount()==0){
					JOptionPane.showMessageDialog(null, "没有数据");
				}else{
					boolean flag = edi.updateFlight(ve);
						if(flag){
							JOptionPane.showMessageDialog(null, "更新成功");
							fud.dispose();
						}else
							JOptionPane.showMessageDialog(null, "更新失败");
				}
			}

			private Vector<Flight> toFlight2(Vector<Vector<Object>> vv) {
				int size = vv.size();
				Vector<Flight> ve = new Vector<Flight>();
				for (int i = 0; i < size; i++) {
					Flight e = new Flight();
					e.setFlightId((String)vv.get(i).get(0));	
					e.setFlightCompany((String)vv.get(i).get(1));
					e.setOriginStation((String)vv.get(i).get(2));
					e.setTerminalStation((String)vv.get(i).get(3));	
					e.setOriginAirport((String)vv.get(i).get(4));
					e.setTerminalAirport((String)vv.get(i).get(5));
					Date d = (Date)vv.get(i).get(6);
					e.setStartTime(d);
					Date d1 = (Date)vv.get(i).get(6);
					e.setEndTime(d1);
					e.setBordingGate((String)vv.get(i).get(8));
					e.setSumOfEconomyClass((BigDecimal)vv.get(i).get(9));
					e.setEconomyClassPrice((BigDecimal)vv.get(i).get(10));
					e.setEconomyClassDiscount((BigDecimal)vv.get(i).get(11));
					e.setSumOfBusinessClass((BigDecimal)vv.get(i).get(12));
					e.setBusinessClassPrice((BigDecimal)vv.get(i).get(13));
					e.setBusinessClassDiscount((BigDecimal)vv.get(i).get(14));
					e.setSumOfFirstClass((BigDecimal)vv.get(i).get(15));
					e.setFirstClassPrice((BigDecimal)vv.get(i).get(16));
					e.setFirstClassDiscount((BigDecimal)vv.get(i).get(17));
					e.setDistance((BigDecimal)vv.get(i).get(18));
					e.setAircraft((String)vv.get(i).get(19));
					if((Boolean)vv.get(i).get(20))
						e.setPlanesFood("1");
					else
						e.setPlanesFood("0");	
					ve.add(e);
				}
				return ve;				
			}
		});
	}
	
	private void cancel(){
		fud.cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int k = JOptionPane.showConfirmDialog(null, "确定放弃编辑？");
				if(k==0){
					fud.setVisible(false);
					model = null;
					ManagerSingleton.getInstance().getMf().setVisible(true);
				}
			}
		});
	}
	
	public void setModelType(){
		model = new DefaultTableModel(){
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int row, int column) {
				return true;
			}
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				return getValueAt(0, columnIndex).getClass();
			}
		};
	}
	
}
