package fju.im.sa6.dao;

import fju.im.sa6.entity.Manager;
import fju.im.sa6.entity.StaffDefault;

public interface ManagerDAO {
	public void add(StaffDefault staffDefault);

	public void set(StaffDefault staffDefault);

	public void remove(StaffDefault staffDefault);

	public void inquireAllWorktime(StaffDefault staffDefault);

	public void setLevel(StaffDefault manager, StaffDefault staffStaffDefault);
}
