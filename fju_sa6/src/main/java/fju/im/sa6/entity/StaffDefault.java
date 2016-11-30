package fju.im.sa6.entity;

import java.util.ArrayList;
import java.util.Date;

public abstract class StaffDefault {

	private int staffNum;

	private String staffName;

<<<<<<< HEAD
	private boolean isManager;
	
	private ArrayList<WorkRecord> workRecord;
	
	//record the month of working day 
=======
	private int staffLevel;

	private ArrayList<WorkRecord> workRecord;

	// record the month of working day
>>>>>>> refs/remotes/allen/Cheyu
	private Date workMonth;

	private double worktimeTotal;

	// rebuild by bing 2016.11.30 and add init value
	public StaffDefault(int staffNum, String staffName, int staffLevel,
			Date workMonth, double worktimeTotal) {

		this.staffNum = staffNum;
		this.staffName = staffName;
<<<<<<< HEAD
		this.isManager = isManager;
=======
		this.staffLevel = staffLevel;
		this.workRecord = workRecord;
>>>>>>> refs/remotes/allen/Cheyu
		this.workMonth = workMonth;
		this.worktimeTotal = worktimeTotal;
	}
	
	public StaffDefault(){
		this.staffNum = 0;
		this.staffName = null;
		this.staffLevel = 1;
		this.workRecord = null;
		this.workMonth = null;
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

<<<<<<< HEAD
	
	public void setManager(boolean isManager) {
		this.isManager = isManager;
		
=======
	public void setStaffLevel(int staffLevel) {
		this.staffLevel = staffLevel;
>>>>>>> refs/remotes/allen/Cheyu
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
	public void setStaffNum(int staffNum){
		this.staffNum = staffNum;
	}

}
