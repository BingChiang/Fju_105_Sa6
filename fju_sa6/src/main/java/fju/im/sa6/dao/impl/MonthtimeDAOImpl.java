package fju.im.sa6.webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import fju.im.sa6.webapp.dao.MonthtimeDAO;

public class MonthtimeDAOImpl implements MonthtimeDAO{
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;


}
	@Override
	public double totalMonthWorktime() {
		// TODO Auto-generated method stub
		
		return 0;
	}

	@Override
	public double getMonthSalary() {
		// TODO Auto-generated method stub
		
		return 0;
	}

}
