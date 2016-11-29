package fju.im.sa6.entity;

import java.util.Date;

public class Manager extends StaffDefault {

	public Manager(int staffNum, String staffName, int staffLevel, Date onworkTime, Date offworkTime, Date workMonth,
			double worktimeTotal) {
		super(staffNum, staffName, staffLevel, onworkTime, offworkTime, workMonth, worktimeTotal);
		staffLevel = 0;
		// TODO Auto-generated constructor stub
	}

}
