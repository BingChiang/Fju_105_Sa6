package fju.im.sa6.dao.impl;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import javax.sql.DataSource;

import fju.im.sa6.entity.Cart;
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

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void add(Cart cart) {
		// TODO Auto-generated method stub

		String sql = "INSERT INTO orderlist (orderTotal, orderDate) VALUES(?, ?)";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);

			smt.setInt(1, cart.orderTotal());
			smt.setDate(2, );//set for system time
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
	public OrderList get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Product> getOrderDetail(OrderList orderList) {
		// TODO Auto-generated method stub
		return null;
	}



}
