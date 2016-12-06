package fju.im.sa6.dao.impl;

import fju.im.sa6.entity.StaffDefault;
import fju.im.sa6.dao.StaffDefaultDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

//rebuild by bing 2016.11.30
public class StaffDefaultDAOImpl implements StaffDefaultDAO {
	private DataSource dataSource;
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement smt = null;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public StaffDefault get(StaffDefault staffDefault) {
		// TODO Auto-generated method stub
		
		StaffDefault staff = null;
		String sql = "Select * FROM staff WHERE staff_num = ?";
		try {

			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, staffDefault.getStaffNum());
			rs = smt.executeQuery();
			if (rs.next()) {
				int setStaffNum = (rs.getInt("staff_Num"));
				String setStaffName = (rs.getString("staff_Name"));
				int setStaffLv = (rs.getInt("staff_Lv"));
				Date setworkmonth = (rs.getDate("workMonth"));
				double setworktimeTotal = (rs.getDouble("worktimeTotal"));
				staff.setStaffNum(setStaffNum);
				staff.setStaffName(setStaffName);
				staff.setStaffLevel(setStaffLv);
				staff.setWorkMonth(setworkmonth);
				staff.setWorktimeTotal(setworktimeTotal);

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
		return staff;
	}

	@Override
	public ArrayList<StaffDefault> getList() {
		// TODO Auto-generated method stub
		return null;
	}

}
