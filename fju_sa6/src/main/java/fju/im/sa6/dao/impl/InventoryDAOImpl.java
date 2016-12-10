package fju.im.sa6.dao.impl;

import java.util.ArrayList;
import javax.sql.*;
import java.sql.*;
import fju.im.sa6.dao.InventoryDAO;
import fju.im.sa6.entity.Inventory;
import fju.im.sa6.entity.Supplier;

//rebuild by bing 2016.11.30

public class InventoryDAOImpl implements InventoryDAO {

	private DataSource dataSource;
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement smt = null;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void add(Inventory inventory) { 
		// TODO Auto-generated method stub

		String sql = "INSERT INTO inventory (inventory_amount ,inventory_name) VALUES(? ,?)";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, inventory.getInventoryAmount());
			smt.setString(2, inventory.getInventoryName());
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
		String sql = "UPDATE inventory SET inventory_amount=?, inventory_name=? " + "WHERE purchase_num = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, setInv.getInventoryAmount());
			smt.setString(2, setInv.getInventoryName());

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
	public void remove(Inventory inventory) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM inventory WHERE inventory_num = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, inventory.getInventoryNum());
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

	public Inventory get(Inventory inventory) {
		Inventory inv = null;
		String sql = "SELECT * FROM inventory WHERE inventory_num = ?";
		try {

			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, inventory.getInventoryNum());
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

	@Override
	public ArrayList<Inventory> getList(Inventory inventory) {
		// TODO Auto-generated method stub
		String sql = "SELECT inventory_num, inventory_name, inventory_amount FROM inventory ";
		try {

			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			if (rs.next()) {
				int setinventorynum = (rs.getInt("inventory_num"));
				String setinventoryname = (rs.getString("inventory_name"));
				int setinvnentoryamount = (rs.getInt("inventory_amount"));
				inventory.setInventoryAmount(setinvnentoryamount);
				inventory.setInventoryName(setinventoryname);
				inventory.setInventoryNum(setinventorynum);

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
		return getList(inventory);
	}

	@Override
	public ArrayList<Inventory> getList(Supplier supplier) {
		// TODO Auto-generated method stub
		Inventory inventory = new Inventory();
		String sql = "SELECT supplier_num,inventory_num, inventory_name, inventory_amount FROM inventory WHERE supplier_num = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, supplier.getSupplierNum());
			rs = smt.executeQuery();
			if (rs.next()) {
				int setsuppliernum = (rs.getInt("supplier_num"));
				int setinventorynum = (rs.getInt("inventory_num"));
				String setinventoryname = (rs.getString("inventory_name"));
				int setinvnentoryamount = (rs.getInt("inventory_amount"));
				inventory.setSupplierNum(setsuppliernum);
				inventory.setInventoryNum(setinventorynum);
				inventory.setInventoryName(setinventoryname);
				inventory.setInventoryAmount(setinvnentoryamount);
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
		return getList(inventory);
	}

}
