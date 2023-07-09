package bms.staff.dto;

import java.sql.Date;

public class StaffDto {
	private int syain_id;
	private String com;
	private String name;
	private String sex;
	private String pjt;
	private Date NYUUSYA_DATE;
	private Date TAISYA_DATE;

	public String getCom() {
		return com;
	}
	public void setCom(String com) {
		this.com = com;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPjt() {
		return pjt;
	}
	public void setPjt(String pjt) {
		this.pjt = pjt;
	}
	public int getSyain_id() {
		return syain_id;
	}
	public void setSyain_id(int syain_id) {
		this.syain_id = syain_id;
	}
	public Date getNYUUSYA_DATE() {
		return NYUUSYA_DATE;
	}
	public void setNYUUSYA_DATE(Date nYUUSYA_DATE) {
		NYUUSYA_DATE = nYUUSYA_DATE;
	}
	public Date getTAISYA_DATE() {
		return TAISYA_DATE;
	}
	public void setTAISYA_DATE(Date tAISYA_DATE) {
		TAISYA_DATE = tAISYA_DATE;
	}
}
