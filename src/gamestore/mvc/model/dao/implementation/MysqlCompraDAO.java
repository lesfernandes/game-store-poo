package gamestore.mvc.model.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import gamestore.mvc.model.dao.factories.MysqlFactory;
import gamestore.mvc.model.dao.interfaces.ICompraDAO;
import gamestore.mvc.model.pojo.Compra;

public class MysqlCompraDAO implements ICompraDAO {

	@Override
	public Compra get(Integer id) {
		Compra compra = null;
		try {
			Connection con = MysqlFactory.getConnection();
			
			String sql = "";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			// pstmt.setString(1, value);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				//rs.getInt(columnIndex)
				// initialize Object
			}
			
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return compra;
	}

	@Override
	public List<Compra> getAll() {
		List<Compra> acessorio = new LinkedList<Compra>();
		
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
		
		return acessorio;
	}

	@Override
	public boolean save(Compra t) {
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

	@Override
	public boolean update(Compra t) {
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

	@Override
	public boolean delete(Compra t) {
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
