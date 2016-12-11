package fju.im.sa6.dao.impl;

import java.util.ArrayList;
import java.util.Date;
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

		String sql = "INSERT INTO inventory (inventory_name,inventory_amount,supplier_num,reorder_point,update_date) VALUES(?,?, ?,Now())";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, inventory.getInventoryName());
			smt.setInt(2, inventory.getInventoryAmount());
			smt.setInt(3, inventory.getSupplierNum());
			smt.setInt(4, inventory.getReorderPoint());
			smt.setDate(5, (java.sql.Date) inventory.getUpdateDate());

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}

	@Override
	public void set(Inventory setInv) {
		// TODO Auto-generated method stub
		String sql = "UPDATE inventory SET inventory_name=?, reorder_point=?, update_date = Now()"
				+ "WHERE inventory_name = ?";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, setInv.getInventoryName());
			smt.setInt(2, setInv.getReorderPoint());
			smt.setDate(3, (java.sql.Date) setInv.getUpdateDate());
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
		String sql = "DELETE FROM inventory WHERE inventory_name = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, inventory.getInventoryName());
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
		Inventory inv = new Inventory();
		String sql = "SELECT * FROM inventory WHERE inventory_name = ?";
		try {

			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, inventory.getInventoryName());
			rs = smt.executeQuery();
			if (rs.next()) {
				int setinventoryNum = (rs.getInt("inventory_num"));
				int setinventoryAmount = (rs.getInt("inventory_amount"));
				int setsupplierNum = (rs.getInt("supplier_num"));
				String setinventoryName = (rs.getString("inventory_name"));
				int setreorderpoint = (rs.getInt("reorder_point"));
				Date setUpdateDate = (rs.getDate("update_date"));
				inv = new Inventory(setinventoryNum, setinventoryAmount, setsupplierNum, setinventoryName,
						setreorderpoint, setUpdateDate);
				rs.close();
				smt.close();

			}
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

	public ArrayList<Inventory> getList() {
		// TODO Auto-generated method stub
		ArrayList<Inventory> inv = new ArrayList<Inventory>();
		String sql = "SELECT inventory_num, inventory_name FROM inventory ";
		try {

			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			if (rs.next()) {
				int inventorynum = (rs.getInt("inventory_num"));
				int inventoryAmount = (rs.getInt("inventory_amount"));
				int supplierNum = (rs.getInt("supplier_num"));
				String inventoryname = (rs.getString("inventory_name"));
				int reorder_point = (rs.getInt("reorder_point"));
				Date update_date = (rs.getDate("update_date"));

				inv.add(new Inventory(inventorynum, inventoryAmount, supplierNum, inventoryname, reorder_point,
						update_date));
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
	public ArrayList<Inventory> getList(Supplier supplier) {
		// TODO Auto-generated method stub
		ArrayList<Inventory> inv = new ArrayList<Inventory>();
		String sql = "SELECT supplier_num,inventory_num, inventory_name FROM inventory WHERE supplier_name = ?";
		try {

			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			if (rs.next()) {
				int inventorynum = (rs.getInt("inventory_num"));
				int inventoryAmount = (rs.getInt("inventory_amount"));
				int supplierNum = (rs.getInt("supplier_num"));
				String inventoryname = (rs.getString("inventory_name"));
				int reorder_point = (rs.getInt("reorder_point"));
				Date update_date = (rs.getDate("update_date"));

				inv.add(new Inventory(inventorynum, inventoryAmount, supplierNum, inventoryname, reorder_point,
						update_date));
			}
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
