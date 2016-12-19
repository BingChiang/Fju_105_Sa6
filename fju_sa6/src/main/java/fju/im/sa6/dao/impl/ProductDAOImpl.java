package fju.im.sa6.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;
import fju.im.sa6.entity.Product;
import fju.im.sa6.entity.Type;
import fju.im.sa6.dao.ProductDAO;

//rebuild by bing 2016.11.30
public class ProductDAOImpl implements ProductDAO {
	private DataSource dataSource;
	private Connection conn = null;
	private Connection conn1 = null;
	private ResultSet rs = null;
	private PreparedStatement smt = null;
	private ResultSet rs1 = null;
	private PreparedStatement smt1 = null;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void add(Product addPro) {
		String sql = "INSERT INTO product (product_name, product_price, product_sell_month, product_cost, type_num) VALUES(?, ?, ?,?,?)";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, addPro.getProductName());
			smt.setInt(2, addPro.getProductPrice());
			smt.setInt(3, addPro.getProductSellMonth());
			smt.setInt(4, addPro.getProductCost());
			smt.setInt(5, addPro.getTypeNum());
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
		String sql = "UPDATE product SET product_name=?, product_price=?, product_sell_month=?, type_num=? "
				+ "WHERE product_num = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, setPro.getProductName());
			smt.setInt(2, setPro.getProductPrice());
			smt.setInt(3, setPro.getProductSellMonth());
			smt.setInt(4, setPro.getTypeNum());
			smt.setInt(5, setPro.getProductNum());
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
		String sql = "UPDATE product SET available_num = 1 WHERE product_num = ?";
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
		int productnum = product.getProductNum();
		int typenum = 0;
		String typename = null;
		String sql = "SELECT * FROM product WHERE product_num = " + productnum;
		String sql1 = "SELECT type_name FROM type WHERE type_num=" + typenum;
		try {
			conn = dataSource.getConnection();
			conn1 = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while (rs.next()) {
				int setproduct_Num = (rs.getInt("product_num"));
				int settype_Num = (rs.getInt("type_num"));
				String setproduct_Name = (rs.getString("product_name"));
				int setproduct_price = (rs.getInt("product_price"));
				int setproduct_sell_month = (rs.getInt("product_sell_month"));
				int setproductCost = (rs.getInt("product_cost"));
				typenum = rs.getInt("type_num");
				conn1 = dataSource.getConnection();
				smt1 = conn1.prepareStatement(sql1);
				rs1 = smt1.executeQuery();
				while (rs1.next()) {
					typename = (rs1.getString("type_name"));

				}

				pro = new Product(setproduct_Num, settype_Num, typename, setproduct_Name, setproduct_price,

						setproduct_sell_month, setproductCost);
				rs1.close();
				smt1.close();
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

	public ArrayList<Product> getTypeList(Type type) {
		ArrayList<Product> productArr = new ArrayList<Product>();
		Product temp;
		int typenum = type.getTypeNum();
		String typeName = null;
		String sql = "SELECT * FROM product Where type_num = ? AND available_num = 0";

		String sql1 = "SELECT type_name FROM type WHERE type_num=?";
		try {
			conn = dataSource.getConnection();
			conn1 = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1,typenum);
			rs = smt.executeQuery();

			while (rs.next()) {

				int productNum = (rs.getInt("product_num"));
				int typeNum = (rs.getInt("type_num"));
				String productName = (rs.getString("product_name"));
				int productprice = (rs.getInt("product_price"));
				int productsellmonth = (rs.getInt("product_sell_month"));
				int productcost = (rs.getInt("product_cost"));
				typenum = rs.getInt("type_num");
				conn1 = dataSource.getConnection();
				sql1 = "SELECT type_name FROM type WHERE type_num=" + typenum;
				// smt1.setInt(1, rs.getInt("type_num"));
				smt1 = conn1.prepareStatement(sql1);
				rs1 = smt1.executeQuery();

				while (rs1.next()) {
					typeName = (rs1.getString("type_name"));
				}
				productArr.add(new Product(productNum, typeNum, typeName, productName, productprice, productsellmonth,
						productcost));
				rs1.close();
				smt1.close();

			}
			rs.close();
			smt.close();
			rs1.close();
			smt1.close();

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

		return productArr;
	}

	public ArrayList<Product> getList() {
		// TODO Auto-generated method stub
		ArrayList<Product> productArr = new ArrayList<Product>();
		int typenum = 0;
		String typeName = null;

		String sql = "SELECT * FROM product WHERE available_num = 0";
		String sql1 = "SELECT type_name FROM type WHERE type_num=?";
		try {
			conn = dataSource.getConnection();
			conn1 = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt1 = conn1.prepareStatement(sql1);
			rs = smt.executeQuery();

			while (rs.next()) {

				int productNum = (rs.getInt("product_num"));
				int typeNum = (rs.getInt("type_num"));
				String productName = (rs.getString("product_name"));
				int productprice = (rs.getInt("product_price"));
				int productsellmonth = (rs.getInt("product_sell_month"));
				int productcost = (rs.getInt("product_cost"));
				typenum = rs.getInt("type_num");
				conn1 = dataSource.getConnection();
				sql1 = "SELECT type_name FROM type WHERE type_num=" + typenum;
				// smt1.setInt(1, rs.getInt("type_num"));
				smt1 = conn1.prepareStatement(sql1);
				rs1 = smt1.executeQuery();

				while (rs1.next()) {
					typeName = (rs1.getString("type_name"));
				}
				productArr.add(new Product(productNum, typeNum, typeName, productName, productprice, productsellmonth,
						productcost));
				rs1.close();
				smt1.close();

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

		return productArr;
	}

}
