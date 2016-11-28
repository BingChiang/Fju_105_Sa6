package fju.im.sa6.webapp.dao.impl;

import fju.im.sa6.entity.Product;
import fju.im.sa6.entity.ProductList;
import fju.im.sa6.webapp.dao.ProductListDAO;

import java.sql.*;

import javax.sql.DataSource;

public abstract class ProductListDAOImpl implements ProductListDAO {
	private DataSource dataSource;
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement smt = null;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void set(ProductList setPurlist) {
		// TODO Auto-generated method stub
		String sql = "UPDATE productlist(product_num, amount)";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, setPurlist.getProductNum());
			smt.setInt(2, setPurlist.getAmount());
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
	public void remove(ProductList removePurlist) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM product WHERE product_num = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, removePurlist.getProductNum());
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

	public ProductList get(int searchNum) {
		// TODO Auto-generated method stub
		ProductList productlist = null;
		String sql = "SELECT * FROM productlist WHERE product_num = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, searchNum);
			rs = smt.executeQuery();
			if (rs.next()) {
				int setProduct = (rs.getInt("product_Num"));
				int setAmount = (rs.getInt("amount"));
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
	public double getSingleTotal(ProductList gettotal) {
		// TODO Auto-generated method stub
		return 0;
	}

}
