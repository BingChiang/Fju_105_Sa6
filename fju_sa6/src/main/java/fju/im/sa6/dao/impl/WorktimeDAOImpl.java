package fju.im.sa6.dao.impl;

import fju.im.sa6.dao.WorktimeDAO;
import fju.im.sa6.entity.StaffDefault;
import fju.im.sa6.entity.WorkTime;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.sql.DataSource;

public class WorktimeDAOImpl implements WorktimeDAO {
	private DataSource dataSource;
	private Connection conn = null;
	private Connection conn1 = null;
	private ResultSet rs = null;
	private ResultSet rs2 = null;
	private PreparedStatement smt = null;
	private PreparedStatement smt2 = null;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public ArrayList<StaffDefault> getDayWorktime(Date date) {
		// TODO Auto-generated method stub
		ArrayList<StaffDefault> arr = new ArrayList<StaffDefault>();
		StaffDefault staff = new StaffDefault();
		double dayworktime = 0;
		String sql = "SELECT * FROM staff WHERE work_date = ? ";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setDate(1, date);
			rs = smt.executeQuery();
			if (rs.next()) {
				int setstaffNum = (rs.getInt("staff_num"));
				double setontime = (rs.getDouble("onwork_time"));
				double setoffworktime = (rs.getDouble("offwork_time"));
				double setdayworktime = (rs.getDouble((int) (setoffworktime - setontime)));
				dayworktime = setdayworktime;
				staff = new StaffDefault(setstaffNum, null, 0, null, setdayworktime);
				staff.setDaywork(dayworktime);
				arr.add(staff);
			}
			rs.close();
			smt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return arr;
	}

