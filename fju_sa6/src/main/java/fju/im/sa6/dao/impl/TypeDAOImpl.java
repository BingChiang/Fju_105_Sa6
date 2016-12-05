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
			if (rs.next()) {
				int settypeNum = (rs.getInt("type_num"));
				String settypeName = (rs.getString("type_name"));
				typ = new Type(settypeName, settypeNum);
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
		String sql = "INSERT INTO Type (type_num, type_name ) VALUES(?, ?)";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, addType.getTypeNum());
			smt.setString(2, addType.getTypeName());
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
		String sql = "UPDATE Type set type_name=?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, setType.getTypeName());
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
	public ArrayList<Type> getList(Type Type) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM type WHERE type_num";
		Type typ = null;
		try {

			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, Type.getTypeNum());
			rs = smt.executeQuery();
			if (rs.next()) {
				int setTypenum = (rs.getInt("type_num"));
				String setTypename = (rs.getString("type_name"));
				typ = new Type(setTypename, setTypenum);
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
		return getList(typ);
	}
}