package fju.im.sa6.webapp.dao.impl;

import java.util.ArrayList;

import javax.sql.DataSource;

import fju.im.sa6.entity.OrderList;
import fju.im.sa6.entity.Product;
import fju.im.sa6.webapp.dao.OrderListDAO;
import fju.im.sa6.webapp.dao.ProductDAO;

import java.sql.*;

public class OrderListDAOImpl implements OrderListDAO {

	private DataSource dataSource;
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement smt = null;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void add(OrderList addODP) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO orderlist (order_price, order_amount, order_total, order_date) VALUES(?, ?, ?, ?)";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);

			smt.setInt(1, addODP.getOrderPrice());
			smt.setInt(2, addODP.getOrderAmount());
			smt.setInt(3, addODP.getOrderTotal());
			smt.setDate(4, addODP.getOrderDate());
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

	@Override
	public ArrayList<OrderList> getList() {
		// TODO Auto-generated method stub
		return null;

	}

	@Override
	public Product getODP(int searchNum) {
		// TODO Auto-generated method stub
		Product prod = null;
		String sql = "SELECT * FROM product WHERE product_num = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, searchNum);
			rs = smt.executeQuery();
			if (rs.next()) {
				int setOrder_Num = (rs.getInt("order_num"));
				int setProduct_Num = (rs.getInt("product_num"));
				int setType_Num = (rs.getInt("type_Num"));
				int setorder_price = (rs.getInt("order_price"));
				int setorder_amount = (rs.getInt("order_amount"));
				int setorder_total = (rs.getInt("order_total"));
				Date setorderdate = (rs.getDate("order_date"));
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
		return prod;
	}

	@Override
	public Product gettotalprice(OrderList gettotalprice) {
		// TODO Auto-generated method stub
		return null;
	}

}
