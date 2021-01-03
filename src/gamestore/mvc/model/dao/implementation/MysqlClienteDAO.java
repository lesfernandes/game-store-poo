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

			String sql = "select * from clientes where cliente_id = ?;";

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int clienteId = rs.getInt("cliente_id");
				int codigo = rs.getInt("codigo");
				String nome = rs.getString("nome");
				String endereco = rs.getString("endereco");
				String outrasInformacoes = rs.getString("outras_informacaoes");

				cliente = new Cliente(clienteId, codigo, nome, endereco, outrasInformacoes);
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
		List<Cliente> clientes = new LinkedList<Cliente>();

		try {
			Connection con = MysqlFactory.getConnection();

			String sql = "select * from clientes;";

			PreparedStatement pstmt = con.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int clienteId = rs.getInt("cliente_id");
				int codigo = rs.getInt("codigo");
				String nome = rs.getString("nome");
				String endereco = rs.getString("endereco");
				String outrasInformacoes = rs.getString("outras_informacaoes");

				Cliente cliente = new Cliente(clienteId, codigo, nome, endereco, outrasInformacoes);
				clientes.add(cliente);
			}

			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return clientes;
	}

	@Override
	public boolean save(Cliente t) {
		boolean succesfull = false;

		try {
			Connection con = MysqlFactory.getConnection();

			String sql = "INSERT INTO `clientes` (`codigo`, `nome`, `endereco`, `outras_informacaoes`) VALUES (?, ?, ?, ?);";

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, t.getCodigo());
			pstmt.setString(1, t.getNome());
			pstmt.setString(1, t.getEndereco());
			pstmt.setString(1, t.getOutrasInformacoes());

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

			String sql = "UPDATE `clientes` SET `codigo` = ?, `nome` = ?, `endereco` = ?, `outras_informacaoes` = ? WHERE (`cliente_id = ?);";

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, t.getCodigo());
			pstmt.setString(2, t.getNome());
			pstmt.setString(3, t.getEndereco());
			pstmt.setString(4, t.getOutrasInformacoes());
			pstmt.setInt(5, t.getClienteId());

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

			String sql = "DELETE FROM `clientes` WHERE (`cliente_id` = ?);";

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, t.getClienteId());

			succesfull = pstmt.execute();

			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return succesfull;
	}


}
