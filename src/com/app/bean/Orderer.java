package com.app.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Orderer {
	private String orderId;
	private String id;
	private String name;
	private String tel;
	private String email;
	private String flightId;
	private Date flightDate;
	private BigDecimal ticketSum;       //BigDecimal对应orcal数据库中 number
	private BigDecimal totalPrice;  
	private Date orderTime;
	private String operatorId;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFlightId() {
		return flightId;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	public Date getFlightDate() {
		return flightDate;
	}
	public void setFlightDate(Date flightDate) {
		this.flightDate = flightDate;
	}
	public BigDecimal getTicketSum() {
		return ticketSum;
	}
	public void setTicketSum(BigDecimal ticketSum) {
		this.ticketSum = ticketSum;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public String getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}
	public Orderer() {
		super();
	}
	public Orderer(String orderId, String id, String name, String tel, String email, String flightId, Date flightDate,
			BigDecimal ticketSum, BigDecimal totalPrice, Date orderTime, String operatorId) {
		super();
		this.orderId = orderId;
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.email = email;
		this.flightId = flightId;
		this.flightDate = flightDate;
		this.ticketSum = ticketSum;
		this.totalPrice = totalPrice;
		this.orderTime = orderTime;
		this.operatorId = operatorId;
	}
	
}
