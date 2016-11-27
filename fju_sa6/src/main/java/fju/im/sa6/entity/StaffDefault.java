package fju.im.sa6.entity;

import java.util.ArrayList;
import java.util.Date;

public abstract class StaffDefault {

	private int staffNum;

	private String staffName;

	private boolean isManager;
	
	private ArrayList<workRecord> workRecord;
	
	//record the month of working day 
	private Date workMonth;

	private double worktimeTotal;

	public StaffDefault(int staffNum, String staffName, boolean isManager, Date onworkTime, Date offworkTime,
			Date workMonth, double worktimeTotal) {
		this.staffNum = staffNum;
		this.staffName = staffName;
		this.isManager = isManager;
		this.workRecord = workRecord;
		this.workMonth = workMonth;
		this.worktimeTotal = worktimeTotal;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public boolean isManager() {
		return isManager;
	}

	public void setManager(boolean isManager) {
		this.isManager = isManager;
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
	
	
	
	

}
