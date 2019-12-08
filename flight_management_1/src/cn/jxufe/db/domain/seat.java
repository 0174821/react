package cn.jxufe.db.domain;

public class seat {
	private String planeno;
	private String seatno;
	private int cono;
	private int rowno;
	private String sellstatus;
	private String tankclassno;
	public String getPlaneno() {
		return planeno;
	}
	public void setPlaneno(String planeno) {
		this.planeno = planeno;
	}
	public String getSeatno() {
		return seatno;
	}
	public void setSeatno(String seatno) {
		this.seatno = seatno;
	}
	public int getCono() {
		return cono;
	}
	public void setCono(int cono) {
		this.cono = cono;
	}
	public int getRowno() {
		return rowno;
	}
	public void setRowno(int rowno) {
		this.rowno = rowno;
	}
	public String getSellstatus() {
		return sellstatus;
	}
	public void setSellstatus(String sellstatus) {
		this.sellstatus = sellstatus;
	}
	public String getTankclassno() {
		return tankclassno;
	}
	public void setTankclassno(String tankclassno) {
		this.tankclassno = tankclassno;
	}
	
}
