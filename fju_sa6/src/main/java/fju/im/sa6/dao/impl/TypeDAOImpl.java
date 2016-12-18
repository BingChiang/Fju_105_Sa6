package fju.im.sa6.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;
import fju.im.sa6.entity.Type;
import fju.im.sa6.dao.TypeDAO;

//using by typeList to do something , notice!!
public class TypeDAOImpl implements TypeDAO {

	private DataSource dataSource;
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement smt = null;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public Type getType(Type searchType) {

		Type typ = null;
		String sql = "SELECT * FROM type WHERE type_num = ?";
		try {

			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, searchType.getTypeNum());
			rs = smt.executeQuery();
			while (rs.next()) {
				int settypeNum = (rs.getInt("type_num"));
				String settypeName = (rs.getString("type_name"));
				int setavailabetype = (rs.getInt("available_type"));
				typ = new Type(settypeName, settypeNum, setavailabetype);
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
		return typ;
	}

	@Override
	public void add(Type addType) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO type (type_name,available_type) VALUES(?,?)";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, addType.getTypeName());
			smt.setInt(2, addType.getAvailabletype());
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
	public void set(Type setType) {
		// TODO Auto-generated method stub
		String sql = "UPDATE type set type_name=? WHERE type_num =?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, setType.getTypeName());
			smt.setInt(2, setType.getTypeNum());
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
	public void remove(Type removeType){
		System.out.println(removeType.getTypeNum());

		String sql = "UPDATE type set available_type = 1 WHERE type_num=?";
		try{
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, removeType.getTypeNum());
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
	public ArrayList<Type> getList() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM type WHERE available_type = 0";
		ArrayList<Type>typ= new ArrayList<Type>();
		try {

			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()) {
				int setTypenum = (rs.getInt("type_num"));
				String setTypename = (rs.getString("type_name"));
				int setavailabletype = (rs.getInt("available_type"));
				typ.add(new Type(setTypename, setTypenum,setavailabletype));
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
		return typ;
	}
}