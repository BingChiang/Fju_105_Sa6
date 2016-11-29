package fju.im.sa6.webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import fju.im.sa6.dao.InventoryDAO;
import fju.im.sa6.entity.Inventory;
<<<<<<< HEAD:fju_sa6/src/main/java/fju/im/sa6/webapp/dao/impl/InventoryDAOImpl.java
import fju.im.sa6.entity.Product;
import fju.im.sa6.webapp.dao.InventoryDAO;
=======
>>>>>>> origin/Bing:fju_sa6/src/main/java/fju/im/sa6/dao/impl/InventoryDAOImpl.java

public class InventoryDAOImpl implements InventoryDAO {

	private DataSource dataSource;
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement smt = null;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void add(Inventory addInv) {
		// TODO Auto-generated method stub

		String sql = "INSERT INTO inventory (inventory_num, purchase_num, supplier_num, inventory_amount ,inventory_name) VALUES(?, ?, ? ,? ,?)";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, addInv.getInventoryNum());
			smt.setInt(2, addInv.getPurchaseNum());
			smt.setInt(3, addInv.getSupplierNum());
			smt.setInt(4, addInv.getInventoryAmount());
			smt.setString(5, addInv.getInventoryName());
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
	public void set(Inventory setInv) {
		// TODO Auto-generated method stub
		String sql = "UPDATE inventory SET inventory_num=?, purchase_num=?, supplier_num=?, inventory_amount=?, inventory_name=? "
				+ "WHERE purchase_num = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, setInv.getInventoryNum());
			smt.setInt(2, setInv.getPurchaseNum());
			smt.setInt(3, setInv.getSupplierNum());
			smt.setInt(4, setInv.getInventoryAmount());
			smt.setString(5, setInv.getInventoryName());

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
	public void remove(Inventory removeInv) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM inventory WHERE inventory_num = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, removeInv.getInventoryNum());
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

	public Inventory getInventory(int searchInv) {
		Inventory inv = null;
		String sql = "SELECT * FROM inventory WHERE inventory_num = ?";
		try {

			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, searchInv);
			rs = smt.executeQuery();
			if (rs.next()) {
				int setinventoryNum = (rs.getInt("inventory_num"));
				int setpurchaseNum = (rs.getInt("purchase_num"));
				int setsupplierNum = (rs.getInt("supplier_num"));
				int setinventoryAmount = (rs.getInt("inventory_amount"));
				String setinventoryName = (rs.getString("inventory_name"));
				inv = new Inventory(setinventoryNum, setpurchaseNum, setinventoryAmount, setsupplierNum,
						setinventoryName);
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
		return inv;
	}

}
