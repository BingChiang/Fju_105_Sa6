package fju.im.sa6.entity;

import java.util.ArrayList;
import java.util.Date;

public abstract class StaffDefault {

	private int staffNum, staffLv;

	private String staffName;

	private int  staffLevel;
	
<<<<<<< HEAD
	private ArrayList<WorkRecord> workRecord;
=======
	private ArrayList<workRecord> workRecord;
>>>>>>> refs/remotes/origin/Cheyu
	
	//record the month of working day 
	private Date workMonth;

	private double worktimeTotal;

<<<<<<< HEAD
	public StaffDefault(int staffNum, String staffName, int staffLevel, Date onworkTime, Date offworkTime,
			Date workMonth, double worktimeTotal) {
=======
	public StaffDefault(int staffNum, String staffName, boolean isManager, Date onworkTime, Date offworkTime,
			Date workMonth, double worktimeTotal, int staffLv) {
>>>>>>> refs/remotes/origin/Cheyu
		this.staffNum = staffNum;
		this.staffName = staffName;
<<<<<<< HEAD
		this.staffLevel = staffLevel;
=======
		this.isManager = isManager;
>>>>>>> refs/remotes/origin/Cheyu
		this.workRecord = workRecord;
		this.workMonth = workMonth;
		this.worktimeTotal = worktimeTotal;
		this.staffLv = staffLv;
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

	public void setManager(int staffLevel) {
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
	public int getStaffLv(){
		return staffLv;
		
	}
	public void setstaffLv(int staffLv){
		this.staffLv = staffLv;
	}
	
	
	

}
