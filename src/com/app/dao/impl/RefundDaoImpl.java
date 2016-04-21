package com.app.dao.impl;

import java.util.Vector;

import com.app.bean.Refund;
import com.app.dao.RefundDao;

public class RefundDaoImpl extends BaseDao implements  RefundDao{
	@Override
	public Vector<Refund> queryRefund(Vector<Refund> refund) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	//********************退票界面数据*************
	public boolean addRefund(Refund refund) {
		String sql="insert into refund(TICKET_ID,REFUND_REE,BACK_MONEY,OPERATOR_ID,REFUND_TIME,REFUND_TEL,REASON,REFUND_PERSON_ID,REFUND_PERSON) values(?,?,?,?,?,?,?,?,?)";
		int row = update(sql,new Object[]{refund.getTicketId(),refund.getRefundFee(),refund.getBackMoney(),refund.getOperatorId(),refund.getRefundTime(),refund.getRefundTel(),refund.getReson(),refund.getRefundPersonId(),refund.getRefundPerson()});
		boolean flag = row>0?true:false;
		return flag;
	}
	@Override
	public boolean deleteRefund(Vector<Refund> refund) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean updateRefund(Vector<Refund> refund) {
		// TODO Auto-generated method stub
		return false;
	}

}
