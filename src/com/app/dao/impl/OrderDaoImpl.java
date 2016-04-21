package com.app.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import com.app.bean.Orderer;
import com.app.bean.Ticket;
import com.app.dao.OrderDao;

public class OrderDaoImpl  extends BaseDao implements OrderDao {

	/* 查询方法，暂时用于操作员销售查询界面
	 * @see com.app.dao.OrderDao#queryOrder(com.app.bean.Orderer)
	 */
	@Override
	public Vector<Orderer> queryOrder(Orderer orderer) {
		String sql = "select * from Orderer where 1=1 and order_id=? and OPERATOR_ID=? ";		
		Vector<Orderer> result = search(sql, Orderer.class,new Object[]{orderer.getOrderId(),orderer.getOperatorId()});
		return result;
	}

	@Override
	public boolean addOrder(Vector<Orderer> orderer) {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");   //设置日期格式
		String str=df.format(new Date()).toString();                    // new Date()为获取当前系统时间
		int row = update("insert into orderer(order_id,id,name,tel,flight_id,flight_date,ticket_sum,total_price,operator_id) values(?,?,?,?,?)", 
						new Object[]{str,orderer.get(1).getId(),orderer.get(1).getName(),orderer.get(1).getTel(),orderer.get(1).getFlightId(),
								    orderer.get(1).getFlightDate(),orderer.get(1).getTicketSum(),orderer.get(1).getTotalPrice(),orderer.get(1).getOperatorId()});
		boolean flag = row>0?true:false;
		return flag;
	}

	@Override
	public boolean deleteOrder(Vector<Orderer> orderer) {
		return false;
	}

	@Override
	public boolean updateOrder(Vector<Orderer> orderer) {
		return false;
	}
	@Override
	public boolean addOrder2(Orderer orderer) {             
		String sql="insert into orderer(operator_id,order_id,id,name,tel,flight_id,ticket_sum,total_price,order_time,flight_date) values(?,?,?,?,?,?,?,?,?,?)";
		int row = update(sql,new Object[]{orderer.getOperatorId(),orderer.getOrderId(),orderer.getId(),orderer.getName(),orderer.getTel(),orderer.getFlightId(),orderer.getTicketSum(),orderer.getTotalPrice(),orderer.getOrderTime(),orderer.getFlightDate()});
		boolean flag = row>0?true:false;
		return flag;
	}
	//用于操作员订单查询界面，查询orderid，包括退票的记录
	public Vector<Orderer>  selectOrdererId(Orderer orderer) {

		
		
		String sql = "select * from orderer where 1=1";
		if(orderer.getOrderId() != null){
			sql += " and order_id like '%"+orderer.getOrderId()+"%'";
		}
		if(orderer.getOperatorId() != null){
			sql  += " and operator_id like '%"+orderer.getOperatorId()+"%'";
		}
		sql += "order by order_id desc";
		Vector<Orderer> result = search(sql, Orderer.class, new Object[]{});
		return result;
		
		
		
		
	}
	public Vector<Orderer>  selectOrdererId2(Orderer orderer) {
		String sql = "select * from orderer where order_id like ?";
		Vector<Orderer> result = search(sql, Orderer.class,new Object[]{orderer.getOrderId()});
		return result;
	}
}
