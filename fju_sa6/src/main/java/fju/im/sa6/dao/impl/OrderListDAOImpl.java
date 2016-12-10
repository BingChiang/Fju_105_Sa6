package fju.im.sa6.dao.impl;

import java.util.ArrayList;
import javax.sql.DataSource;
import fju.im.sa6.entity.OrderList;
import fju.im.sa6.entity.ProductList;
import fju.im.sa6.dao.OrderListDAO;

import java.sql.*;

//rebuild by bing 2016.11.30
public class OrderListDAOImpl implements OrderListDAO {

	private DataSource dataSource;
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement smt = null;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void add(OrderList orderList) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO orderlist (order_total, order_date) VALUES(?, NOW())";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);


			smt.setInt(1, orderList.);
			smt.setDate(2, orderList.getOrderDate());
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
	public void set(OrderList setODP) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO orderlist (order_price, order_amount, order_total, order_date) VALUES(?, ?, ?, ?)";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);

			smt.setInt(1, setODP.getOrderPrice());
			smt.setInt(2, setODP.getOrderAmount());
			smt.setInt(3, setODP.getOrderTotal());
			smt.setDate(4, setODP.getOrderDate());
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
	public void remove(OrderList removeODP) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM orderlist WHERE orderlist_num = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, removeODP.getOrderNum());
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

	public ArrayList<ProductList> getOrderList(OrderList orderlist) {
		// TODO Auto-generated method stub
		Date searchDate = null;
		String sql = "SELECT * FROM orderlist WHERE order_date = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setDate(1, searchDate);
			rs = smt.executeQuery();
			if (rs.next()) {

				int setOrder_Num = (rs.getInt("order_num"));
				int setProduct_Num = (rs.getInt("product_num"));
				int setType_Num = (rs.getInt("type_num"));
				int setorder_price = (rs.getInt("order_price"));
				int setorder_amount = (rs.getInt("order_amount"));
				int setorder_total = (rs.getInt("order_total"));
				Date setorder_date = (rs.getDate("order_date"));
				orderlist = new OrderList(setOrder_Num, setProduct_Num, setType_Num, setorder_price, setorder_amount,
						setorder_total, setorder_date);
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

		return getOrderList(orderlist);

	}

	@Override
	public OrderList gettotalprice(OrderList order_date, OrderList order) {
		// TODO Auto-generated method stub
		String sql = "SELECT SUM(order_price) FROM orderlist WHERE order_date = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setDate(1, order_date.getOrderDate());
			rs = smt.executeQuery();
			if (rs.next()) {
				int setorder_Total = (rs.getInt("SUM(order_price)"));
				order.setOrderTotal(setorder_Total);

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
		return order;

	}

}
