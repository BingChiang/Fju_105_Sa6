package fju.im.sa6.dao.impl;

import fju.im.sa6.entity.ProductList;
import fju.im.sa6.dao.ProductListDAO;

import java.sql.*;

import javax.sql.DataSource;

//rebuild by bing 2016.11.30
public class ProductListDAOImpl implements ProductListDAO {
	private DataSource dataSource;
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement smt = null;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void set(ProductList productList) {
		// TODO Auto-generated method stub
		String sql = "UPDATE productlist(product_num, product_amount)";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, productList.getProductNum());
			smt.setInt(2, productList.getAmount());
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
	public void remove(ProductList productList) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM product WHERE product_num = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, productList.getProductNum());
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

	public ProductList get(ProductList productList) {
		// TODO Auto-generated method stub
		ProductList productlist = null;
		String sql = "SELECT * FROM productlist WHERE product_num = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, productList.getProductNum());
			rs = smt.executeQuery();
			if (rs.next()) {
				int setProduct = (rs.getInt("product_num"));
				int setAmount = (rs.getInt("product_amount"));
				productlist = new ProductList(setProduct, setAmount);
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
		return productlist;
	}

	@Override
	public ProductList getSingleTotal(ProductList productList) {
		// TODO Auto-generated method stub
		ProductList productlist = null;
		String sql = "SELECT * FROM productlist WHERE product_num = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, productList.getProductNum());
			rs = smt.executeQuery();
			if (rs.next()) {
				int setProduct = (rs.getInt("product_num"));
				int setAmount = (rs.getInt("product_amount"));
				productlist = new ProductList(setProduct, setAmount);
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
		return productlist;
	}

}
