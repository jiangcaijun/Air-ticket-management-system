package com.app.dao;

import java.util.Vector;

import com.app.bean.Orderer;

public interface OrderDao {
	public Vector<Orderer> queryOrder(Orderer Orderer);
	
	public boolean addOrder(Vector<Orderer> Orderer);
	
	public boolean addOrder2(Orderer Orderer);
	
	public boolean deleteOrder(Vector<Orderer> Orderer);
	
	public boolean updateOrder(Vector<Orderer> Orderer);
	
	//用于当前操作员订单查询界面，查询orderid，包括退票的记录
	public Vector<Orderer>  selectOrdererId(Orderer orderer);
	//用于当前管理员订单查询界面，查询orderid，包括退票的记录
	public Vector<Orderer>  selectOrdererId2(Orderer orderer);
	
}
