package fju.im.sa6.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import fju.im.sa6.dao.MonthtimeDAO;
import fju.im.sa6.entity.StaffDefault;


//rebuild by bing 2016.11.30
public class MonthtimeDAOImpl implements MonthtimeDAO {
	private DataSource dataSource;
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement smt = null;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;

	}

	public double totalMonthWorktime(StaffDefault staffDefault) {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getMonthSalary(StaffDefault staffDefault) {
		// TODO Auto-generated method stub
		return 0;
	}

}
