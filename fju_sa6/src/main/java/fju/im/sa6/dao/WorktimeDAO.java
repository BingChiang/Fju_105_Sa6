package fju.im.sa6.dao;

import fju.im.sa6.entity.StaffDefault;
import fju.im.sa6.entity.WorkRecord;

public interface WorktimeDAO {
	public double getDayWorktime(StaffDefault staffDefault);

	public void amendOnWork(WorkRecord workrecord);

	public void amendOffWork(WorkRecord workrecord);
}
