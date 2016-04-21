package com.app.dao.impl;

import java.util.Vector;

import com.app.bean.Flight;
import com.app.bean.Orderer;
import com.app.bean.Ticket;
import com.app.dao.TicketDao;

public class TicketDaoImpl extends BaseDao implements TicketDao {

	@Override
	public Vector<Ticket> queryTicket(Vector<Ticket> Ticket) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addTicket(Vector<Ticket> ticket) {
		return false;
	}

	@Override
	public boolean deleteTicket(Vector<Ticket> ticket) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateTicket(Vector<Ticket> ticket) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addTicket2(Ticket ticket) {	              
		String sql="insert into ticket(ticket_id,id,status,is_cancel,seat_type,tel,name,order_id) values(?,?,?,?,?,?,?,?)";
		int row = update(sql,new Object[]{ticket.getTicketId(),ticket.getId(),ticket.getStatus(),ticket.getIsCancel(),ticket.getSeatType(),ticket.getTel(),ticket.getName(),ticket.getOrderId()});
		boolean flag = row>0?true:false;
		return flag;
	}
	/*public static void main(String []args){		    //测试程序
		TicketDaoImpl ticketDaoImpl=new TicketDaoImpl();
		Ticket ticket=new Ticket();
		ticket.setTicketId("2015%");
		ticketDaoImpl.selectTicketId(ticket);
	}*/

	@Override
	public Vector<Ticket> selectId(Ticket ticket) {
		String sql = "select * from ticket where is_cancel=0 and id like ?";
		Vector<Ticket> result = search(sql, Ticket.class,new Object[]{ticket.getId().toString()});
		return result;
	}

	@Override
	public boolean deleteTicket2(Ticket ticket) {
		String sql = "delete from ticket where ticket_id=?";
		int row = update(sql, new Object[]{ticket.getTicketId()});
		boolean flag = row>0?true:false;
		return flag;
	}

	@Override
	public boolean updateTicket(Ticket ticket) {
		String sql = "update ticket set is_cancel =1 where ticket_id=?";
		int row = update(sql, new Object[]{ticket.getTicketId()});
		boolean flag = row>0?true:false;
		return flag;
	}
	@Override
	public Vector<Ticket>  selectTicketId(Ticket ticket) {
		String sql = "select * from ticket where is_cancel=0 and ticket_id like ?";
		Vector<Ticket> result = search(sql, Ticket.class,new Object[]{ticket.getTicketId().toString()});
		return result;
	}
	@Override
	public Vector<Ticket> selectId1(Ticket ticket) {
		String sql = "select * from ticket where id like ?";
		Vector<Ticket> result = search(sql, Ticket.class,new Object[]{ticket.getId().toString()});
		return result;
	}
	@Override
	public Vector<Ticket> selectId2(Ticket ticket) {
		String sql = "select * from ticket where id like ? and ticket_id like ?";
		Vector<Ticket> result = search(sql, Ticket.class,new Object[]{ticket.getId().toString(),ticket.getTicketId().toString()});
		return result;
	}
	@Override
	public Vector<Flight> selectTicket1(Ticket ticket) {
		String sql = "select * from flight where flight_id = (select flight_id from orderer where order_id = (select order_id from ticket where ticket_id=?))";		
		Vector<Flight> result = search(sql, Flight.class,new Object[]{ticket.getTicketId()});
		return result;
	}	

	@Override
	public Vector<Flight> selectTicket2(Ticket ticket) {
		String sql = "select BUSINESS_CLASS_PRICE from flight where flight_id = (select flight_id from orderer where order_id = (select order_id from ticket where ticket_id=?))";		
		Vector<Flight> result = search(sql, Flight.class,new Object[]{ticket.getTicketId()});
		return result;
	}

	@Override
	public Vector<Flight> selectTicket3(Ticket ticket) {
		String sql = "select FIRST_CLASS_PRICE from flight where flight_id = (select flight_id from orderer where order_id = (select order_id from ticket where ticket_id=?))";		
		Vector<Flight> result = search(sql, Flight.class,new Object[]{ticket.getTicketId()});
		return result;
	}

	@Override
	public Vector<Ticket> selectDate(Orderer orderer) {
		String sql = "select * from ticket where order_id  in (select  order_id from orderer where order_time = ?)";
		Vector<Ticket> result = search(sql, Ticket.class,new Object[]{orderer.getOrderTime()});
		return result;
	}

	/* 将orderer表中的order_id ，，查询对应ticket
	 * @see com.app.dao.TicketDao#selectOrdererId(com.app.bean.Orderer)
	 */
	@Override
	public Vector<Ticket> selectOrdererId(Orderer orderer) {
		String sql="select * from ticket where order_id=?";
		Vector<Ticket> result = search(sql, Ticket.class,new Object[]{orderer.getOrderId()});
		return result;
	}

	/* 模糊查询某一个的ticket表
	 * @see com.app.dao.TicketDao#queryTicket2(com.app.bean.Ticket)
	 */
	@Override
	public Vector<Ticket> queryTicket2(Ticket ticket) {
		String sql = "select * from ticket where 1=1";
		if(ticket.getId() != null){
			sql += " and id like'"+ticket.getId()+"%'";
		}
		if(ticket.getTicketId() != null){
			sql  += " and ticket_id like '"+ticket.getTicketId()+"%'";
		}
		sql += "order by order_id desc";
		Vector<Ticket> result = search(sql, Ticket.class, new Object[]{});
		return result;
	}
	
	public Vector<Ticket> queryTicket3(Ticket ticket) {
		String sql = "select * from ticket where 1=1 and is_cancel='0'";
		if(ticket.getId() != null){
			sql += " and id like'"+ticket.getId()+"%'";
		}
		if(ticket.getTicketId() != null){
			sql  += " and ticket_id like '"+ticket.getTicketId()+"%'";
		}
		sql += "order by order_id desc";
		Vector<Ticket> result = search(sql, Ticket.class, new Object[]{});
		return result;
	}
	
}
