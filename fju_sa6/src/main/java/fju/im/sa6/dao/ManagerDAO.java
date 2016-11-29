package fju.im.sa6.dao;

import fju.im.sa6.entity.Manager;
import fju.im.sa6.entity.StaffDefault;

public interface ManagerDAO {
	public void addStaff(StaffDefault addstaff);

	public void setStaff(StaffDefault setstaff);

	public void removeStaff(StaffDefault removestaff);

	public void inquireAllWorktime(StaffDefault inquireAWKT);

	public void setLevel(Manager manager , StaffDefault staff);
}
