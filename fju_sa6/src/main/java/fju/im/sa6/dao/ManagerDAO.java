package fju.im.sa6.dao;

import java.sql.Date;
import java.util.ArrayList;

import fju.im.sa6.entity.Staff;
import fju.im.sa6.entity.StaffDefault;

public interface ManagerDAO {
	public void add(StaffDefault staffDefault);

	public void set(StaffDefault staffDefault);

	public void remove(StaffDefault staffDefault);

	public void setLevel(StaffDefault manager, StaffDefault staffStaffDefault);

	public ArrayList<StaffDefault> getList();

	double monthearntotal(String indicatedate);

	//double inquireAllWorktimeforALL(Date indicatedate);

	double inquireAllWorktime(StaffDefault staffDefault);
}