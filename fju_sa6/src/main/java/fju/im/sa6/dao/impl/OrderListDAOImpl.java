package fju.im.sa6.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import fju.im.sa6.entity.Cart;
import fju.im.sa6.entity.Inventory;
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
			smt.setLong(2, System.currentTimeMillis());// set for system time
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
		OrderList orderlist = new OrderList();
		String sql = "SELECT * FROM orderlist WHERE orderlist_num = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, orderlist.getOrderistNum());
			rs = smt.executeQuery();
			if (rs.next()) {
				int setorderlistNum = (rs.getInt("orderlsit_num"));
				Date setorderdate = (rs.getDate("order_date"));
				int setordertotal = (rs.getInt("order_total"));
				orderlist = new OrderList(setorderlistNum, setordertotal, (java.sql.Date) setorderdate,
						getOrderDetail());
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
		return orderlist;
	}

	@Override
	public ArrayList<Product> getOrderDetail() {
		// TODO Auto-generated method stub
		ArrayList<Product> detail = new ArrayList<Product>();
		String sql = "SELECT product_name,product_price,  FROM product ";
		try {

			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			if (rs.next()) {
				int productnum = (rs.getInt("product_num"));
				int typenum = (rs.getInt("type_num"));
				String productname = (rs.getString("product_name"));
				int productprice = (rs.getInt("prodcut_price"));

				detail.add(new Product(productnum, typenum, productname, productprice, 0, 0));

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

	@Override
	public ArrayList<OrderList> getList() {
		// TODO Auto-generated method stub
		ArrayList<OrderList> orderlist = new ArrayList<OrderList>();
		String sql = "SELECT * FROM orderlist";
		OrderList temp;
		try {

			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			if (rs.next()) {
				int orderlistnum = (rs.getInt("orderlist_num"));
				Date orderdate = (rs.getDate("order_date"));
				int ordertotal = (rs.getInt("order_total"));
				temp = new OrderList(orderlistnum, ordertotal, (java.sql.Date) orderdate, getOrderDetail());
				orderlist.add(temp);
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

		return orderlist;
	}

}
