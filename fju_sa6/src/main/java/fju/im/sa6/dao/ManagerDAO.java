package fju.im.sa6.dao;

import fju.im.sa6.entity.StaffDefault;

public interface ManagerDAO extends StaffDefaultDAO {
	public void add(StaffDefault staffDefault);

	public void set(StaffDefault staffDefault);

	public void remove(StaffDefault staffDefault);

	public double inquireAllWorktime(StaffDefault staffDefault);

	public void setLevel(StaffDefault manager, StaffDefault staffStaffDefault);
}
