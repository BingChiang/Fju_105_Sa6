package fju.im.sa6.dao.impl;

import fju.im.sa6.dao.WorktimeDAO;
import fju.im.sa6.entity.StaffDefault;
import fju.im.sa6.entity.WorkRecord;
import java.sql.*;
import java.util.ArrayList;
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
		StaffDefault staffnum = null;
		String sql = "SELECT * FROM StaffDefault WHERE staffNum = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, staffDefault.getStaffNum());
			rs = smt.executeQuery();
			if (rs.next()) {
				int setStaffNum = (rs.getInt("staff_Num"));
				String setstaffName = (rs.getString("staff_Name"));

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
		return 0;
	}

	public ArrayList<WorktimeDAO> getList() {
		return getList();
	}

	public void amendOnWork(WorkRecord workrecord) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO worktime (work_date, on_work) VALUES(select TO_CHAR(ADD_MONTHS(sysdate,-1),'mmdd') from worktime), Now())";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setDate(1, (java.sql.Date) workrecord.getDate());
			smt.setDate(2, (java.sql.Date) workrecord.getOnworkTime());
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

	public void amendOffWork(WorkRecord workrecord) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO worktime (work_date, off_work) VALUES(select TO_CHAR(ADD_MONTHS(sysdate,-1),'mmdd') from worktime), Now())";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);

			smt.setDate(1, (java.sql.Date) workrecord.getDate());
			smt.setDate(2, (java.sql.Date) workrecord.getOffworkTime());
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

	@Override
	public void statffOnWork(StaffDefault staffDefault) {
		// TODO Auto-generated method stub

	}

	@Override
	public void staffOffWork(StaffDefault staffDefault) {
		// TODO Auto-generated method stub

	}

	@Override
	public void amendOnWork(StaffDefault staffDefault, Date date) {
		// TODO Auto-generated method stub

	}

	@Override
	public void amendOffWork(StaffDefault staffDefault, Date date) {
		// TODO Auto-generated method stub

	}

}
