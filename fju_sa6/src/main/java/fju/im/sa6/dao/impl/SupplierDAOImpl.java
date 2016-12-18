package fju.im.sa6.dao.impl;

import java.util.ArrayList;

import javax.sql.DataSource;

import fju.im.sa6.entity.Supplier;
import fju.im.sa6.entity.SupplierList;
import fju.im.sa6.dao.SupplierDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SupplierDAOImpl implements SupplierDAO {
	private DataSource dataSource;
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement smt = null;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void add(Supplier addSup) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO supplier (supplier_name, supplier_phone, supplier_address, available_num) VALUES(?, ?, ?, ?)";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, addSup.getSupplierName());
			smt.setString(2, addSup.getSupplierPhone());
			smt.setString(3, addSup.getSupplierAddress());
			smt.setInt(4, 0);
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
	public void set(Supplier setSup) {
		// TODO Auto-generated method stub
		String sql = "UPDATE supplier SET supplier_name=?, supplier_phone=?, supplier_address=? "
				+ "WHERE supplier_num = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, setSup.getSupplierName());
			smt.setString(2, setSup.getSupplierPhone());
			smt.setString(3, setSup.getSupplierAddress());
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
	public void remove(Supplier removeSup) {
		// TODO Auto-generated method stub
		String sql = "UPDATE available_num=1 FROM supplier WHERE supplier_num = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, removeSup.getSupplierNum());
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
	public Supplier get(Supplier searchSup) {
		// TODO Auto-generated method stub
		Supplier sup = null;
		String sql = "SELECT * FROM supplier WHERE supplier_num = ?";
		try {

			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, searchSup.getSupplierNum());
			rs = smt.executeQuery();
			while (rs.next()) {
				int setsupplierNum = (rs.getInt("supplier_num"));
				String setsupplierName = (rs.getString("supplier_name"));
				String setsupplierPhone = (rs.getString("supplier_phone"));
				String setsupplierAddress = (rs.getString("supplier_address"));
				int setavailableNum = (rs.getInt(0));
				sup = new Supplier(setsupplierNum, setsupplierName, setsupplierPhone, setsupplierAddress,
						setavailableNum);
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
		return sup;
	}

	@Override
	public ArrayList<Supplier> getList() {
		ArrayList<Supplier> sup = new ArrayList<Supplier>();
		String sql = "SELECT * FROM supplier";
		
		try {

			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while (rs.next()) {

				int setsupplierNum = (rs.getInt("supplier_num"));
				String setsupplierName = (rs.getString("supplier_name"));
				String setsupplierPhone = (rs.getString("supplier_phone"));
				String setsupplierAddress = (rs.getString("supplier_address"));
				int setavailableNum = (rs.getInt("available_num"));


				sup.add(new Supplier(setsupplierNum,setsupplierName, setsupplierPhone, setsupplierAddress,
						setavailableNum));
				System.out.println(sup.get(sup.size()-1).getSupplierName());

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
		return sup;
	}

}
