package fju.im.sa6.webapp.dao.impl;

import fju.im.sa6.entity.Manager;
import fju.im.sa6.webapp.dao.ManagerDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class ManagerDAOImpl implements ManagerDAO {
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	@Override
	public void addStaff(Manager addstaff) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO manager (staff_name, staff_lv)VALUE(?, ?)";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);

			smt.setString(1,addstaff.getStaffName());
			smt.setString(1,addstaff.getStaffLv());
			smt.executeUpdate();			
			smt.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}

	@Override
	public void set(Manager setstaff) {
		// TODO Auto-generated method stub
		String sql = "UPDATE manager (staff_name,staff_Lv) VALUES(?, ?)";	
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1,setstaff.getStaffName());
			smt.setInt(2,setstaff.getStaffLv());
			smt.executeUpdate();			
			smt.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}


	}

	@Override
	public void remove(Manager removestaff) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM manager WHERE staff_num = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1,removestaff.getStaffNum());
			smt.executeUpdate();			
			smt.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}

	@Override
	public void inquireAllWorktime(Manager inquireAWKT) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setlevel(int staffNum) {
		// TODO Auto-generated method stub
		
		String sql = "UPDATE manager (staff_num, staff_lv) VALUES(?, ?)";
		try{
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, staffNum.getStaffLV());
			
		}
	
		
		
	}

}
