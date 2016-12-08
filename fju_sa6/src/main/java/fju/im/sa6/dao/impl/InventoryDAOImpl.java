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

		String sql = "INSERT INTO inventory (inventory_name,supplier_num ,reorder_point, purchase_date) VALUES(?,?, ?,Now())";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, inventory.getInventoryName());
			smt.setInt(2, inventory.getReorderPoint());
			smt.setDate(3, (Date) inventory.getPurchaseDate());

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
		String sql = "UPDATE inventory SET inventory_name=?, reorder_point=?, purchase_date=Now()"
				+ "WHERE inventory_name = ?";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, setInv.getInventoryName());
			smt.setInt(2, setInv.getReorderPoint());
			smt.setDate(3, (Date) setInv.getPurchaseDate());
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
				int setpurchaseNum = (rs.getInt("purchase_num"));
				int setsupplierNum = (rs.getInt("supplier_num"));
				String setinventoryName = (rs.getString("inventory_name"));
				int setreorderpoint = (rs.getInt("reorder_point"));
				Date setpurchasedate = (rs.getDate("purchase_date"));
				inv = new Inventory(setinventoryNum, setpurchaseNum, setsupplierNum, setinventoryName, setreorderpoint,
						setpurchasedate);
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

	@Override
	public ArrayList<Inventory> getList(Inventory inventory) {
		// TODO Auto-generated method stub
		String sql = "SELECT inventory_num, inventory_name FROM inventory ";
		try {

			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			if (rs.next()) {
				int setinventorynum = (rs.getInt("inventory_num"));
				String setinventoryname = (rs.getString("inventory_name"));
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
		String sql = "SELECT supplier_num,inventory_num, inventory_name FROM inventory WHERE supplier_name = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, supplier.getSupplierNum());
			rs = smt.executeQuery();
			if (rs.next()) {
				int setsuppliernum = (rs.getInt("supplier_num"));
				int setinventorynum = (rs.getInt("inventory_num"));
				String setinventoryname = (rs.getString("inventory_name"));
				inventory.setSupplierNum(setsuppliernum);
				inventory.setInventoryNum(setinventorynum);
				inventory.setInventoryName(setinventoryname);
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
