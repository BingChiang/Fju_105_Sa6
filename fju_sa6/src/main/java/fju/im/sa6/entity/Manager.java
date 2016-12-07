package fju.im.sa6.entity;

import java.util.Date;

//2016.11.30 by bing  .... and add int value
public class Manager extends StaffDefault {

	public Manager(int staffNum, String staffName, int staffLevel, Date onworkTime, Date offworDAkTime, Date workMonth,

			double worktimeTotal) {

		super(staffNum, staffName, staffLevel, workMonth, worktimeTotal);

		super.setStaffLevel(0);

		// TODO Auto-generated constructor stub
	}

	public Manager() {

		super();
		super.setStaffLevel(0);
	}

}
