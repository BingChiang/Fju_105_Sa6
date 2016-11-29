package fju.im.sa6.entity;

import java.util.Date;

public class Manager extends StaffDefault {

<<<<<<< HEAD
	public Manager(int staffNum, String staffName, int staffLevel, Date onworkTime, Date offworkTime, Date workMonth,
			double worktimeTotal) {
		super(staffNum, staffName, staffLevel, onworkTime, offworkTime, workMonth, worktimeTotal);
		staffLevel = 0;
=======
	public Manager(int staffNum, String staffName, boolean isManager, Date onworkTime, Date offworkTime, Date workMonth,
			double worktimeTotal, int staffLv) {
		super(staffNum, staffName, isManager, onworkTime, offworkTime, workMonth, worktimeTotal, staffLv);
		isManager = true;
>>>>>>> refs/remotes/origin/Cheyu
		// TODO Auto-generated constructor stub
	}

}
