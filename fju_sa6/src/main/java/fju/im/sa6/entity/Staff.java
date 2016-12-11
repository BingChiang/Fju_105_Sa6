package fju.im.sa6.entity;

import java.util.Date;

public class Staff extends StaffDefault {

	public Staff(int staffNum, String staffName, int staffLevel, Date workMonth, double worktimeTotal) {

		super(staffNum, staffName, staffLevel, workMonth, worktimeTotal);
		staffLevel = 1;

		// TODO Auto-generated constructor stub
	}

}
