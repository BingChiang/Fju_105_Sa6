package fju.im.sa6.dao.impl;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import javax.sql.DataSource;
import fju.im.sa6.entity.Cart;
import fju.im.sa6.entity.Orderitem;
import fju.im.sa6.entity.OrderList;
import fju.im.sa6.entity.Product;
import fju.im.sa6.dao.OrderListDAO;
import fju.im.sa6.entity.Cart;

import java.sql.*;

//rebuild by bing 2016.11.30
public class OrderListDAOImpl implements OrderListDAO {

	private DataSource dataSource;
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement smt = null;
	private ResultSet rs2 = null;
	private PreparedStatement smt2 = null;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void addorderlist(OrderList orderlist) {
		// TODO Auto-generated method stub

		String sql = "INSERT INTO orderlist (order_total, order_date) VALUES(?, NOW())";
		try {

			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);

			smt.setInt(1, orderlist.getOrderTotal());
			smt.executeUpdate();
			smt.close();

			System.out.println("insert new");
			sql = "SELECT LAST_INSERT_ID( ) as order_num FROM orderlist ";
			int orderNum = 0;
			// conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			if (rs.next()) {
				orderNum = rs.getInt("order_num");
			}
			sql = "INSERT INTO orderitem (orderlist_num, product_num,product_name,product_price) VALUES(?, ?,?,?)";
			smt = conn.prepareStatement(sql);
			for (int i = 0; i < orderlist.getOrderList().size(); i++) {

				smt.setInt(1, orderNum);
				smt.setInt(2, orderlist.getOrderList().get(i).getProductNum());
				smt.setString(3, orderlist.getOrderList().get(i).getProductName());
				smt.setInt(4, orderlist.getOrderList().get(i).getProductPrice());
				smt.executeUpdate();
			}
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

	public ArrayList<OrderList> getorderlist() {
		// TODO Auto-generated method stub
		ArrayList<OrderList> arr = new ArrayList<OrderList>();
		String sql = "SELECT * FROM orderlist ";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while (rs.next()) {
				int setorderlistNum = (rs.getInt("orderlist_num"));
				Date setorderdate = (rs.getDate("order_date"));
				int setordertotal = (rs.getInt("order_total"));
				OrderList temp = new OrderList(setorderlistNum, setordertotal, setorderdate, null);
				temp.setAvailable(rs.getInt("available"));
				arr.add(temp);
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
		return arr;
	}

	public ArrayList<OrderList> getTodayorderlist() {
		// TODO Auto-generated method stub
		ArrayList<OrderList> arr = new ArrayList<OrderList>();
		String sql = "SELECT * FROM orderlist where order_date = CURRENT_DATE AND available = 0";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while (rs.next()) {
				int setorderlistNum = (rs.getInt("orderlist_num"));
				Date setorderdate = (rs.getDate("order_date"));
				int setordertotal = (rs.getInt("order_total"));
				arr.add(new OrderList(setorderlistNum, setordertotal, setorderdate, null));
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
		return arr;
	}
	
	@Override
	public ArrayList<Orderitem> getorderitem(OrderList orderList) {
		// TODO Auto-generated method stub

		ArrayList<Orderitem> detail = new ArrayList<Orderitem>();
		String sql = "SELECT * FROM orderitem WHERE orderlist_num=?";
		try {

			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, orderList.getOrderlistNum());
			rs = smt.executeQuery();
			while (rs.next()) {
				int productnum = (rs.getInt("product_num"));
				String productname = (rs.getString("product_name"));
				int productprice = (rs.getInt("product_price"));
				int orderlistnum = (rs.getInt("orderlist_num"));

				detail.add(new Orderitem(productnum, orderlistnum, productname, productprice));

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
		return detail;
	}

	public int getordertotal(OrderList orderlist) {
		int ordertotal = 0;
		String sql = "SELECT product_price FROM orderitem WHERE orderlist_num=?";
		try {

			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, orderlist.getOrderlistNum());
			rs = smt.executeQuery();
			if (rs.next()) {
				int productprice = (rs.getInt("product_price"));
				ordertotal += productprice;
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

		return ordertotal;
	}

	public double gettotalcost(Date date) {
		double totalcost = 0;
		ArrayList<Orderitem> ordercost = new ArrayList<Orderitem>();
		String sql = "SELECT orderlist_num FROM orderlist WHERE order_date=?";
		try {
			String sql1 = "SELECT product_num FROM orderitem WHERE orderlist_num=?";
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setDate(1, date);
			rs = smt.executeQuery();
			if (rs.next()) {
				smt2 = conn.prepareStatement(sql1);
				smt.setInt(1, rs.getInt("orderlist_num"));
				int setorderlistNum = (rs.getInt("orderlist_num"));
				int setproductNum = (rs2.getInt("product_num"));
				// ordercost.add(new Orderitem(setproductNum, setorderlistNum,
				// null, 0));
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
		return totalcost;
	}

	@Override
	public OrderList get(OrderList orderList) {

		OrderList temp  = new OrderList(0, 0, null, null);
		String sql = "SELECT * FROM orderlist WHERE orderlist_num = "+orderList.getOrderlistNum();
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while (rs.next()) {
				temp.setOrderlistNum(rs.getInt("orderlist_num"));
				temp.setOrderDate(rs.getDate("order_date"));
				temp.setOrderTotal(rs.getInt("order_total"));
				temp.setAvailable(rs.getInt("available"));
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
		return temp;
	}

	@Override
	public void orderRemove(OrderList orderlist) {
		String sql = "UPDATE orderlist SET available = 1 WHERE orderlist_num = "+orderlist.getOrderlistNum();
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.executeUpdate();
			
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