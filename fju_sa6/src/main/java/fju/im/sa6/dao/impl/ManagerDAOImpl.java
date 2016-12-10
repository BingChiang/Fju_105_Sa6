package fju.im.sa6.dao.impl;

import fju.im.sa6.entity.Manager;
import fju.im.sa6.entity.Staff;
import fju.im.sa6.entity.StaffDefault;
import fju.im.sa6.dao.ManagerDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

//rebuild by bing 2016.11.30
public class ManagerDAOImpl extends StaffDefaultDAOImpl implements ManagerDAO {
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
		String sql = "INSERT INTO staff (staff_name, staff_lv)VALUE(?, ?)";
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

	@Override
	public void set(StaffDefault staffDefault) {
		// TODO Auto-generated method stub
		String sql = "UPDATE staff (staff_name,staff_lv) VALUES(?, ?)";
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
		String sql = "DELETE FROM staff WHERE staff_name = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, staffDefault.getStaffName());
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
	public double inquireAllWorktime() {
		StaffDefault staffDefault = new Manager();
		double worktimeTotal = 0;
		String sql = "SELECT worktime_daytotal FROM worktime WHERE staff_num = ?";

		try {

			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, staffDefault.getStaffNum());
			rs = smt.executeQuery();
			if (rs.next()) {
				double setworktimetotal = (rs.getDouble("worktime_daytotal"));
				worktimeTotal = setworktimetotal;

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
		return worktimeTotal;
	}

	public void setLevel(StaffDefault manager, StaffDefault staffDefault) {
		// TODO Auto-generated method stub

		if (manager.getStaffNum() == staffDefault.getStaffNum()) {
			// no set because it will set itself
		} else {
			String sql = "UPDATE staff (staff_num, staff_lv) VALUES(?, ?)";
			try {
				conn = dataSource.getConnection();
				smt = conn.prepareStatement(sql);
				if (staffDefault.getStaffLevel() == 0) {
					smt.setInt(1, staffDefault.getStaffLevel());
				} else {
					conn.rollback();
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
	public double monthearntotal() {
		// TODO Auto-generated method stub
		Date indicatedate = null;
		double sum = 0;
		String sql = "SELECT SUM(order_total) FROM orderlist WHERE (SELECT DATEPART(mm,order_date) FROM orderlist WHERE order_date = ? )";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setDate(1, indicatedate);
			rs = smt.executeQuery();
			if (rs.next()) {
				double setmonthcounttotal = (rs.getDouble("order_total"));
				sum += setmonthcounttotal;
			}
			sum = sum - (inquireAllWorktimeforALL() * 150);// -Product_cost
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

		return sum;
	}

	public double inquireAllWorktimeforALL() {
		double worktimeTotalALL = 0;
		String sql = "SELECT SUM(worktime_daytotal) FROM worktime WHERE (SELECT DATEPART(mm,order_date) FROM orderlist WHERE order_date = ? )";

		try {

			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			if (rs.next()) {
				double setworktimetotal = (rs.getDouble("worktime_daytotal"));
				worktimeTotalALL = setworktimetotal;

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
		return worktimeTotalALL;
	}
}