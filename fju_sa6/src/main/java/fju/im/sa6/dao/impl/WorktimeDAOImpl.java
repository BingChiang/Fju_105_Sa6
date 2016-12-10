package fju.im.sa6.dao.impl;

import fju.im.sa6.dao.WorktimeDAO;
import fju.im.sa6.entity.StaffDefault;
import fju.im.sa6.entity.WorkTime;
import java.sql.*;
import javax.sql.DataSource;

public class WorktimeDAOImpl implements WorktimeDAO {
	private DataSource dataSource;
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement smt = null;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public double getDayWorktime(StaffDefault staffDefault) {
		// TODO Auto-generated method stub
		double dayworktime = 0;
		String sql = "SELECT * FROM staff WHERE staff_num = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, staffDefault.getStaffNum());
			rs = smt.executeQuery();
			if (rs.next()) {
				double setontime = (rs.getDouble("onwork_time"));
				double setoffworktime = (rs.getDouble("offwork_time"));
				double setdayworktime = (rs.getDouble((int) (setoffworktime - setontime)));

				dayworktime = setdayworktime;
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
		return dayworktime;
	}

	@Override
	public void statffOnWork(StaffDefault staffDefault) {
		String sql = "INSERT into worktime (staff_num, work_date, onwork_time) VALUES(?, select TO_CHAR(ADD_MONTHS(sysdate,-1),'mmdd') from worktime), Now())";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, staffDefault.getStaffNum());
			smt.setDate(2, (Date) staffDefault.getWorkMonth());
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

	}

	@Override
	public void staffOffWork(StaffDefault staffDefault) {
		String sql = "INSERT into worktime (staff_num, work_date, offwork_time) VALUES(?, select TO_CHAR(ADD_MONTHS(sysdate,-1),'mmdd') from worktime), Now())";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, staffDefault.getStaffNum());
			smt.setDate(2, (Date) staffDefault.getWorkMonth());
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

	}

	@Override
	public void amendOnWork(StaffDefault staffDefault, Date date, Date on) {
		// TODO Auto-generated method stub
		String sql = "INSERT into worktime (staff_num, work_date, onwork_time) VALUES(?, ?, ?)";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, staffDefault.getStaffNum());
			smt.setDate(2, date);
			smt.setDate(2, on);
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

	}

	@Override
	public void amendOffWork(StaffDefault staffDefault, Date date, Date off) {
		// TODO Auto-generated method stub
		String sql = "INSERT into worktime (staff_num, work_date, offwork_time) VALUES(?, ?, ?)";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, staffDefault.getStaffNum());
			smt.setDate(2, date);
			smt.setDate(2, off);
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
	}

	@Override
	public WorkTime searchworktime(WorkTime workrecord, WorkTime workdate) {
		String sql = "SELECT * FROM worktime WHERE work_date = ?";
		WorkTime worktime = null;
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setDate(1, (Date) workdate.getdate());
			rs = smt.executeQuery();
			if (rs.next()) {
				int setstaffNum = (rs.getInt("staff_num"));
				Date setworkDate = (rs.getDate("work_date"));
				Date setonworkTime = (rs.getDate("onwork_time"));
				Date setoffworkTime = (rs.getDate("offwork_time"));
				worktime = new WorkTime(setstaffNum, setworkDate, setonworkTime, setoffworkTime);

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
		return worktime;

	}

}