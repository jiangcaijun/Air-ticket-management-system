package com.app.dao;

import java.util.Vector;

import com.app.bean.Flight;
import com.app.bean.Orderer;
import com.app.bean.Ticket;

public interface TicketDao {
	public Vector<Ticket> queryTicket(Vector<Ticket> Ticket);
	
	public boolean addTicket(Vector<Ticket> Ticket);
	
	public boolean addTicket2(Ticket Ticket);
	
	public boolean deleteTicket(Vector<Ticket> Ticket);
	
	public boolean updateTicket(Vector<Ticket> Ticket);
	//根据票号查询
	public Vector<Ticket>  selectTicketId(Ticket ticket);
	//根据身份证查询未退票的记录
	public Vector<Ticket>  selectId(Ticket ticket); 
	//根据身份证查询，包括退票的记录
	public Vector<Ticket>  selectId1(Ticket ticket); 
	//根据身份证  和 订单号 查询，包括退票的记录
	public Vector<Ticket>  selectId2(Ticket ticket); 
	//根据日期查询，包括退票的记录
	public Vector<Ticket>  selectDate(Orderer orderer); 
	//根据票号删除对应记录
	public boolean deleteTicket2(Ticket ticket);
	//update出票状态
	public boolean updateTicket(Ticket ticket);
	//select对应舱位号的价格
	public Vector<Flight> selectTicket1(Ticket ticket);
	
	public Vector<Flight> selectTicket2(Ticket ticket);
	
	public Vector<Flight> selectTicket3(Ticket ticket);
	//根据orderer表中的order_id查找ticket表
	public Vector<Ticket>  selectOrdererId(Orderer orderer); 
	
	public Vector<Ticket> queryTicket2(Ticket ticket);
}
