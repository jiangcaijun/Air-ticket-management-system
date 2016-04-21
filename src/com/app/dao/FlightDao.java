package com.app.dao;

import java.util.Vector;

import com.app.bean.Flight;

public interface FlightDao {
	/**
	 * 航班查询
	 * @param flight
	 * @return
	 */
	public Vector<Flight> queryFlight(Flight flight);
	public Vector<Flight> queryFlight2(Flight flight);
	
	/**
	 * 添加航线
	 * 返回true 添加成功，false为添加失败
	 * @param flight
	 * @return
	 */
	public boolean addFlight(Vector<Flight> flight);
	
	/**
	 * 删除航线
	 * 返回true操作成功，false操作失败
	 * @param flight
	 * @return
	 */
	public boolean deleteFlight(Vector<Flight> flight);
	
	/**
	 * 修改航线
	 * 返回true操作成功，false操作失败
	 * @param flight
	 * @return
	 */
	public boolean updateFlight(Vector<Flight> flight);
}
