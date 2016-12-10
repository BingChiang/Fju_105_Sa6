package fju.im.sa6.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

import javax.sql.DataSource;

import fju.im.sa6.entity.Purchase;
import fju.im.sa6.dao.PurchaseDAO;

public class PurchaseDAOImpl implements PurchaseDAO {

	private DataSource dataSource;
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement smt = null;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void add(Purchase addPur) {
		// TODO Auto-generated method stub
		String sql = "SELECT inventory_num FROM inventory";
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
		int[] nowinv;
		for(int j=1;)
		String sql = "INSERT INTO inventory (inventoryNum, purchaseNum, supplierNum, inventoryName, purchasePrice, inventoryAmount, purchaseDate) VALUES(?, ?, ?, ?, ?, ?, ?)";
		for(int i=1;i<=)
		if(addPur.getInventoryNum()==){
		
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			int setinventoryNum = (rs.getInt("inventory_num"));
			int setpurchaseNum = (rs.getInt("purchase_num"));
			int setsupplierNum = (rs.getInt("supplier_num"));
			int setinventoryAmount = (rs.getInt("inventory_amount"));
			String setinventoryName = (rs.getString("inventory_Name"));
			Double setpurchaseprice = (rs.getDouble("purchase_price"));
			Date setpurchaseDate = (rs.getDate("purchase_date"));
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
	}

	@Override
	public void set(Purchase setPur) {
		// TODO Auto-generated method stub
		String sql = "UPDATE purchase SET purchase_name=?, purchase_price=? "
				+ "WHERE purchase_num = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, setPur.getPurchaseName());
			smt.setDouble(2, setPur.getPurchasePrice());
			smt.setDate(3, (Date) setPur.getPurchaseDate());
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
	public void remove(Purchase removePur) {
		String sql = "DELETE FROM purchase WHERE purchase_num = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, removePur.getPurchaseNum());
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
	public ArrayList<Purchase> getList(Purchase purchase) {
		// TODO Auto-generated method stub
		Purchase pur = null;

		String sql = "SELECT * FROM purchase WHERE purchase_num = ?";
		try {

			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, purchase.getPurchaseNum());
			rs = smt.executeQuery();
			if (rs.next()) {
				int setinventoryNum = (rs.getInt("inventory_num"));
				int setpurchaseNum = (rs.getInt("purchase_num"));
				int setsupplierNum = (rs.getInt("supplier_num"));
				int setinventoryAmount = (rs.getInt("inventory_amount"));
				String setinventoryName = (rs.getString("inventory_Name"));
				Double setpurchaseprice = (rs.getDouble("purchase_price"));
				Date setpurchaseDate = (rs.getDate("purchase_date"));
				pur = new Purchase(setinventoryNum, setpurchaseNum, setsupplierNum, setinventoryName, setpurchaseprice, setinventoryAmount, setpurchaseDate);
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
		return getList(pur);
	}

	@Override
	public Purchase get(Purchase searchPur) {
		// TODO Auto-generated method stub
		Purchase pur = null;
		String sql = "SELECT * FROM purchase WHERE purchase_num = ?";
		try {

			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, searchPur.getPurchaseNum());
			rs = smt.executeQuery();
			if (rs.next()) {
				String setpurchase_Name = (rs.getString("purchase_Name"));
				int setpurchase_Num = (rs.getInt("purchase_Num"));
				Double setpurchase_price = (rs.getDouble("purchase_price"));
				Date setpurchase_Date = (rs.getDate("purchase_date"));
				pur = new Purchase(setpurchase_Name, setpurchase_Num, setpurchase_price, setpurchase_Date);
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
		return pur;
	}
}
