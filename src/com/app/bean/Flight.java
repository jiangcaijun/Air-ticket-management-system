package com.app.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Flight {
	private String flightId;
	private String originStation;
	private String  terminalStation;
	private String originAirport;
	private String terminalAirport;
	private String flightCompany;
	private Date startTime;         //精确到时分
	private Date endTime;           //精确到时分
	private BigDecimal distance;
	private BigDecimal sumOfFirstClass;
	private BigDecimal sumOfEconomyClass;
	private BigDecimal sumOfBusinessClass;
	private String aircraftType;
	private String planesFood;
	private String bordingGate;
	private BigDecimal firstClassPrice;
	private BigDecimal economyClassDiscount;
	private BigDecimal businessClassDiscount;
	private BigDecimal firstClassDiscount;
	private BigDecimal economyClassPrice;
	private BigDecimal businessClassPrice;
	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Flight(String flightId,String originStation, String terminalStation,
			String originAirport, String terminalAirport,String flightCompany, Date startTime, Date endTime, BigDecimal distance,
			BigDecimal sumOfFirstClass, BigDecimal sumOfEconomyClass, BigDecimal sumOfBusinessClass, String aircraftType, String planesFood,
			String bordingGate, BigDecimal firstClassPrice, BigDecimal economyClassDiscount, BigDecimal businessClassDiscount,
			BigDecimal firstClassDiscount, BigDecimal economyClassPrice, BigDecimal businessClassPrice) {
		super();
		this.flightCompany=flightCompany;
		this.flightId = flightId;
		this.originStation = originStation;
		this.terminalStation = terminalStation;
		this.originAirport = originAirport;
		this.terminalAirport = terminalAirport;
		this.startTime = startTime;
		this.endTime = endTime;
		this.distance = distance;
		this.sumOfFirstClass = sumOfFirstClass;
		this.sumOfEconomyClass = sumOfEconomyClass;
		this.sumOfBusinessClass = sumOfBusinessClass;
		this.aircraftType = aircraftType;
		this.planesFood = planesFood;
		this.bordingGate = bordingGate;
		this.firstClassPrice = firstClassPrice;
		this.economyClassDiscount = economyClassDiscount;
		this.businessClassDiscount = businessClassDiscount;
		this.firstClassDiscount = firstClassDiscount;
		this.economyClassPrice = economyClassPrice;
		this.businessClassPrice = businessClassPrice;
	}
	public String getFlightId() {
		return flightId;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	public String getOriginStation() {
		return originStation;
	}
	public void setOriginStation(String originStation) {
		this.originStation = originStation;
	}
	public String getTerminalStation() {
		return terminalStation;
	}
	public void setTerminalStation(String terminalStation) {
		this.terminalStation = terminalStation;
	}
	public String getOriginAirport() {
		return originAirport;
	}
	public void setOriginAirport(String originAirport) {
		this.originAirport = originAirport;
	}
	public String getTerminalAirport() {
		return terminalAirport;
	}
	public void setTerminalAirport(String terminalAirport) {
		this.terminalAirport = terminalAirport;
	}
	
	
	public String getFlightCompany() {
		return flightCompany;
	}
	public void setFlightCompany(String flightCompany) {
		this.flightCompany = flightCompany;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public BigDecimal getDistance() {
		return distance;
	}
	public void setDistance(BigDecimal distance) {
		this.distance = distance;
	}
	public BigDecimal getSumOfFirstClass() {
		return sumOfFirstClass;
	}
	public void setSumOfFirstClass(BigDecimal sumOfFirstClass) {
		this.sumOfFirstClass = sumOfFirstClass;
	}
	public BigDecimal getSumOfEconomyClass() {
		return sumOfEconomyClass;
	}
	public void setSumOfEconomyClass(BigDecimal sumOfEconomyClass) {
		this.sumOfEconomyClass = sumOfEconomyClass;
	}
	public BigDecimal getSumOfBusinessClass() {
		return sumOfBusinessClass;
	}
	public void setSumOfBusinessClass(BigDecimal sumOfBusinessClass) {
		this.sumOfBusinessClass = sumOfBusinessClass;
	}
	public String getAircraftType() {
		return aircraftType;
	}
	public void setAircraft(String aircraftType) {
		this.aircraftType = aircraftType;
	}
	public String getPlanesFood() {
		return planesFood;
	}
	public void setPlanesFood(String planesFood) {
		this.planesFood = planesFood;
	}
	public String getBordingGate() {
		return bordingGate;
	}
	public void setBordingGate(String bordingGate) {
		this.bordingGate = bordingGate;
	}
	public BigDecimal getFirstClassPrice() {
		return firstClassPrice;
	}
	public void setFirstClassPrice(BigDecimal firstClassPrice) {
		this.firstClassPrice = firstClassPrice;
	}
	public BigDecimal getEconomyClassDiscount() {
		return economyClassDiscount;
	}
	public void setEconomyClassDiscount(BigDecimal economyClassDiscount) {
		this.economyClassDiscount = economyClassDiscount;
	}
	public BigDecimal getBusinessClassDiscount() {
		return businessClassDiscount;
	}
	public void setBusinessClassDiscount(BigDecimal businessClassDiscount) {
		this.businessClassDiscount = businessClassDiscount;
	}
	public BigDecimal getFirstClassDiscount() {
		return firstClassDiscount;
	}
	public void setFirstClassDiscount(BigDecimal firstClassDiscount) {
		this.firstClassDiscount = firstClassDiscount;
	}
	public BigDecimal getEconomyClassPrice() {
		return economyClassPrice;
	}
	public void setEconomyClassPrice(BigDecimal economyClassPrice) {
		this.economyClassPrice = economyClassPrice;
	}
	public BigDecimal getBusinessClassPrice() {
		return businessClassPrice;
	}
	public void setBusinessClassPrice(BigDecimal businessClassPrice) {
		this.businessClassPrice = businessClassPrice;
	}
	
}