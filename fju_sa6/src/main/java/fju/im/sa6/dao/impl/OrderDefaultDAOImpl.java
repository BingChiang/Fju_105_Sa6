package fju.im.sa6.dao.impl;

import fju.im.sa6.entity.OrderDefault;
import fju.im.sa6.dao.OrderDefaultDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

//rebuild by bing 2016.11.30
public class OrderDefaultDAOImpl implements OrderDefaultDAO {
	private DataSource dataSource;
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement smt = null;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void add(OrderDefault addOrder) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO orderitem(order_price, order_amount,product_name)VALUES(?, ?,?)";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, addOrder.getProductPrice());
			smt.setInt(2, addOrder.getOrderAmount());
			smt.setString(3, addOrder.getProductName());
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
	public void set(OrderDefault setOrder) {
		// TODO Auto-generated method stub
		String sql = "UPDATE INTO orderitem(order_price, order_amount, product_name)VALUES(?, ?)";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, setOrder.getProductPrice());
			smt.setInt(2, setOrder.getOrderAmount());
			smt.setString(3, setOrder.getProductName());
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

	public void remove(OrderDefault removeOrder) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM orderitem WHERE orderlist_num = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1,removeOrder.getOrderlistNum());
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

	public OrderDefault get(OrderDefault orderDefault) {
		OrderDefault order = null;
		String sql = "SELECT * FROM orderitem WHERE orderlist_num = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, orderDefault.getOrderlistNum());
			rs = smt.executeQuery();
			if (rs.next()) {
				int setOrder = (rs.getInt("orderlist_num"));
				int setProduct = (rs.getInt("product_num"));
				int setType_Num = (rs.getInt("type_num"));
				int setOrder_Price = (rs.getInt("order_price"));
				int setOrder_Amount = (rs.getInt("order_amount"));
				String setProduct_Name = (rs.getString("product_name"));
				order = new OrderDefault(setOrder, setProduct, setType_Num, setOrder_Price, setOrder_Amount,
						setProduct_Name);
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
