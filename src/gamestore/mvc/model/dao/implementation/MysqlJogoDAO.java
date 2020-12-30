package gamestore.mvc.model.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import gamestore.mvc.model.dao.factories.MysqlFactory;
import gamestore.mvc.model.dao.interfaces.IJogoDAO;
import gamestore.mvc.model.pojo.Jogo;

public class MysqlJogoDAO implements IJogoDAO{

	@Override
	public Jogo get(Integer id) {
		Jogo jogo = null;
		try {
			Connection con = MysqlFactory.getConnection();
			
			String sql = "";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			// pstmt.setString(1, value);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				//rs.getInt(columnIndex)
			}
			
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jogo;
	}

	@Override
	public List<Jogo> getAll() {
		List<Jogo> jogo = new LinkedList<Jogo>();
		
		try {
			Connection con = MysqlFactory.getConnection();
			
			String sql = "";
			
			PreparedStatement pstmt = con.prepareStatement(sql);	
			// pstmt.setString(1, value);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				//rs.getInt(columnIndex)
			}
			
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jogo;
	}

	@Override
	public boolean save(Jogo t) {
		boolean succesfull = false;
		
		try {
			Connection con = MysqlFactory.getConnection();
			con.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
			
			String sql = "";
			
			PreparedStatement pstmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			// pstmt.setString(1, value);
			
			pstmt.execute();
			
			 ResultSet rs = pstmt.getGeneratedKeys();
			 int id;
			 if(rs.next()){
	            id = rs.getInt(1);
	        }
			
			sql = "";
			
			pstmt = con.prepareStatement(sql);
			// pstmt.setString(1, value);
			succesfull = pstmt.execute();
			
			pstmt.close();
			
			con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return succesfull;
	}

	@Override
	public boolean update(Jogo t) {
		boolean succesfull = false;
		
		try {
			Connection con = MysqlFactory.getConnection();
			con.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
			
			String sql = "";
			
			PreparedStatement pstmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			// pstmt.setString(1, value);
			
			pstmt.execute();
			
			 ResultSet rs = pstmt.getGeneratedKeys();
			 int id;
			 if(rs.next()){
	            id = rs.getInt(1);
	        }
			
			sql = "";
			
			pstmt = con.prepareStatement(sql);
			// pstmt.setString(1, value);
			succesfull = pstmt.execute();
			
			pstmt.close();
			
			con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return succesfull;
	}

	@Override
	public boolean delete(Jogo t) {
		boolean succesfull = false;
		
		try {
			Connection con = MysqlFactory.getConnection();
			
			String sql = "";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			// pstmt.setString(1, value);
			
			succesfull = pstmt.execute();
			
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return succesfull;
	}

	
}
