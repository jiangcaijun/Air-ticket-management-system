package com.app.controller.flightControl;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import com.app.UI.singleton.ManagerSingleton;
import com.app.bean.Flight;
import com.app.dao.impl.FlightDaoImpl;

public class FlightControlModel {
	public boolean time=true;
	public FlightDaoImpl edi = new FlightDaoImpl();
	public DefaultTableModel model;
	public Vector<Vector<Object>> vv;
	public static Vector<String> columnIdentifiers;
	static{
		columnIdentifiers = new Vector<String>();
		columnIdentifiers.add("航班号");
		columnIdentifiers.add("航空公司");
		columnIdentifiers.add("出发城市");
		columnIdentifiers.add("终点城市");
		columnIdentifiers.add("出发机场");
		columnIdentifiers.add("抵达机场");
		columnIdentifiers.add("出发时间");
		columnIdentifiers.add("到达时间");
		columnIdentifiers.add("登机口");
		columnIdentifiers.add("经济舱座位数");
		columnIdentifiers.add("经济舱原价格");
		columnIdentifiers.add("经济舱折扣");
		columnIdentifiers.add("商务舱座位数");
		columnIdentifiers.add("商务舱原价格");
		columnIdentifiers.add("商务舱折扣");
		columnIdentifiers.add("头等舱原座位数");
		columnIdentifiers.add("头等舱价格");
		columnIdentifiers.add("头等舱折扣");
		columnIdentifiers.add("距离");
		columnIdentifiers.add("飞机型号");
		columnIdentifiers.add("是否有飞机餐");
		
	}
	
	public void close(JFrame d){
		d.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				ManagerSingleton.getInstance().getMf().setEnabled(true);
			}
		});
	}
	
	public void setTable(DefaultTableModel dtm,Vector<Vector<Object>> vv){
		dtm.setDataVector(vv,columnIdentifiers );	
	}
	
	public Vector<Flight> toFlight(Vector<Vector<Object>> vv){
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
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date d =null;
			try {
				d= sdf.parse(String.valueOf(vv.get(i).get(6)));
				System.out.println(vv.get(i).get(6));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.setStartTime(d);
			try {
				d= sdf.parse(String.valueOf(vv.get(i).get(7)));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.setEndTime(d);
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
	
	
	public Vector<Vector<Object>> toVector(Vector<Flight> vf){
		int size = vf.size();
		vv = new Vector<Vector<Object>>();
		for (int i = 0; i < size; i++) {
			Flight e = vf.get(i);
			Vector<Object> v = new Vector<Object>();
			v.add(e.getFlightId());
			v.add(e.getFlightCompany());
			v.add(e.getOriginStation());
			v.add(e.getTerminalStation());
			v.add(e.getOriginAirport());
			v.add(e.getTerminalAirport());
			v.add(e.getStartTime());
			v.add(e.getEndTime());
			v.add(e.getBordingGate());
			v.add(e.getSumOfEconomyClass());
			v.add(e.getEconomyClassPrice());
			v.add(e.getEconomyClassDiscount());
			v.add(e.getSumOfBusinessClass());
			v.add(e.getBusinessClassPrice());
			v.add(e.getBusinessClassDiscount());
			v.add(e.getSumOfFirstClass());
			v.add(e.getFirstClassPrice());
			v.add(e.getFirstClassDiscount());
			v.add(e.getDistance());
			v.add(e.getAircraftType());
			if(e.getPlanesFood().equals("1"))
				v.add(true);
			else
				v.add(false);
			vv.add(v);
		}
		return vv;
	}
	
}
