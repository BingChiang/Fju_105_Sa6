package fju.im.sa6.dao.impl;

import fju.im.sa6.entity.Manager;
import fju.im.sa6.entity.StaffDefault;
import fju.im.sa6.dao.ManagerDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;


//rebuild by bing 2016.11.30
public class ManagerDAOImpl implements ManagerDAO {
	private DataSource dataSource;
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement smt = null;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void add(StaffDefault staffDefault) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO manager (staff_name, staff_lv)VALUE(?, ?)";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);

			smt.setString(1, staffDefault.getStaffName());
			smt.setInt(1, staffDefault.getStaffLevel());
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
	public void set(StaffDefault staffDefault) {
		// TODO Auto-generated method stub
		String sql = "UPDATE manager (staff_name,staff_Lv) VALUES(?, ?)";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, staffDefault.getStaffName());
			smt.setInt(2, staffDefault.getStaffLevel());
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

	public void remove(StaffDefault staffDefault) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM manager WHERE staff_num = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, staffDefault.getStaffNum());
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

	public double inquireAllWorktime(StaffDefault staffDefault) {
		
		return 0;

	}

	public void setLevel(StaffDefault manager, StaffDefault staffDefault) {
		// TODO Auto-generated method stub

		if (manager.getStaffNum() == staffDefault.getStaffNum()) {
			// no set because it will set itself
		} else {
			String sql = "UPDATE manager (staff_num, staff_lv) VALUES(?, ?)";
			try {
				conn = dataSource.getConnection();
				smt = conn.prepareStatement(sql);
				if (staffDefault.getStaffLevel() == 0) {
					smt.setInt(1, staffDefault.getStaffLevel());
				} else {
					smt.setInt(0, staffDefault.getStaffLevel());
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
	}
}