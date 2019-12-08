package cn.jxufe.db.domain;

public class orderdetail {
	private String orderno;
	private String detailsno;
	private int ticketprice;
	private String ticketstatus;
	private String planeno;
	private String teamno;
	private String tankclassno;
	private String customerno;
	public String getOrderno() {
		return orderno;
	}
	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}
	public String getDetailsno() {
		return detailsno;
	}
	public void setDetailsno(String detailsno) {
		this.detailsno = detailsno;
	}
	public int getTicketprice() {
		return ticketprice;
	}
	public void setTicketprice(int ticketprice) {
		this.ticketprice = ticketprice;
	}
	public String getTicketstatus() {
		return ticketstatus;
	}
	public void setTicketstatus(String ticketstatus) {
		this.ticketstatus = ticketstatus;
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
	public String getTankclassno() {
		return tankclassno;
	}
	public void setTankclassno(String tankclassno) {
		this.tankclassno = tankclassno;
	}
	public String getCustomerno() {
		return customerno;
	}
	public void setCustomerno(String customerno) {
		this.customerno = customerno;
	}
}
