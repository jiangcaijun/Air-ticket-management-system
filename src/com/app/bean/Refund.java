package com.app.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Refund {
	private String ticketId;
	private BigDecimal refundFee;
	private BigDecimal backMoney;
	private Date refundTime;
	private String refundPerson;
	private String refundTel;
	private String operatorId;
	private String reason;
	private String refundPersonId;
	public String getTicketId() {
		return ticketId;
	}
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}
	public BigDecimal getRefundFee() {
		return refundFee;
	}
	public void setRefundFee(BigDecimal refundFee) {
		this.refundFee = refundFee;
	}
	public BigDecimal getBackMoney() {
		return backMoney;
	}
	public void setBackMoney(BigDecimal backMoney) {
		this.backMoney = backMoney;
	}
	public Date getRefundTime() {
		return refundTime;
	}
	public void setRefundTime(Date refundTime) {
		this.refundTime = refundTime;
	}
	public String getRefundPerson() {
		return refundPerson;
	}
	public void setRefundPerson(String refundPerson) {
		this.refundPerson = refundPerson;
	}
	public String getRefundTel() {
		return refundTel;
	}
	public void setRefundTel(String refundTel) {
		this.refundTel = refundTel;
	}
	public String getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}
	public String getReson() {
		return reason;
	}
	public void setReson(String reson) {
		this.reason = reson;
	}
	public String getRefundPersonId() {
		return refundPersonId;
	}
	public void setRefundPersonId(String refundPersonId) {
		this.refundPersonId = refundPersonId;
	}
	public Refund() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Refund(String ticketId, BigDecimal refundFee, BigDecimal backMoney, Date refundTime, String refundPerson,
			String refundTel, String operatorId, String reason, String refundPersonId) {
		super();
		this.ticketId = ticketId;
		this.refundFee = refundFee;
		this.backMoney = backMoney;
		this.refundTime = refundTime;
		this.refundPerson = refundPerson;
		this.refundTel = refundTel;
		this.operatorId = operatorId;
		this.reason = reason;
		this.refundPersonId = refundPersonId;
	}	
}
