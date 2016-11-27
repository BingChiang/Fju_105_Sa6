package fju.im.sa6.webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import fju.im.sa6.entity.Inventory;
import fju.im.sa6.entity.Type;
import fju.im.sa6.webapp.dao.TypeDAO;

public class TypeDAOImpl implements TypeDAO{

	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	@Override
	public String getname(Type getname) {
		
		return null;
	}

	@Override
	public int getnum(Type getnumber) {
		// TODO Auto-generated method stub
		return 0;
	}

}
