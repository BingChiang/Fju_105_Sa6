package fju.im.sa6.dao.impl;

import java.sql.Connection;
import java.util.ArrayList;
import javax.sql.*;
import java.sql.*;
import fju.im.sa6.dao.InventoryDAO;
import fju.im.sa6.entity.Inventory;

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

		String sql = "INSERT INTO inventory (inventory_amount ,inventory_name, reorder_point, purchase_date) VALUES(? ,?, ?, ?)";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, inventory.getInventoryAmount());
			smt.setString(2, inventory.getInventoryName());
			smt.setInt(3, inventory.getReorderPoint());
			smt.setDate(4, (Date) inventory.getPurchaseDate());
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
		String sql = "UPDATE inventory SET inventory_amount=?, inventory_name=?, reorder_point=?"
				+ "WHERE inventory_num = ?";
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
		Inventory inv = new Inventory();
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
				int setinventoryAmount = (rs.getInt("inveinvntory_amount"));
				String setinventoryName = (rs.getString("inventory_name"));
				inv.setInventoryNum(setinventoryNum);
				inv.setPurchaseNum(setpurchaseNum);
				inv.setPurchaseNum(setsupplierNum);
				inv.setInventoryAmount(setinventoryAmount);
				inv.setInventoryName(setinventoryName);

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

}
