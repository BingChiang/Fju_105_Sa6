package fju.im.sa6.webapp.dao;

import java.util.ArrayList;

import fju.im.sa6.entity.StaffDefault;

public interface StaffDefaultDAO {
	public StaffDefault get(int searchNum);
	public ArrayList<StaffDefault> getList();
}

