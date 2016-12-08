package fju.im.sa6.dao;

import java.sql.Date;
import fju.im.sa6.entity.WorkRecord;
import fju.im.sa6.entity.WorkTime;
import fju.im.sa6.entity.StaffDefault;

public interface WorktimeDAO {
	public double getDayWorktime(StaffDefault staffDefault);

	public void statffOnWork(StaffDefault staffDefault);

	public void staffOffWork(StaffDefault staffDefault);

	public void amendOnWork(StaffDefault staffDefault, Date date, Date on);

	public void amendOffWork(StaffDefault staffDefault, Date date, Date off);
	
	public WorkTime searchworktime(WorkTime workrecord, WorkTime workdate);
	
}
