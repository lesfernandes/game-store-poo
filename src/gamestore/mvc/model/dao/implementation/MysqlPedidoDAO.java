package gamestore.mvc.model.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import gamestore.mvc.model.dao.factories.MysqlFactory;
import gamestore.mvc.model.dao.interfaces.*;
import gamestore.mvc.model.pojo.Pedido;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MysqlPedidoDAO implements IPedidoDAO {

	@Override
	public Pedido get(Integer id) {
		Pedido pedido = null;

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

		return pedido;
	}

	@Override
	public ObservableList<Pedido> getAll() {
		ObservableList<Pedido> pedido = FXCollections.observableArrayList();

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

		return pedido;
	}

	@Override
	public boolean save(Pedido t) {
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
	public boolean update(Pedido t) {
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
	public boolean delete(Pedido t) {
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
