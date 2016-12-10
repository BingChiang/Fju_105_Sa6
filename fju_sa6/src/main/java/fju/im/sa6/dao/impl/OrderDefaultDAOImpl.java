package fju.im.sa6.dao.impl;

import fju.im.sa6.entity.OrderDefault;
import fju.im.sa6.entity.Product;
import fju.im.sa6.dao.OrderDefaultDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fju.im.sa6.entity.cart;

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
		String sql = "INSERT INTO orderdefault(product_num, orderlist_num)VALUES(?, ?)";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, addOrder.getProductNum());
			smt.setInt(2, addOrder.getOrderlistNum());
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

	public void remove(OrderDefault removeorderdefault) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM orderitem WHERE orderlist_num = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, removeorderdefault.getOrderlistNum());
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
		String sql = "SELECT product_name, product_price FROM product WHERE product_num = ?";
		OrderDefault order = null;
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, orderDefault.getProductNum());
			rs = smt.executeQuery();
			if (rs.next()) {
				int setOrder = (rs.getInt("order_Num"));
				int setProduct = (rs.getInt("product_Num"));
				int setType_Num = (rs.getInt("type_Num"));
				int setOrder_Price = (rs.getInt("order_Price"));
				int setOrder_Amount = (rs.getInt("order_Amount"));
				int setOrder_Total = (rs.getInt("order_Total"));
				Date setOrder_Date = (rs.getDate("order_Date"));
				order = new OrderDefault();
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

	public List<Product> addcart(Product product) {
		List<Product> productlist = new ArrayList<Product>();
		String sql = "INSERT INTO orderitem(product_num, product_name, product_price) VALUES(?, ?, ?)";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);

			smt.setInt(1, product.getProductNum());
			smt.setInt(2, product.get);
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

		return productlist;
	}

}
