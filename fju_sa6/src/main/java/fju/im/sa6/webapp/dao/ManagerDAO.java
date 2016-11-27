package fju.im.sa6.webapp.dao;

import fju.im.sa6.entity.Manager;

public interface ManagerDAO {
	public void addStaff(Manager addstaff);

	public void set(Manager setstaff);

	public void remove(Manager removestaff);

	public Manager inquireAllWorktime(int inquireAWKT);

	public void setlevel(int staffNumlogin, int setstaffLv);
	

}
