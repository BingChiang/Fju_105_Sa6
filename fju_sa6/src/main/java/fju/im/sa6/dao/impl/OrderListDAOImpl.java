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
	private PreparedStatement smt1 = null;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void addorderlist(OrderList orderlist) {
		// TODO Auto-generated method stub

		String sql = "INSERT INTO orderlist (order_total, order_date) VALUES(?, NOW())";
		try {

			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);

			smt.setInt(1, getordertotal(orderlist));
			smt.executeUpdate();
			smt.close();

			sql = "SELECT LAST_INSERT_ID( )";
			int orderNum = 0;
			// conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()) {

				orderNum = rs.getInt("order_num");
			}
			sql = "INSERT INTO orderitem (orderlist_num, product_num,product_name,product_price) VALUES(?, ?,?,?)";
			for (int i = 0; i < orderlist.getOrderList().size(); i++) {
				smt2 = conn.prepareStatement(sql);
				smt2.setInt(1, orderNum);
				smt2.setInt(2, orderlist.getOrderList().get(i).getProductNum());
				smt2.setString(3, orderlist.getOrderList().get(i).getProductName());
				smt2.setInt(4, orderlist.getOrderList().get(i).getProductPrice());
				smt2.executeUpdate();

			}

			rs.close();
			smt2.close();
			smt1.close();
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
			while(rs.next()) {
				int setorderlistNum = (rs.getInt("orderlist_num"));
				Date setorderdate = (rs.getDate("order_date"));
				int setordertotal = (rs.getInt("order_total"));
				arr.add(new OrderList(setorderlistNum, setordertotal, setorderdate, null));
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

	@Override
	public ArrayList<Orderitem> getorderitem(OrderList orderList) {
		// TODO Auto-generated method stub
		ArrayList<Orderitem> detail = new ArrayList<Orderitem>();
		int orderlistNum=orderList.getOrderlistNum();
		String sql = "SELECT * FROM orderitem WHERE orderlist_num="+orderlistNum;
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()) {
				int productnum = (rs.getInt("product_num"));
				String productname = (rs.getString("product_name"));
				int productprice = (rs.getInt("product_price"));
				int orderlistnum = (rs.getInt("orderlist_num"));
				detail.add(new Orderitem(productnum, orderlistnum, productname, productprice));

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
			while(rs.next()) {
				int productprice = (rs.getInt("product_price"));
				ordertotal += productprice;
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
			while (rs.next()) {
				smt2 = conn.prepareStatement(sql1);
				smt.setInt(1, rs.getInt("orderlist_num"));
				int setorderlistNum = (rs.getInt("orderlist_num"));
				int setproductNum = (rs2.getInt("product_num"));
//				 ordercost.add(new Orderitem(setproductNum, setorderlistNum,
//				 null, 0));

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

		return totalcost;
	}

}