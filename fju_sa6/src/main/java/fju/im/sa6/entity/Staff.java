package fju.im.sa6.entity;

import java.util.Date;

public class Staff extends StaffDefault {

	public Staff(int staffNum, String staffName, boolean isManager, Date onworkTime, Date offworkTime, Date workMonth,
			double worktimeTotal,int staffLv) {
		super(staffNum, staffName, isManager, onworkTime, offworkTime, workMonth, worktimeTotal,staffLv);
		isManager = false;

		// TODO Auto-generated constructor stub
	}


	
	

}
