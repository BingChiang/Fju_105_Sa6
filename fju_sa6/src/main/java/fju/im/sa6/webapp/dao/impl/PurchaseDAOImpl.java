package fju.im.sa6.webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import fju.im.sa6.entity.Purchase;
import fju.im.sa6.webapp.dao.PurchaseDAO;

public class PurchaseDAOImpl implements PurchaseDAO{

	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void add(Purchase addPur) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void set(Purchase setPur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Purchase removePur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Purchase> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Purchase get(Purchase getPur) {
		// TODO Auto-generated method stub
		return null;
	}

}
