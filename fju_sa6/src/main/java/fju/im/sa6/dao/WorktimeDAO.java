package fju.im.sa6.dao;

import java.sql.Date;
import fju.im.sa6.entity.WorkTime;
import java.util.ArrayList;
import fju.im.sa6.entity.StaffDefault;

public interface WorktimeDAO {
	public ArrayList<StaffDefault> getDayWorktime(Date date);

	public void statffOnWork(StaffDefault staffDefault);

	public void staffOffWork(StaffDefault staffDefault);

	public void amendOnWork(StaffDefault staffDefault, Date date, Date time);

	public void amendOffWork(StaffDefault staffDefault, Date date, Date time);
	
	public ArrayList<WorkTime> searchworktime(Date date);

	
}
