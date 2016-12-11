package fju.im.sa6.dao.impl;

import fju.im.sa6.entity.Staff;
import fju.im.sa6.entity.StaffDefault;
import fju.im.sa6.dao.StaffDefaultDAO;
import java.sql.Connection;
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
	
	public StaffDefault get(StaffDefault staffDefault) {
		// TODO Auto-generated method stub

		String sql = "Select * FROM staff WHERE staff_num = ?";
		StaffDefault StaffDefault2 = null ;
		try {

			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, staffDefault.getStaffNum());
			rs = smt.executeQuery();
			if (rs.next()) {
				int setStaffNum = (rs.getInt("staff_num"));
				String setStaffName = (rs.getString("staff_name"));
				int setStaffLv = (rs.getInt("staff_lv"));

				StaffDefault2 = new Staff(setStaffNum,setStaffName,setStaffLv,0);
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
		return StaffDefault2;
	}

	public ArrayList<StaffDefault> getList() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM staff ";
		ArrayList<StaffDefault> arr = new ArrayList<StaffDefault>();
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			if (rs.next()) {
				int setstaffnum = (rs.getInt("staff_num"));
				int setstafflv = (rs.getInt("staff_lv"));
				String setstaffname = (rs.getString("staff_name"));
				arr.add(new Staff(setstaffnum,setstaffname,setstafflv,0));
				

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
}
