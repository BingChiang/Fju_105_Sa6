package fju.im.sa6.entity;

import java.util.Date;

public class Manager extends StaffDefault {

	public Manager(int staffNum, String staffName, boolean isManager, Date onworkTime, Date offworkTime, Date workMonth,
			double worktimeTotal, int staffLv) {
		super(staffNum, staffName, isManager, onworkTime, offworkTime, workMonth, worktimeTotal, staffLv);
		isManager = true;
		// TODO Auto-generated constructor stub
	}

}
