package fju.im.sa6.webapp.dao.impl;

import fju.im.sa6.entity.Product;
import fju.im.sa6.webapp.dao.ProductDAO;
import java.sql.*;

import javax.sql.DataSource;
public class ProductDAOImpl implements ProductDAO{
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	@Override
	public void add(Product addPro) {
		// TODO Auto-generated method stub
		 String sql = "INSERT INTO product (prduct_name,product_price,product_sell_month) VALUES(?, ?, ?)";	
			try {
				conn = dataSource.getConnection();
				smt = conn.prepareStatement(sql);

				smt.setString(1,addPro.getProductName());
				smt.setInt(2,addPro.getProductPrice());
				smt.setInt(3,addPro.getProductSellMonth());
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
	public void set(Product setPro) {
		// TODO Auto-generated method stub
		 String sql = "UPDATE product (prduct_name,product_price,product_sell_month) VALUES(?, ?, ?)";	
			try {
				conn = dataSource.getConnection();
				smt = conn.prepareStatement(sql);
				smt.setString(1,setPro.getProductName());
				smt.setInt(2,setPro.getProductPrice());
				smt.setInt(3,setPro.getProductSellMonth());
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
	public void remove(Product removePro) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM product WHERE product_num = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1,removePro.getProductNum());
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
	public Product getProduct(int searchNum) {
		Product prod = null ;
		String sql = "SELECT * FROM product WHERE product_num = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, searchNum);
			rs = smt.executeQuery();
			if(rs.next()){

				int setProduct=(rs.getInt("product_num"));
				int setType_Num=(rs.getInt("type_num"));
				String setProduct_Name=(rs.getString("product_name"));

				int setproduct_price=(rs.getInt("product_price"));
				int setproduct_sell_month=(rs.getInt("product_sell_month"));
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
		return prod;
	}

}
