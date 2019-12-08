package cn.jxufe.db.domain;

import java.util.Date;

public class ordermaster {
	private String orderno;
	private Date ordertime;
	private String money;
	private String ticketsum;
	private String orderstatus;
	private String userno;
	private String flightno;
	private String flightclassno;
	public String getOrderno() {
		return orderno;
	}
	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}
	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getTicketsum() {
		return ticketsum;
	}
	public void setTicketsum(String ticketsum) {
		this.ticketsum = ticketsum;
	}
	public String getOrderstatus() {
		return orderstatus;
	}
	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}
	public String getUserno() {
		return userno;
	}
	public void setUserno(String userno) {
		this.userno = userno;
	}
	public String getFlightno() {
		return flightno;
	}
	public void setFlightno(String flightno) {
		this.flightno = flightno;
	}
	public String getFlightclassno() {
		return flightclassno;
	}
	public void setFlightclassno(String flightclassno) {
		this.flightclassno = flightclassno;
	}
}
