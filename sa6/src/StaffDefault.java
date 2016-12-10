public class StaffDefault extends Manager, Staff implements Monthtime, Worktime {

	private int staffNum;

	private String staffName;

	private int staffLv;

	public StaffDefault getStaff() {
		return null;
	}


	/**
	 * @see Monthtime#totalMonthWorktime()
	 */
	public double totalMonthWorktime() {
		return 0;
	}


	/**
	 * @see Monthtime#getMonthSalary()
	 */
	public double getMonthSalary() {
		return 0;
	}


	/**
	 * @see Worktime#getDayWorktime()
	 * 
	 *  
	 */
	public double getDayWorktime() {
		return 0;
	}


	/**
	 * @see Worktime#amendOnWork()
	 * 
	 *  
	 */
	public void amendOnWork() {

	}


	/**
	 * @see Worktime#amendOffWork()
	 * 
	 *  
	 */
	public void amendOffWork() {

	}

}
