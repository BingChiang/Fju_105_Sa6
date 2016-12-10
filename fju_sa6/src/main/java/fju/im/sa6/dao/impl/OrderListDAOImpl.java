package fju.im.sa6.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;
import fju.im.sa6.entity.OrderList;
import fju.im.sa6.entity.Product;
import fju.im.sa6.dao.OrderListDAO;
import fju.im.sa6.entity.cart;

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
		
		
		String sql = "INSERT INTO orderlist (orderTotal, orderDate) VALUES(?, ?)";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			
			smt.setInt(1, orderList.orderTotal());
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
	public void remove(OrderList removeOrderlist) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM orderlist WHERE orderlist_num = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, removeOrderlist.getOrderistNum());
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
	public OrderList getordertotal(OrderList orderList, OrderList order) {
		// TODO Auto-generated method stub
		String sql = "SELECT order_total FROM OrderList WHERE orderlist_Num = ?";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, orderList.getOrderistNum());
			rs = smt.executeQuery();
			if (rs.next()) {
				int setorder_Total = (rs.getInt("order_Price"));
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
