package fju.im.sa6.dao;

import fju.im.sa6.entity.Manager;
import fju.im.sa6.entity.StaffDefault;

public interface ManagerDAO {
	public void addStaff(StaffDefault staffDefault);

	public void setStaff(StaffDefault staffDefault);

	public void removeStaff(StaffDefault staffDefault);

	public double inquireAllWorktime(StaffDefault staffDefault);

	public void setLevel(Manager manager , StaffDefault staffDefault);
}