	@Override
	public void statffOnWork(StaffDefault staffDefault) {
		String sql1 = "SELECT * FROM worktime WHERE staff_num=? AND work_date = CURDATE();";
		try {

			conn1 = dataSource.getConnection();

			smt2 = conn1.prepareStatement(sql1);

			smt2.setInt(1, staffDefault.getStaffNum());

			rs = smt2.executeQuery();

			if (rs != null) {

			}
			boolean doit = false;
			Date checkdate = null;
			Time onwork = null;
			Time offwork = null;
			int changeNum = 0;
			while (rs.next()) {

				// System.out.println(rs.getDate("work_date").toString());
				// System.out.println(rs.getTime("onwork_time").toString());

				checkdate = rs.getDate("work_date");
				onwork = rs.getTime("onwork_time");
				offwork = rs.getTime("offwork_time");
				changeNum = rs.getInt("num");

				if (checkdate != null && onwork != null && offwork != null) {
					System.out.println("LOOK");
				} else {
					doit = true;
				}
				//
			}
			// smt.executeUpdate();
			smt2.close();
			if (doit == false) {
				String sql = "INSERT into worktime (staff_num, work_date, onwork_time) VALUES(?,Now(), Now())";
				try {
					conn = dataSource.getConnection();
					smt = conn.prepareStatement(sql);
					smt.setInt(1, staffDefault.getStaffNum());
					smt.executeUpdate();
					smt.close();
					// System.out.println("id ="+aProduct.getId());

				} catch (SQLException e) {
					throw new RuntimeException(e);

				} finally {
					if (conn != null) {
						try {
							conn.close();
						} catch (SQLException e) {
						}
					}
				}
			} else if (checkdate != null && offwork != null) {
				String sql = "UPDATE worktime SET onwork_time = Now() WHERE num = " + changeNum;
				try {
					conn = dataSource.getConnection();
					smt = conn.prepareStatement(sql);
					// smt.setInt(1, staffDefault.getStaffNum());
					smt.executeUpdate();
					smt.close();

				} catch (SQLException e) {
					throw new RuntimeException(e);

				} finally {
					if (conn != null) {
						try {
							conn.close();
						} catch (SQLException e) {
						}
					}

				}
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

	}

	@Override
	public void staffOffWork(StaffDefault staffDefault) {
		String sql1 = "SELECT * FROM worktime WHERE staff_num=? AND work_date = CURDATE();";
		try {

			conn1 = dataSource.getConnection();

			smt2 = conn1.prepareStatement(sql1);

			smt2.setInt(1, staffDefault.getStaffNum());

			rs = smt2.executeQuery();

			if (rs != null) {

			}
			boolean doit = false;
			Date checkdate = null;
			Time onwork = null;
			Time offwork = null;
			int changeNum = 0;
			while (rs.next()) {

				// System.out.println(rs.getDate("work_date").toString());
				// System.out.println(rs.getTime("onwork_time").toString());

				checkdate = rs.getDate("work_date");
				onwork = rs.getTime("onwork_time");
				offwork = rs.getTime("offwork_time");
				changeNum = rs.getInt("num");

				if (checkdate != null && onwork != null && offwork != null) {
					System.out.println("LOOK");
				} else {
					doit = true;
				}
				//
			}
			// smt.executeUpdate();
			smt2.close();
			if (doit == false) {
				String sql = "INSERT into worktime (staff_num, work_date, offwork_time) VALUES(?,Now(), Now())";
				try {
					conn = dataSource.getConnection();
					smt = conn.prepareStatement(sql);
					smt.setInt(1, staffDefault.getStaffNum());
					smt.executeUpdate();
					smt.close();
					// System.out.println("id ="+aProduct.getId());

				} catch (SQLException e) {
					throw new RuntimeException(e);

				} finally {
					if (conn != null) {
						try {
							conn.close();
						} catch (SQLException e) {
						}
					}
				}
			} else if (checkdate != null && onwork != null) {
				String sql = "UPDATE worktime SET offwork_time = Now() WHERE num = " + changeNum;
				try {
					conn = dataSource.getConnection();
					smt = conn.prepareStatement(sql);
					// smt.setInt(1, staffDefault.getStaffNum());
					smt.executeUpdate();
					smt.close();

				} catch (SQLException e) {
					throw new RuntimeException(e);

				} finally {
					if (conn != null) {
						try {
							conn.close();
						} catch (SQLException e) {
						}
					}

				}
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

	}

	public void amendOnWork(StaffDefault staffDefault, String date) throws ParseException {
		// TODO Auto-generated method stub
		// String sql1 = "SELECT work_date,onwork_time FROM worktime WHERE
		// staff_num=?";

		// conn = dataSource.getConnection();
		// smt = conn.prepareStatement(sql1);
		// String dateStr = date+":00";
		// System.out.print(dateStr);
		String date1 = date.substring(0, 10);
		String time1 = date.substring(11) + ":00";

		String pattern = "yyyy-MM-dd";
		java.util.Date parseDate = null;
		java.sql.Date parseDate1 = null;

		parseDate = new SimpleDateFormat(pattern).parse(date1);

		// parseDate = new SimpleDateFormat(pattern).parse(dateStr);
		parseDate1 = new java.sql.Date(parseDate.getTime());

		String pattern1 = "HH:mm:ss";
		java.util.Date parseTime = null;
		java.sql.Time parseTime1 = null;
		parseTime = new SimpleDateFormat(pattern1).parse(time1);

		// parseDate = new SimpleDateFormat(pattern).parse(dateStr);
		parseTime1 = new java.sql.Time(parseTime.getTime());

		System.out.print("test" + parseDate1);
		System.out.print("test" + parseTime1);

		// ===============================down is onwork method=================

		int staffNum = staffDefault.getStaffNum();

		String sql1 = "SELECT * FROM worktime WHERE staff_num=? AND work_date ='" + parseDate1 + "'";
		try {

			conn1 = dataSource.getConnection();

			smt2 = conn1.prepareStatement(sql1);

			smt2.setInt(1, staffNum);

			rs = smt2.executeQuery();

			if (rs != null) {

			}
			boolean doit = false;
			Date checkdate = null;
			Time onwork = null;
			Time offwork = null;
			int changeNum = 0;
			while (rs.next()) {

				// System.out.println(rs.getDate("work_date").toString());
				// System.out.println(rs.getTime("onwork_time").toString());

				checkdate = rs.getDate("work_date");
				onwork = rs.getTime("onwork_time");
				offwork = rs.getTime("offwork_time");
				changeNum = rs.getInt("num");

				if (checkdate != null && onwork != null && offwork != null) {
					System.out.println("LOOK");
				} else {
					doit = true;
				}
				//
			}
			// smt.executeUpdate();
			smt2.close();
			if (doit == false) {
				String sql = "INSERT into worktime (staff_num, work_date, onwork_time) VALUES(?,?,?)";
				try {
					conn = dataSource.getConnection();
					smt = conn.prepareStatement(sql);
					smt.setInt(1, staffDefault.getStaffNum());
					smt.setDate(2, parseDate1);
					smt.setTime(3, parseTime1);
					smt.executeUpdate();
					smt.close();
					// System.out.println("id ="+aProduct.getId());

				} catch (SQLException e) {
					throw new RuntimeException(e);

				} finally {
					if (conn != null) {
						try {
							conn.close();
						} catch (SQLException e) {
						}
					}
				}
			} else if (checkdate != null && offwork != null) {
				String sql = "UPDATE worktime SET onwork_time = ? WHERE num = " + changeNum;
				try {
					conn = dataSource.getConnection();
					smt = conn.prepareStatement(sql);
					smt.setTime(1, parseTime1);
					smt.executeUpdate();
					smt.close();

				} catch (SQLException e) {
					throw new RuntimeException(e);

				} finally {
					if (conn != null) {
						try {
							conn.close();
						} catch (SQLException e) {
						}
					}

				}
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}
	// ===============================up is onwork method=================
	// if (doit == true) {
	// String sql = "INSERT into worktime (staff_num, work_date, onwork_time)
	// VALUES(?, ?, ?)";
	// try {
	// conn = dataSource.getConnection();
	// smt = conn.prepareStatement(sql);
	// smt.setInt(1, staffDefault.getStaffNum());
	// System.out.print(staffDefault.getStaffNum());
	// smt.setDate(2, parseDate1);
	// smt.setTime(3, parseTime1);
	// smt.executeUpdate();
	// smt.close();
	// } catch (SQLException e) {
	// throw new RuntimeException(e);
	//
	// } finally {
	// if (conn != null) {
	// try {
	// conn.close();
	// } catch (SQLException e) {
	// }
	// }
	// }
	// // }
	// // else {
	// // conn.rollback();
	// // }
	// } finally {
	// if (conn != null) {
	// try {
	// conn.close();
	// } catch (SQLException e) {
	// }
	// }
	// }

	@Override
	public void amendOffWork(StaffDefault staffDefault, String date) throws ParseException {
		String date1 = date.substring(0, 10);
		String time1 = date.substring(11) + ":00";

		String pattern = "yyyy-MM-dd";
		java.util.Date parseDate = null;
		java.sql.Date parseDate1 = null;

		parseDate = new SimpleDateFormat(pattern).parse(date1);

		// parseDate = new SimpleDateFormat(pattern).parse(dateStr);
		parseDate1 = new java.sql.Date(parseDate.getTime());

		String pattern1 = "HH:mm:ss";
		java.util.Date parseTime = null;
		java.sql.Time parseTime1 = null;
		parseTime = new SimpleDateFormat(pattern1).parse(time1);

		// parseDate = new SimpleDateFormat(pattern).parse(dateStr);
		parseTime1 = new java.sql.Time(parseTime.getTime());

		System.out.print("test" + parseDate1);
		System.out.print("test" + parseTime1);

		// ===============================down is onwork method=================

		int staffNum = staffDefault.getStaffNum();

		String sql1 = "SELECT * FROM worktime WHERE staff_num=? AND work_date ='" + parseDate1 + "'";
		try {

			conn1 = dataSource.getConnection();

			smt2 = conn1.prepareStatement(sql1);

			smt2.setInt(1, staffNum);

			rs = smt2.executeQuery();

			if (rs != null) {

			}
			boolean doit = false;
			Date checkdate = null;
			Time onwork = null;
			Time offwork = null;
			int changeNum = 0;
			while (rs.next()) {

				// System.out.println(rs.getDate("work_date").toString());
				// System.out.println(rs.getTime("onwork_time").toString());

				checkdate = rs.getDate("work_date");
				onwork = rs.getTime("onwork_time");
				offwork = rs.getTime("offwork_time");
				changeNum = rs.getInt("num");

				if (checkdate != null && onwork != null && offwork != null) {
					System.out.println("LOOK");
				} else {
					doit = true;
				}
				//
			}
			// smt.executeUpdate();
			smt2.close();
			if (doit == false) {
				String sql = "INSERT into worktime (staff_num, work_date, offwork_time) VALUES(?,?,?)";
				try {
					conn = dataSource.getConnection();
					smt = conn.prepareStatement(sql);
					smt.setInt(1, staffDefault.getStaffNum());
					smt.setDate(2, parseDate1);
					smt.setTime(3, parseTime1);
					smt.executeUpdate();
					smt.close();
					// System.out.println("id ="+aProduct.getId());

				} catch (SQLException e) {
					throw new RuntimeException(e);

				} finally {
					if (conn != null) {
						try {
							conn.close();
						} catch (SQLException e) {
						}
					}
				}
			} else if (checkdate != null && onwork != null) {
				String sql = "UPDATE worktime SET offwork_time = ? WHERE num = " + changeNum;
				try {
					conn = dataSource.getConnection();
					smt = conn.prepareStatement(sql);
					smt.setTime(1, parseTime1);
					smt.executeUpdate();
					smt.close();

				} catch (SQLException e) {
					throw new RuntimeException(e);

				} finally {
					if (conn != null) {
						try {
							conn.close();
						} catch (SQLException e) {
						}
					}

				}
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	@Override
	public ArrayList<WorkTime> searchworktime(Date date) {
		ArrayList<WorkTime> worktime = new ArrayList<WorkTime>();
		WorkTime work = new WorkTime();
		String sql = "SELECT * FROM worktime WHERE work_date = ?";
		String sql2 = "SELECT staff_name FROM staff WHERE staff_num = ?";
		try {
			conn = dataSource.getConnection();
			conn1 = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt2 = conn1.prepareStatement(sql2);
			smt.setDate(1, date);
			rs = smt.executeQuery();
			if (rs.next()) {
				smt2.setInt(1, rs.getInt("staff_num"));
				rs2 = smt2.executeQuery();

				int setstaffNum = (rs.getInt("staff_num"));
				Date setworkDate = (rs.getDate("work_date"));
				Date setonworkTime = (rs.getDate("onwork_time"));
				Date setoffworkTime = (rs.getDate("offwork_time"));
				worktime.add(new WorkTime(setstaffNum, setworkDate, setonworkTime, setoffworkTime));
				work.setStaffName(rs2.getString("staff_name"));

			}
			rs.close();
			smt.close();
			rs2.close();
			smt2.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return worktime;

	}

}