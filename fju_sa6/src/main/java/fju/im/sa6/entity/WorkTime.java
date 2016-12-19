package fju.im.sa6.entity;

import java.util.ArrayList;
import java.util.Date;

public class WorkTime {
	private Date date;

	private Date onwork;

	private Date offwork;

	private int staffNum;

	private String staffName;

	// Constructor
	public WorkTime(int staffNum, Date date, Date onwork, Date offwork) {
		this.staffNum = staffNum;
		this.date = date;
		this.onwork = onwork;
		this.offwork = offwork;
	}

	public WorkTime() {
		this.staffNum = 0;
		this.date = null;
		this.onwork = null;
		this.offwork = null;
		this.staffName = null;

	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public int getStaffNum() {
		return staffNum;
	}

	public void setStaffNum(int staffNum) {
		this.staffNum = staffNum;
	}

	public Date getdate() {
		return date;
	}

	public void setOnwork(Date onwork) {
		this.onwork = onwork;
	}

	public Date getOffwork(Date offwork) {
		return this.offwork = offwork;
	}

	public void setOffwork(Date offwork) {
		this.offwork = offwork;
	}

	public Date getOnwork(Date onwork) {
		return this.onwork = onwork;
	}

	public String getDate() {
		return this.date.toString();

	}

	public String getOnWorkTime() {
		if (onwork == null) {
			return "";
		} else {
			return this.onwork.toString();
		}
	}

	public String getOffWorkTime() {
		if (offwork == null) {
			return "";
		} else {
			return this.offwork.toString();
		}
	}

}