package com.app.dao;

import java.util.Vector;

import com.app.bean.Refund;

public interface RefundDao {
	public Vector<Refund> queryRefund(Vector<Refund> refund);
	
	public boolean addRefund(Refund refund);
	
	public boolean deleteRefund(Vector<Refund> refund);
	
	public boolean updateRefund(Vector<Refund> refund);
}
