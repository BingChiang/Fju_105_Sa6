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
	private Connection conn2 = null;
	private ResultSet rs = null;
	private ResultSet rs2 = null;
	private PreparedStatement smt = null;
	private PreparedStatement smt2 = null;

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
			String sql = "UPDATE staff SET staff_lv=? WHERE staff_num =" + changeNum;
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
	public double monthearntotal(String date) {

		String indicatedate = "'" + date.substring(0, 7) + "-01'";
		System.out.println(indicatedate);

		// TODO Auto-generated method stub
		double sum = 0;
		String sql = "SELECT SUM(order_total) as sum_total FROM orderlist  where available = 0 AND month(order_date) = month("
				+ indicatedate + ")";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			// smt.setString(1, indicatedate);
			rs = smt.executeQuery();
			while (rs.next()) {

				int setmonthcounttotal = (rs.getInt("sum_total"));
				System.out.println(sum);
				sum += setmonthcounttotal;
			}
			System.out.println(sum);
			sum = sum - (inquireAllWorktimeforALL(indicatedate) * 150) - (producttotalcost(indicatedate));
			System.out.println("new:" + sum);

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

	public double inquireAllWorktimeforALL(String indicatedate) {
		double worktimeTotalALL = 0;
		String sql = "SELECT timestampdiff(hour,worktime.onwork_time,worktime.offwork_time)  as work_hour FROM worktime WHERE month(work_date) =month("
				+ indicatedate + ")";
		try {

			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			// smt.setString(1, indicatedate);
			rs = smt.executeQuery();
			while (rs.next()) {
				double setworktimetotal = (rs.getDouble("work_hour"));
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

	public double producttotalcost(String indicatedate) {
		double producttotalcost = 0;
		String sql = "Select SUM(product_cost) as cost_total " + "FROM orderitem  JOIN product,orderlist  "
				+ "where orderitem.product_num = product.product_num AND orderitem.orderlist_num =orderlist.orderlist_num "
				+ "AND month(order_date) =  month(" + indicatedate + ")";
		try {

			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			// smt.setString(1, indicatedate);
			rs = smt.executeQuery();
			while (rs.next()) {
				double setproducttotalcost = (rs.getDouble("cost_total"));
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

	@Override
	public ArrayList<StaffDefault> getWorkList(String date) {
		String indicatedate = "'" + date.substring(0, 7) + "-01'";
		ArrayList<StaffDefault> arr = new ArrayList<StaffDefault>();
		String sql = "SELECT * FROM staff";
		String sql2 = "SELECT SUM(timestampdiff(hour,worktime.onwork_time,worktime.offwork_time)) as worktotal FROM worktime Where month(work_date) =month("
				+ indicatedate + ") AND staff_num =?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while (rs.next()) {
				StaffDefault temp = new Staff(0, null, 0, null, 0);
				int staffNum = (rs.getInt("staff_num"));
				temp.setStaffNum(staffNum);
				temp.setStaffName(rs.getString("staff_name"));
				conn2 = dataSource.getConnection();
				smt2 = conn.prepareStatement(sql2);
				smt2.setInt(1, staffNum);
				rs2 = smt2.executeQuery();
				if (rs2.next()) {
					temp.setWorktimeTotal(rs2.getDouble("worktotal"));
				}
				arr.add(temp);
			}
			rs2.close();
			smt2.close();
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