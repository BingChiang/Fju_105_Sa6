package fju.im.sa6.dao;

import java.util.ArrayList;

import fju.im.sa6.entity.StaffDefault;

public interface StaffDefaultDAO {
	public StaffDefault get(StaffDefault staffDefault, StaffDefault staff);

	public ArrayList<StaffDefault> getList();
	
}
