package fju.im.sa6.dao;

import java.util.ArrayList;

import fju.im.sa6.entity.Staff;
import fju.im.sa6.entity.StaffDefault;

public interface ManagerDAO {
	public void add(StaffDefault staffDefault);

	public void set(StaffDefault staffDefault);

	public void remove(StaffDefault staffDefault);

	public double inquireAllWorktime();

	public void setLevel(StaffDefault manager, StaffDefault staffStaffDefault);

	public ArrayList<StaffDefault> getList();

	public double monthearntotal();
}
