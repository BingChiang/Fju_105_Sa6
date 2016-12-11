package fju.im.sa6.entity;

import java.util.Date;

public abstract class StaffDefault {

	private int staffNum;

	private String staffName;

	private int staffLevel;

	// record the month of working day
	private Date workMonth;

	private double worktimeTotal;
	private double daywork;

	// rebuild by bing 2016.11.30 and add init value
	public StaffDefault(int staffNum, String staffName, int staffLevel, double worktimeTotal) {

		this.staffNum = staffNum;
		this.staffName = staffName;
		this.staffLevel = staffLevel;
		this.worktimeTotal = worktimeTotal;
	}

	public StaffDefault() {
		this.staffNum = 0;
		this.staffName = "";
		this.staffLevel = 0;
		this.worktimeTotal = 0;
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

}