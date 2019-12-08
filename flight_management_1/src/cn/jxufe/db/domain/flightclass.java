package cn.jxufe.db.domain;

import java.util.Date;

public class flightclass {
	private String flightno;
	private String flightclassno;
	private Date takeoff;
	private Date arrival;
	private String planeno;
	private String teamno;
	private Date dates;
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
	public Date getTakeoff() {
		return takeoff;
	}
	public void setTakeoff(Date takeoff) {
		this.takeoff = takeoff;
	}
	public Date getArrival() {
		return arrival;
	}
	public void setArrival(Date arrival) {
		this.arrival = arrival;
	}
	public String getPlaneno() {
		return planeno;
	}
	public void setPlaneno(String planeno) {
		this.planeno = planeno;
	}
	public String getTeamno() {
		return teamno;
	}
	public void setTeamno(String teamno) {
		this.teamno = teamno;
	}
	public Date getDates() {
		return dates;
	}
	public void setDates(Date dates) {
		this.dates = dates;
	}
}
