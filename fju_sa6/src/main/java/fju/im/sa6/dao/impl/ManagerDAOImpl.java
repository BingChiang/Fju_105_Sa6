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
		System.out.println(staffDefault.getStaffLevel());

		String sql = "UPDATE staff SET staff_name=?, staff_lv=? WHERE staff_num=?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, staffDefault.getStaffName());
			smt.setInt(2, staffDefault.getStaffLevel());
			smt.setInt(3, staffDefault.getStaffNum());
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
		String sql = "DELETE FROM staff WHERE staff_num = ?";
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

	@Override
	/*--public double inquireAllWorktime(StaffDefault staffDefault) {
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
	} --*/

	public void setLevel(StaffDefault manager, StaffDefault staffDefault) {
		// TODO Auto-generated method stub
		int changeNum = staffDefault.getStaffNum();
		if (manager.getStaffNum() == staffDefault.getStaffNum()) {
			// no set because it will set itself
		} else {
			String sql = "UPDATE staff SET staff_lv=? WHERE staff_num ="+changeNum;
			try {
				conn = dataSource.getConnection();
				smt = conn.prepareStatement(sql);
				System.out.println(staffDefault.getStaffLevel());
				if (staffDefault.getStaffLevel() == 1) {
					smt.setInt(1, 0);
					System.out.println("YYY");
					smt.executeUpdate();

				} else {
					smt.setInt(1, 1);
					System.out.println("NNN");
					smt.executeUpdate();


				}
				System.out.println(staffDefault.getStaffLevel());
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
	}

	@Override
	public double monthearntotal(Date indicatedate) {
		// TODO Auto-generated method stub
		double sum = 0;
		String sql = "SELECT SUM(order_total) FROM orderlist WHERE (SELECT DATEPART(yyyymm,order_date) FROM orderlist WHERE order_date = ? )";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setDate(1, indicatedate);
			rs = smt.executeQuery();
			if (rs.next()) {
				double setmonthcounttotal = (rs.getDouble("order_total"));
				sum += setmonthcounttotal;
			}
			sum = sum - (inquireAllWorktimeforALL(indicatedate) * 150) - (producttotalcost(indicatedate));
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

	public double inquireAllWorktimeforALL(Date indicatedate) {
		double worktimeTotalALL = 0;
		String sql = "SELECT worktime_daytotal FROM worktime WHERE (SELECT DATEPART(yyyymm,order_date) FROM orderlist WHERE order_date = ? )";

		try {

			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setDate(1, indicatedate);
			rs = smt.executeQuery();
			if (rs.next()) {
				double setworktimetotal = (rs.getDouble("worktime_daytotal"));
				worktimeTotalALL += setworktimetotal;

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

	public double producttotalcost(Date indicatedate) {
		double producttotalcost = 0;
		String sql = "SELECT product_cost FROM product WHERE (SELECT product_num FROM orderitem WHERE(SELECT orderlist_num FROM orderlist WHERE order_date = ?)))";
		try {

			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setDate(1, indicatedate);
			rs = smt.executeQuery();
			if (rs.next()) {
				double setproducttotalcost = (rs.getDouble("product_cost"));
				producttotalcost += setproducttotalcost;

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

		return producttotalcost;

	}

	@Override
	public double inquireAllWorktime(StaffDefault staffDefault) {
		
		return 0;
	}

}