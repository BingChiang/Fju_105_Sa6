package fju.im.sa6.webapp.dao.impl;

import fju.im.sa6.webapp.dao.WorktimeDAO;
import java.sql.*;

import javax.sql.DataSource;
public class WorktimeDAOImpl implements WorktimeDAO{
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	@Override
	public double getDayWorktime() {
		// TODO Auto-generated method stub
		
		return 0;
	}

	@Override
	public void amendOnWork() {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO worktime (work_date, on_work) VALUES(select TO_CHAR(ADD_MONTHS(sysdate,-1),'mmdd') from worktime), Now())";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setDate(1,(Date) getDate());
			smt.setInt(2,addPro.getOnWork());
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
	public void amendOffWork() {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO worktime (work_date, off_work) VALUES(select TO_CHAR(ADD_MONTHS(sysdate,-1),'mmdd') from worktime), Now())";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);

			smt.setDate(1,(Date) addPro.getWorkDate());
			smt.setInt(2,add.getOffWork());
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
	
	

}
