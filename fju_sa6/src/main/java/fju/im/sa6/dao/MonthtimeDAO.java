package fju.im.sa6.dao;

import fju.im.sa6.entity.StaffDefault;

public interface MonthtimeDAO {
	public double totalMonthWorktime(StaffDefault staffDefault);
	
	public double getMonthSalary(StaffDefault staffDefault);
}
