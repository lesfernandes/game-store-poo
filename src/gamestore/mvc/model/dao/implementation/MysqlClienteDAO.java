package gamestore.mvc.model.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import gamestore.mvc.model.dao.factories.MysqlFactory;
import gamestore.mvc.model.dao.interfaces.IClienteDAO;
import gamestore.mvc.model.pojo.Cliente;

public class MysqlClienteDAO implements IClienteDAO{

	@Override
	public Cliente get(Integer id) {
		Cliente cliente = null;
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
		
		return cliente;
	}

	@Override
	public List<Cliente> getAll() {
		List<Cliente> cliente = new LinkedList<Cliente>();
		
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
		
		return cliente;
	}

	@Override
	public boolean save(Cliente t) {
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
	public boolean update(Cliente t) {
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
	public boolean delete(Cliente t) {
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
