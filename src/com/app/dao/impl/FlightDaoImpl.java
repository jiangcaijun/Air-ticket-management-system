package com.app.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Vector;

import com.app.bean.Flight;
import com.app.dao.FlightDao;

public class FlightDaoImpl extends BaseDao implements FlightDao{
	@Override
	public Vector<Flight> queryFlight(Flight flight) {
		String sql = "select * from flight where 1=1";
		if(flight.getFlightId() != null){
			sql += " and flight_id like '%"+flight.getFlightId()+"%'";
		}
		if(flight.getFlightCompany() != null){
			sql  += " and Flight_Company like '%"+flight.getFlightCompany()+"%'";
		}
		if(flight.getOriginStation() != null){
			sql  += " and origin_Station like '%"+flight.getOriginStation()+"%'";
		}
		if(flight.getTerminalStation() != null){
			sql  += " and terminal_Station like '%"+flight.getTerminalStation()+"%'";
		}
		if(flight.getStartTime() != null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
			String date = sdf.format(flight.getStartTime());
			sql += " and to_char(start_Time,'yyyy-MM-dd') like '"+date+"'";

		}
		System.out.println(sql);
		Vector<Flight> result = search(sql, Flight.class, new Object[]{});
		return result;
	}

	@Override
	public boolean addFlight(Vector<Flight> flight) {
		String sql = "insert into flight (flight_Id,origin_Station,"
				+ "terminal_Station,origin_Airport,terminal_Airport,start_Time,"
				+ "end_Time,distance,sum_Of_First_Class,sum_Of_Economy_Class,"
				+ "sum_Of_Business_Class,aircraft_Type,planes_Food,bording_Gate,"
				+ "first_Class_Price,economy_Class_Discount,business_Class_Discount,"
				+ "first_Class_Discount,economy_Class_Price,business_Class_Price,flight_company) ";
		int size = flight.size();
		Object[] obj = new Object[size*21];
		for (int i = 0; i < size; i++) {
			if(i==0){
				sql += "select ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? from dual";
			}else
				sql += "union all "
					+ "select ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? from dual";
			obj[i*21] = flight.get(i).getFlightId();
			obj[1+i*21] = flight.get(i).getOriginStation();
			obj[2+i*21] = flight.get(i).getTerminalStation();
			obj[3+i*21] = flight.get(i).getOriginAirport();
			obj[4+i*21] = flight.get(i).getTerminalAirport();
			obj[5+i*21] = new java.sql.Date(flight.get(i).getStartTime().getTime());
			obj[6+i*21] = new java.sql.Date(flight.get(i).getEndTime().getTime());
			obj[7+i*21] = flight.get(i).getDistance();
			obj[8+i*21] = flight.get(i).getSumOfFirstClass();
			obj[9+i*21] = flight.get(i).getSumOfEconomyClass();
			obj[10+i*21] = flight.get(i).getSumOfBusinessClass();
			obj[11+i*21] = flight.get(i).getAircraftType();
			obj[12+i*21] = flight.get(i).getPlanesFood();
			obj[13+i*21] = flight.get(i).getBordingGate();
			obj[14+i*21] = flight.get(i).getFirstClassPrice();
			obj[15+i*21] = flight.get(i).getEconomyClassDiscount();
			obj[16+i*21] = flight.get(i).getBusinessClassDiscount();
			obj[17+i*21] = flight.get(i).getFirstClassDiscount();
			obj[18+i*21] = flight.get(i).getEconomyClassPrice();
			obj[19+i*21] = flight.get(i).getBusinessClassPrice();
			obj[20+i*21] =flight.get(i).getFlightCompany();;
		}
		int flag = update(sql, obj);
		if(flag==0){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public boolean deleteFlight(Vector<Flight> flight) {
		String sql = "delete from flight where flight_Id in (";
		int size = flight.size();
		Object[] obj = new Object[size];
		for (int i = 0; i < size; i++) {
			if(i==0)
				sql += "?";
			else
				sql = sql +",?";
			obj[i] = flight.get(i).getFlightId();
		}
		sql = sql + ")";
		int flag = update(sql, obj);
		if(flag==0){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public boolean updateFlight(Vector<Flight> flight) {
		int size = flight.size();
		Object[] obj = new Object[size*21];
		String sql = "";
		for (int i = 0; i < size; i++) {
			sql = sql + "update flight set origin_Station = ?,"
				+ " terminal_Station = ?,origin_Airport = ?,terminal_Airport = ?,start_Time =?,"
				+ " end_Time = ?,distance = ?,sum_Of_First_Class = ?,sum_Of_Economy_Class = ?,"
				+ " sum_Of_Business_Class = ?,aircraft_Type = ?,planes_Food = ?,bording_Gate = ?,"
				+ " first_Class_Price = ?,economy_Class_Discount = ?,business_Class_Discount = ?,"
				+ " first_Class_Discount = ?,economy_Class_Price = ?,BUSINESS_CLASS_PRICE = ?,"
				+ " flight_company=?  where flight_id = ?";
			obj[i*21] = flight.get(i).getOriginStation();
			obj[1+i*21] = flight.get(i).getTerminalStation();
			obj[2+i*21] = flight.get(i).getOriginAirport();
			obj[3+i*21] = flight.get(i).getTerminalAirport();
			obj[4+i*21] = new java.sql.Date(flight.get(i).getStartTime().getTime());
			obj[5+i*21] = new java.sql.Date(flight.get(i).getEndTime().getTime());
			obj[6+i*21] = flight.get(i).getDistance();
			obj[7+i*21] = flight.get(i).getSumOfFirstClass();
			obj[8+i*21] = flight.get(i).getSumOfEconomyClass();
			obj[9+i*21] = flight.get(i).getSumOfBusinessClass();
			obj[10+i*21] = flight.get(i).getAircraftType();
			obj[11+i*21] = flight.get(i).getPlanesFood();
			obj[12+i*21] = flight.get(i).getBordingGate();
			obj[13+i*21] = flight.get(i).getFirstClassPrice();
			obj[14+i*21] = flight.get(i).getEconomyClassDiscount();
			obj[15+i*21] = flight.get(i).getBusinessClassDiscount();
			obj[16+i*21] = flight.get(i).getFirstClassDiscount();
			obj[17+i*21] = flight.get(i).getEconomyClassPrice();
			obj[18+i*21] = flight.get(i).getBusinessClassPrice();
			obj[19+i*21] = flight.get(i).getFlightCompany();
			obj[20+i*21] = flight.get(i).getFlightId();
		}
		int flag = update(sql,obj);
		if(flag==0){
			return false;
		}else{
			return true;
		}
	}
    @Override
	public Vector<Flight> queryFlight2(Flight flight) {
		String sql = "select * from flight where first_Class_Discount < ? or business_Class_Discount<? or economy_Class_Discount<?";
		Vector<Flight> result = search(sql, Flight.class,new Object[]{flight.getFirstClassDiscount(),flight.getBusinessClassDiscount(),flight.getEconomyClassDiscount()});
		return result;
	}
}
