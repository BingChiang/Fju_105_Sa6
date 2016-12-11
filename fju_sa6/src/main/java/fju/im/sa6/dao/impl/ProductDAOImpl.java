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
	private ResultSet rs = null;
	private PreparedStatement smt = null;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void add(Product addPro) {
		String sql = "INSERT INTO product (product_name, product_price, product_sell_month, product_cost) VALUES(?, ?, ?,?)";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, addPro.getProductName());
			smt.setInt(2, addPro.getProductPrice());
			smt.setInt(3, addPro.getProductSellMonth());
			smt.setInt(4, addPro.getProductCost());
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
				+ "WHERE product_name = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, setPro.getProductName());
			smt.setInt(2, setPro.getProductPrice());
			smt.setInt(3, setPro.getProductSellMonth());
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
		String sql = "DELETE FROM product WHERE product_name = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, removePro.getProductName());
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
		String sql = "SELECT * FROM product WHERE product_name = ?";
		try {

			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, product.getProductName());
			rs = smt.executeQuery();
			if (rs.next()) {
				int setproduct_Num = (rs.getInt("product_num"));
				int settype_Num = (rs.getInt("type_num"));
				String settype_Name = (rs.getString("type_name"));
				String setproduct_Name = (rs.getString("product_name"));
				int setproduct_price = (rs.getInt("product_price"));
				int setproduct_sell_month = (rs.getInt("product_sell_month"));
				int setproductCost = (rs.getInt("product_cost"));
				pro = new Product(setproduct_Num, settype_Num, settype_Name, setproduct_Name, setproduct_price,setproduct_sell_month, setproductCost);
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

		String sql = "SELECT * FROM product Where type_num = ?";
		try {

			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, type.getTypeNum());
			rs = smt.executeQuery();
			if (rs.next()) {
				temp = new Product(rs.getInt("product_num"), rs.getInt("type_num"), rs.getString("type_name"), rs.getString("product_name"),
						rs.getInt("product_price"),rs.getInt("product_sell_month"), rs.getInt("product_cost"));
				productArr.add(temp);
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

	public ArrayList<Product> getList() {
		// TODO Auto-generated method stub
		ArrayList<Product> productArr = new ArrayList<Product>();

		String sql = "SELECT * FROM product ";
		try {

			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			if (rs.next()) {
				int productNum = (rs.getInt("product_num"));
				int typeNum = (rs.getInt("type_num"));
				int supplierNum = (rs.getInt("supplier_num"));
				String typeName = (rs.getString("type_name"));
				String productName = (rs.getString("product_name"));
				int productprice = (rs.getInt("product_price"));
				int productsellmonth = (rs.getInt("product_sell_month"));
				int productcost = (rs.getInt("product_cost"));
				productArr.add(new Product(productNum,typeNum,typeName,productName,productprice,productsellmonth,productcost));
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
