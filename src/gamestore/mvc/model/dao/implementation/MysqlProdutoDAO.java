package gamestore.mvc.model.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import gamestore.mvc.model.dao.factories.MysqlFactory;
import gamestore.mvc.model.dao.interfaces.IProdutoDAO;
import gamestore.mvc.model.pojo.Console;
import gamestore.mvc.model.pojo.Produto;

public class MysqlProdutoDAO implements IProdutoDAO{

	@Override
	public Console get(Integer id) {
		Console console = null;
		
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
		
		return console;
	}

	@Override
	public List<Produto> getAll() {
		List<Produto> produto = new LinkedList<Produto>();
		
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
		
		return produto;
	}

	@Override
	public boolean save(Produto t) {
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
	public boolean update(Produto t) {
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
	public boolean delete(Produto t) {
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
