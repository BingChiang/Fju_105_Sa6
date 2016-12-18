package fju.im.sa6.dao;

import java.sql.Date;
import java.text.ParseException;

import fju.im.sa6.entity.WorkTime;
import java.util.ArrayList;
import fju.im.sa6.entity.StaffDefault;

public interface WorktimeDAO {
	public ArrayList<StaffDefault> getDayWorktime(Date date);

	public void statffOnWork(StaffDefault staffDefault);

	public void staffOffWork(StaffDefault staffDefault);

	public void amendOnWork(StaffDefault staffDefault, String date) throws ParseException;

<<<<<<< HEAD
	public void amendOffWork(StaffDefault staffDefault, String date) throws ParseException;
	
=======
	public void amendOffWork(StaffDefault staffDefault, String date);

>>>>>>> branch 'Cheyu' of https://github.com/BingChiang/Fju_105_Sa6
	public ArrayList<WorkTime> searchworktime(Date date);

}
