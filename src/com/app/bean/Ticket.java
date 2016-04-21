package com.app.bean;

public class Ticket {
	private String ticketId;
	private String orderId;
	private String id;
	private String name;
	private String tel;
	private String email;
	private String status;
	private String seat;
	private String seatType;
	private String barCode;
	private String isCancel;
	
	public Ticket(String ticketId, String orderId, String id, String name, String tel, String email, String status,
			String seat, String seatType, String barCode, String isCancel) {
		super();
		this.ticketId = ticketId;
		this.orderId = orderId;
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.email = email;
		this.status = status;
		this.seat = seat;
		this.seatType = seatType;
		this.barCode = barCode;
		this.isCancel = isCancel;
	}
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTicketId() {
		return ticketId;
	}
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	public String getSeatType() {
		return seatType;
	}
	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	public String getIsCancel() {
		return isCancel;
	}
	public void setIsCancel(String isCancel) {
		this.isCancel = isCancel;
	}
	
}
