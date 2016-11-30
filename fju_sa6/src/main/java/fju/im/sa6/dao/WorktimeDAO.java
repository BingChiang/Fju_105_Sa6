package fju.im.sa6.dao;

import java.sql.Date;

import fju.im.sa6.entity.StaffDefault;

public interface WorktimeDAO {
	public double getDayWorktime(StaffDefault staffDefault);
	
	public void statffOnWork(StaffDefault staffDefault);
	
	public void staffOffWork(StaffDefault staffDefault);
	
	public void amendOnWork(StaffDefault staffDefault, Date date );

	public void amendOffWork(StaffDefault staffDefault, Date date);
}
