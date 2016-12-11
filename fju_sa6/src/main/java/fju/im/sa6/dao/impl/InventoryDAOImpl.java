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

		String sql = "INSERT INTO inventory (inventory_name,inventory_amount,supplier_num,reorder_point,update_date) VALUES(?, ?, ?, ?,Now())";
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
				+ "WHERE inventory_num = ?";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, setInv.getInventoryName());
			smt.setInt(2, setInv.getReorderPoint());
			smt.setDate(3, (java.sql.Date) setInv.getUpdateDate());
			smt.setInt(4, setInv.getInventoryNum());
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
		String sql1 = "SELECT supplier_name FROM supplier WHERE supplier_num = ?";
		try {

			conn = dataSource.getConnection();
<<<<<<< HEAD
			
=======
			conn1 = dataSource.getConnection();
>>>>>>> branch 'Cheyu' of https://github.com/BingChiang/Fju_105_Sa6
			smt = conn.prepareStatement(sql);
			smt.setInt(1, inventory.getInventoryNum());
			rs = smt.executeQuery();
			if (rs.next()) {
<<<<<<< HEAD
				conn1 = dataSource.getConnection();
=======
>>>>>>> branch 'Cheyu' of https://github.com/BingChiang/Fju_105_Sa6
				smt1 = conn1.prepareStatement(sql1);
				rs1 = smt1.executeQuery();
				smt1.setInt(1, rs.getInt("supplier_num"));
				int setinventoryNum = (rs.getInt("inventory_num"));
				int setinventoryAmount = (rs.getInt("inventory_amount"));
				int setsupplierNum = (rs.getInt("supplier_num"));
				String setsupplierName = (rs1.getString("supplier_name"));
				String setinventoryName = (rs.getString("inventory_name"));
				int setreorderpoint = (rs.getInt("reorder_point"));
				Date setUpdateDate = (rs.getDate("update_date"));
				inv = new Inventory(setinventoryNum, setinventoryAmount, setsupplierNum, setsupplierName, setinventoryName,
						setreorderpoint, setUpdateDate);
<<<<<<< HEAD
			
=======
				rs.close();
				smt.close();
				rs1.close();
				smt1.close();

>>>>>>> branch 'Cheyu' of https://github.com/BingChiang/Fju_105_Sa6
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
		return inv;
	}

	public ArrayList<Inventory> getList() {
		// TODO Auto-generated method stub
		ArrayList<Inventory> inv = new ArrayList<Inventory>();
<<<<<<< HEAD
		int suppliernum = 0;
		String supplierName=null;
		String sql = "SELECT * FROM inventory";
=======
		String sql = "SELECT * FROM inventory ";
>>>>>>> branch 'Cheyu' of https://github.com/BingChiang/Fju_105_Sa6
		String sql1 = "SELECT supplier_name FROM supplier WHERE supplier_num = ?";
		try {
			conn = dataSource.getConnection();
			conn1 = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
<<<<<<< HEAD
			
			
			
			while(rs.next()) {
=======
			if (rs.next()) {
				smt1 = conn1.prepareStatement(sql1);
				rs1 = smt1.executeQuery();
				smt1.setInt(1, rs.getInt("supplier_num"));
>>>>>>> branch 'Cheyu' of https://github.com/BingChiang/Fju_105_Sa6
				int inventorynum = (rs.getInt("inventory_num"));
				int inventoryAmount = (rs.getInt("inventory_amount"));
				int supplierNum = (rs.getInt("supplier_num"));
<<<<<<< HEAD
=======
				String supplierName = (rs1.getString("supplier_name"));
>>>>>>> branch 'Cheyu' of https://github.com/BingChiang/Fju_105_Sa6
				String inventoryName = (rs.getString("inventory_name"));
				int reorder_point = (rs.getInt("reorder_point"));
				Date update_date = (rs.getDate("update_date"));
				suppliernum =  rs.getInt("supplier_num");
				conn1 = dataSource.getConnection();
				
				sql1 = "SELECT supplier_name FROM supplier WHERE supplier_num ="+suppliernum;
				smt1 = conn1.prepareStatement(sql1);
				rs1 = smt1.executeQuery();
				//smt1.setInt(1, suppliernum);
				
			while(rs1.next()){
				
				supplierName = (rs1.getString("supplier_name"));
			}

				inv.add(new Inventory(inventorynum, inventoryAmount, supplierNum, supplierName, inventoryName, reorder_point,
						update_date));
				
			
			rs1.close();
			smt1.close();
			}
			rs.close();
			smt.close();
<<<<<<< HEAD
			
=======
			rs1.close();
			smt1.close();
>>>>>>> branch 'Cheyu' of https://github.com/BingChiang/Fju_105_Sa6

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
		String sql = "SELECT * FROM inventory WHERE supplier_num = ?";
		String sql1 = "SELECT supplier_name FROM supplier WHERE supplier_num=?";
		try {

			conn = dataSource.getConnection();
<<<<<<< HEAD
			
=======
			conn1 = dataSource.getConnection();
>>>>>>> branch 'Cheyu' of https://github.com/BingChiang/Fju_105_Sa6
			smt = conn.prepareStatement(sql);
			smt.setInt(1, supplier.getSupplierNum());
			rs = smt.executeQuery();
<<<<<<< HEAD
			while(rs.next()) {
				conn1 = dataSource.getConnection();
=======
			if (rs.next()) {
>>>>>>> branch 'Cheyu' of https://github.com/BingChiang/Fju_105_Sa6
				smt1 = conn1.prepareStatement(sql1);
				smt1.setInt(1, rs.getInt("supplier_num"));
				rs1 = smt1.executeQuery();
				int inventorynum = (rs.getInt("inventory_num"));
				int inventoryAmount = (rs.getInt("inventory_amount"));
				int supplierNum = (rs.getInt("supplier_num"));
				String supplierName = (rs1.getString("supplier_name"));
				String inventoryName = (rs.getString("inventory_name"));
				int reorder_point = (rs.getInt("reorder_point"));
				Date update_date = (rs.getDate("update_date"));

				inv.add(new Inventory(inventorynum, inventoryAmount, supplierNum, supplierName, inventoryName, reorder_point,
						update_date));
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
		return inv;
	}

}
