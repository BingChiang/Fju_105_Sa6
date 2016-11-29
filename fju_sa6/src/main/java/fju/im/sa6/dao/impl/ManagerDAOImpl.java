package fju.im.sa6.dao.impl;

import fju.im.sa6.entity.Manager;
import fju.im.sa6.entity.StaffDefault;
import fju.im.sa6.dao.ManagerDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class ManagerDAOImpl extends StaffDefaultDAOImpl implements ManagerDAO {
	private DataSource dataSource;
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement smt = null;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void addStaff(StaffDefault newStaff) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO manager (staff_name, staff_lv)VALUE(?, ?)";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);

			smt.setString(1, newStaff.getStaffName());
			smt.setInt(1, newStaff.getStaffLevel());
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

	public void setStaff(StaffDefault setstaff) {
		// TODO Auto-generated method stub
		String sql = "UPDATE manager (staff_name,staff_Lv) VALUES(?, ?)";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, setstaff.getStaffName());
			smt.setInt(2, setstaff.getStaffLevel());
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

	public void removeStaff(StaffDefault removeStaff) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM manager WHERE staff_num = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, removeStaff.getStaffNum());
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

	public void inquireAllWorktime(Manager inquireAWKT) {
		// TODO Auto-generated method stub

	}

	public void setLevel(Manager manager, StaffDefault staff) {
		// TODO Auto-generated method stub

		if (manager.getStaffNum() == staff.getStaffNum()) {
			// no set because it will set itself
		} else {
			String sql = "UPDATE manager (staff_num, staff_lv) VALUES(?, ?)";
			try {
				conn = dataSource.getConnection();
				smt = conn.prepareStatement(sql);
				if (staff.getStaffLevel() == 0) {
					smt.setInt(1, staff.getStaffLevel());
				} else {
					smt.setInt(0, staff.getStaffLevel());
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

	@Override
	public void inquireAllWorktime(StaffDefault inquireAWKT) {
		// TODO Auto-generated method stub
		
	}




}
