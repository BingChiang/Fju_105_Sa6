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

		String sql = "INSERT INTO orderlist (orderTotal, orderDate) VALUES(?, NOW())";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			
			smt.setInt(1, getordertotal(orderlist));
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
		
		String sql1 = "INSERT INTO orderitem (product_num, orderlist_num, product_name, product_price) VALUES(?, ?, ?, ?)";
		try {
			conn = dataSource.getConnection();
			smt2 = conn.prepareStatement(sql1);
			rs2 = smt.executeQuery();
			smt.setInt(1, orderitem.getProductNum());
			smt.setInt(2, orderitem.getOrderlistNum());
			smt.setString(3, orderitem.getProductName());
			smt.setInt(4, orderitem.getProductPrice());
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
	
	public void addorderitem(Orderitem orderitem) {
		// TODO Auto-generated method stub

		String sql = "INSERT INTO orderitem (product_num, orderlist_num, product_name, product_price) VALUES(?, ?, ?, ?)";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);

			smt.setInt(1, orderitem.getProductNum());
			smt.setInt(2, orderitem.getOrderlistNum());
			smt.setString(3, orderitem.getProductName());
			smt.setInt(4, orderitem.getProductPrice());
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
	public OrderList getorderlist(OrderList orderlist) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM orderlist WHERE orderlist_num = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, orderlist.getOrderlistNum());
			rs = smt.executeQuery();
			if (rs.next()) {
				int setorderlistNum = (rs.getInt("orderlist_num"));
				Date setorderdate = (rs.getDate("order_date"));
				int setordertotal = (rs.getInt("order_total"));
				orderlist = new OrderList(setorderlistNum, setordertotal, setorderdate);
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
	public ArrayList<Orderitem> getorderitem(Orderitem orderitem) {
		// TODO Auto-generated method stub
		
		ArrayList<Orderitem> detail = new ArrayList<Orderitem>();
		String sql = "SELECT * FROM orderitem WHERE orderlist_num=?";
		try {

			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, orderitem.getOrderlistNum());
			rs = smt.executeQuery();
			if (rs.next()) {
				int productnum = (rs.getInt("product_num"));
				String productname = (rs.getString("product_name"));
				int productprice = (rs.getInt("prodcut_price"));
				int orderlistnum = (rs.getInt("oderlist_num"));

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

	
	
	@Override
	public ArrayList<OrderList> getList() {
		// TODO Auto-generated method stub
		ArrayList<OrderList> orderlist = new ArrayList<OrderList>();
		String sql = "SELECT * FROM orderlist";
		try {

			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			if (rs.next()) {
				int orderlistnum = (rs.getInt("orderlist_num"));
				Date orderdate = (rs.getDate("order_date"));
				int ordertotal = (rs.getInt("order_total"));
				orderlist.add(new OrderList(orderlistnum, ordertotal,orderdate));
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
	
	
	public int getordertotal(OrderList orderlist){
		int ordertotal=0;
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
	
	public double gettotalcost(Date date){
		double totalcost=0;
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
				//ordercost.add(new Orderitem(setproductNum, setorderlistNum, null, 0));
				
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
	public void add(Cart shoppingCart) {
		// TODO Auto-generated method stub
		
		
	}

}