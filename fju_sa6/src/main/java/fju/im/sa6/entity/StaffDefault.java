package fju.im.sa6.entity;

import java.util.Date;

public class StaffDefault {

	private int staffNum;

	private String staffName;

	private int staffLevel;

	private Date workMonth;

	private double worktimeTotal;
	
	private double daywork;

	
	public StaffDefault(int staffNum, String staffName, int staffLevel, Date workMonth, double worktimeTotal) {

		this.staffNum = staffNum;
		this.staffName = staffName;
		this.staffLevel = staffLevel;
		this.workMonth = workMonth;
		this.worktimeTotal = worktimeTotal;
	}

	public StaffDefault() {
		this.staffNum = 0;
		this.staffName = null;
		this.staffLevel = 1;
		this.workMonth = null;
		this.worktimeTotal = 0;
		this.daywork = 0;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public int getStaffLevel() {
		return this.staffLevel;
	}

	public void setStaffLevel(int staffLevel) {
		this.staffLevel = staffLevel;
	}

	public Date getWorkMonth() {
		return workMonth;
	}

	public void setWorkMonth(Date workMonth) {
		this.workMonth = workMonth;
	}

	public double getWorktimeTotal() {
		return worktimeTotal;
	}

	public void setWorktimeTotal(double worktimeTotal) {
		this.worktimeTotal = worktimeTotal;
	}

	public int getStaffNum() {
		return staffNum;
	}

	public void setStaffNum(int staffNum) {
		this.staffNum = staffNum;
	}
	
	public double getDaywork() {
		return daywork;
	}

	public void setDaywork(double daywork) {
		this.daywork = daywork;
	}

}