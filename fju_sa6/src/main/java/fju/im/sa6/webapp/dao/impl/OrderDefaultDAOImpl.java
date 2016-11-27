package fju.im.sa6.webapp.dao.impl;

import fju.im.sa6.entity.OrderDefault;
import fju.im.sa6.webapp.dao.OrderDefaultDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class OrderDefaultDAOImpl implements OrderDefaultDAO {
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	@Override
	public void add(OrderDefault addOrder) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO orderdefault(order_price, order_amount, order_total, order_date)VALUES(?, ?, ?, ?)";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);

			smt.setInt(1,addOrder.getOrderPrice());
			smt.setInt(2,addOrder.getOrderAmount());
			smt.setInt(3,addOrder.getOrderTotal());
			smt.setDate(4,(Date) addOrder.getOrderDate());
			smt.executeUpdate();			
			smt.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}

	@Override
	public void set(OrderDefault setOrder) {
		// TODO Auto-generated method stub
		String sql = "UPDATE INTO orderdefault(order_price, order_amount, order_total, order_date)VALUES(?, ?, ?, ?)";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1,setOrder.getOrderPrice());
			smt.setInt(2,setOrder.getOrderAmount());
			smt.setInt(3,setOrder.getOrderTotal());
			smt.setDate(4,(Date) setOrder.getOrderDate());
			smt.executeUpdate();			
			smt.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}

	@Override
	public void remove(OrderDefault removeOrder) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM orderdefault WHERE order_num = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1,removeOrder.getOrderNum());
			smt.executeUpdate();			
			smt.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}

	
	public OrderDefault get(int searchNum) {
		OrderDefault order = null;
		String sql = "SELECT * FROM orderdefault WHERE order_num = ?";
				try {
					conn = dataSource.getConnection();
					smt = conn.prepareStatement(sql);
					smt.setInt(1, searchNum);
					rs = smt.executeQuery();
					if(rs.next()){
						int setOrder=(rs.getInt("order_Num"));
						int setProduct=(rs.getInt("product_Num"));
						int setType_Num=(rs.getInt("type_Num"));
						int setOrder_Price=(rs.getInt("order_Price"));
						int setOrder_Amount=(rs.getInt("order_Amount"));
						int setOrder_Total=(rs.getInt("order_Total"));
					    int setOrder_Date=(rs.getInt("order_Date"));
					}
					rs.close();
					smt.close();
		 
				} catch (SQLException e) {
					throw new RuntimeException(e);
		 
				} finally {
					if (conn != null) {
						try {
							conn.close();
						} catch (SQLException e) {}
					}
				}
				return order;
			}

}
