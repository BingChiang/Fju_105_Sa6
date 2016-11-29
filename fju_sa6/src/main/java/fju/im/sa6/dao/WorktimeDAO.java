package fju.im.sa6.dao;

import fju.im.sa6.entity.StaffDefault;

public interface WorktimeDAO {
	public double getDayWorktime(StaffDefault staffDefault);

	public void amendOnWork(StaffDefault staffDefault);

	public void amendOffWork(StaffDefault staffDefault);
}
