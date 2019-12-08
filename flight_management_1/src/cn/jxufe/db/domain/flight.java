package cn.jxufe.db.domain;

import java.util.Date;


public class flight {
	private String flightno;
	private String flightname;
	private Date flytime;
	private Date arrivetime;
	private String flyplace;
	private String arriveplace;
	private String distance;
	public String getFlightno() {
		return flightno;
	}
	public void setFlightno(String flightno) {
		this.flightno = flightno;
	}
	public String getFlightname() {
		return flightname;
	}
	public void setFlightname(String flightname) {
		this.flightname = flightname;
	}
	public Date getFlytime() {
		return flytime;
	}
	public void setFlytime(Date flytime) {
		this.flytime = flytime;
	}
	public Date getArrivetime() {
		return arrivetime;
	}
	public void setArrivetime(Date arrivetime) {
		this.arrivetime = arrivetime;
	}
	public String getFlyplace() {
		return flyplace;
	}
	public void setFlyplace(String flyplace) {
		this.flyplace = flyplace;
	}
	public String getArriveplace() {
		return arriveplace;
	}
	public void setArriveplace(String arriveplace) {
		this.arriveplace = arriveplace;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
}
