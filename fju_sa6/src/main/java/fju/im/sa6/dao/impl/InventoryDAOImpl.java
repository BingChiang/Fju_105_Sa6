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
	private Connection conn1 = null;
	private ResultSet rs = null;
	private PreparedStatement smt = null;
	private ResultSet rs1 = null;
	private PreparedStatement smt1 = null;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void add(Inventory inventory) {
		// TODO Auto-generated method stub
		System.out.println(inventory.getInventoryName());
		System.out.println(inventory.getInventoryAmount());
		System.out.println(inventory.getSupplierNum());
		System.out.println(inventory.getReorderPoint());

		String sql = "INSERT INTO inventory (inventory_name,inventory_amount,supplier_num,reorder_point,update_date) VALUES(?, ?, ?, ?,Now())";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, inventory.getInventoryName());
			smt.setInt(2, inventory.getInventoryAmount());
			smt.setInt(3, inventory.getSupplierNum());
			smt.setInt(4, inventory.getReorderPoint());
			// smt.setDate(5, (java.sql.Date) inventory.getUpdateDate());
			smt.executeUpdate();
			smt.close();

		} catch (SQLException e) {
			System.out.println("ERROR");
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
		System.out.println(setInv.getInventoryName());
		String sql = "UPDATE inventory SET inventory_name=?, reorder_point=?, update_date = Now()"
				+ "WHERE inventory_num = ?";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, setInv.getInventoryName());
			smt.setInt(2, setInv.getReorderPoint());
			// smt.setDate(3, (java.sql.Date) setInv.getUpdateDate());
			smt.setInt(3, setInv.getInventoryNum());
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
		Inventory inv = new Inventory();
		int inventorynum = inventory.getInventoryNum();
		int suppliernum = inventory.getSupplierNum();
		String setsupplierName = null;
		String sql = "SELECT * FROM inventory WHERE inventory_num = " + inventorynum;

		try {

			conn = dataSource.getConnection();
			conn1 = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while (rs.next()) {

				int setinventoryNum = (rs.getInt("inventory_num"));
				int setinventoryAmount = (rs.getInt("inventory_amount"));
				int setsupplierNum = (rs.getInt("supplier_num"));
				String setinventoryName = (rs.getString("inventory_name"));
				int setreorderpoint = (rs.getInt("reorder_point"));
				Date setUpdateDate = (rs.getDate("update_date"));

				String sql1 = "SELECT supplier_name FROM supplier WHERE supplier_num = " + suppliernum;
				smt1 = conn1.prepareStatement(sql1);
				rs1 = smt1.executeQuery();
				while (rs1.next()) {
					setsupplierName = (rs1.getString("supplier_name"));
				}

				inv = new Inventory(setinventoryNum, setinventoryAmount, setsupplierNum, setsupplierName,
						setinventoryName, setreorderpoint, setUpdateDate);

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
		return inv;
	}

	public ArrayList<Inventory> getList() {
		// TODO Auto-generated method stub
		ArrayList<Inventory> inv = new ArrayList<Inventory>();

		int suppliernum = 0;
		String supplierName = null;
		String sql = "SELECT * FROM inventory";

		try {
			conn = dataSource.getConnection();
			conn1 = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();

			while (rs.next()) {

				int inventorynum = (rs.getInt("inventory_num"));
				int inventoryAmount = (rs.getInt("inventory_amount"));
				int supplierNum = (rs.getInt("supplier_num"));
				String inventoryName = (rs.getString("inventory_name"));
				int reorder_point = (rs.getInt("reorder_point"));
				Date update_date = (rs.getDate("update_date"));
				String update = update_date.toString();
				suppliernum = rs.getInt("supplier_num");
				conn1 = dataSource.getConnection();

				String sql1 = "SELECT supplier_name FROM supplier WHERE supplier_num =" + suppliernum;
				smt1 = conn1.prepareStatement(sql1);
				rs1 = smt1.executeQuery();

				while (rs1.next()) {

					supplierName = (rs1.getString("supplier_name"));
				}

				Inventory temp = null;
				temp = new Inventory(inventorynum, inventoryAmount, supplierNum, supplierName, inventoryName,
						reorder_point, update_date);
				temp.setUpdate(update);
				inv.add(temp);

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
		return inv;
	}

	@Override
	public ArrayList<Inventory> getList(Supplier supplier) {
		// TODO Auto-generated method stub
		ArrayList<Inventory> inv = new ArrayList<Inventory>();
		int suppliernum = supplier.getSupplierNum();
		String supplierName = null;
		String sql = "SELECT * FROM inventory WHERE supplier_num = " + suppliernum;

		try {

			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while (rs.next()) {

				int inventorynum = (rs.getInt("inventory_num"));
				int inventoryAmount = (rs.getInt("inventory_amount"));
				int supplierNum = (rs.getInt("supplier_num"));
				String inventoryName = (rs.getString("inventory_name"));
				int reorder_point = (rs.getInt("reorder_point"));
				Date update_date = (rs.getDate("update_date"));
				conn1 = dataSource.getConnection();
				String sql1 = "SELECT supplier_name FROM supplier WHERE supplier_num = " + suppliernum;
				smt1 = conn1.prepareStatement(sql1);
				rs1 = smt1.executeQuery();
				while (rs1.next()) {
					supplierName = (rs1.getString("supplier_name"));
				}

				inv.add(new Inventory(inventorynum, inventoryAmount, supplierNum, supplierName, inventoryName,
						reorder_point, update_date));
				rs1.close();
				smt1.close();
			}
			rs.close();
			smt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null || conn1 != null) {
				try {
					conn.close();
					conn1.close();
				} catch (SQLException e) {
				}
			}
		}
		return inv;
	}

}
