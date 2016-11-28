package fju.im.sa6.webapp.dao.impl;

import fju.im.sa6.entity.StaffDefault;
import fju.im.sa6.webapp.dao.StaffDefaultDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class StaffDefaultDAOImpl implements StaffDefaultDAO {
	private DataSource dataSource;
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement smt = null;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public StaffDefault get(int searchNum) {
		// TODO Auto-generated method stub
		StaffDefault staffD = null;
		String sql = "Select * FROM staff WHERE staff_num = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, searchNum);
			rs = smt.executeQuery();
			if (rs.next()) {
				int setStaffDefault = (rs.getInt("staff_num"));
				String setStaff_Name = (rs.getString("staff_name"));
				int setStaff_Lv = (rs.getInt("staff_lv"));
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
		return staffD;
	}
}
