package fju.im.sa6.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import fju.im.sa6.entity.Product;
import fju.im.sa6.dao.ProductDAO;

//rebuild by bing 2016.11.30
public class ProductDAOImpl implements ProductDAO {
	private DataSource dataSource;
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement smt = null;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void add(Product addPro) {
		String sql = "INSERT INTO product (product_num, type_num,product_name, product_price, product_sell_month) VALUES(?, ?, ?, ?, ?, ?)";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, addPro.getProductNum());
			smt.setInt(2, addPro.getTypeNum());
			smt.setString(3, addPro.getProductName());
			smt.setInt(4, addPro.getProductPrice());
			smt.setInt(5, addPro.getProductSellMonth());
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
	public void set(Product setPro) {
		String sql = "UPDATE product SET product_name=?, product_price=?, product_sell_month=? "
				+ "WHERE productID = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(3, setPro.getProductName());
			smt.setInt(4, setPro.getProductPrice());
			smt.setInt(5, setPro.getProductSellMonth());
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
	public void remove(Product removePro) {
		String sql = "DELETE FROM product WHERE product_num = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, removePro.getProductNum());
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

	public Product get(Product product) {
		Product pro = null;
		String sql = "SELECT * FROM product WHERE product_num = ?";
		try {

			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, product.getProductNum());
			rs = smt.executeQuery();
			if (rs.next()) {
				int setproduct_Num = (rs.getInt("product_Num"));
				int settype_Num = (rs.getInt("type_Num"));
				String setproduct_Name = (rs.getString("product_Name"));
				int setproduct_price = (rs.getInt("product_price"));
				int setproduct_sell_month = (rs.getInt("product_sell_month"));
				pro = new Product(setproduct_Num, settype_Num, setproduct_Name, setproduct_price, setproduct_sell_month,
						setproduct_sell_month);
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
		return pro;
	}

}