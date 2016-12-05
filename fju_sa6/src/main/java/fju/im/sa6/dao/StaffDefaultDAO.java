package fju.im.sa6.dao;

import java.util.ArrayList;
import fju.im.sa6.entity.Staff;
import fju.im.sa6.entity.StaffDefault;

public interface StaffDefaultDAO {
	public StaffDefault get(StaffDefault staffDefault, StaffDefault staffD);

	public ArrayList<Staff> getList(Staff allstaff);
}
