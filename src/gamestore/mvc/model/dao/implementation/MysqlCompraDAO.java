package gamestore.mvc.model.dao.implementation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import gamestore.mvc.model.dao.factories.MysqlFactory;
import gamestore.mvc.model.dao.interfaces.ICompraDAO;
import gamestore.mvc.model.pojo.Cliente;
import gamestore.mvc.model.pojo.Compra;
import gamestore.mvc.model.pojo.Produto;

public class MysqlCompraDAO implements ICompraDAO {

	@Override
	public Compra get(Integer id) {
		Compra compra = null;
		try {
			Connection con = MysqlFactory.getConnection();


			String sql = "select * from compras inner join produtos on compras.produto_id = produtos.produto_id inner join clientes on clientes.cliente_id = compras.cliente_id where compras.compra_id = ?;";

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);


			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				//Compra
				int compraId = rs.getInt("compra_id");
				LocalDate data = rs.getDate("data").toLocalDate();
				String outrasInformacoesCompra = rs.getString("outras_informacoes");

				//Cliente
				int clienteId = rs.getInt("cliente_id");
				int codigo = rs.getInt("codigo");
				String nomeCliente = rs.getString("nome");
				String endereco = rs.getString("endereco");
				String outrasInformacoesCliente = rs.getString("outras_informacaoes");

				Cliente cliente = new Cliente(clienteId, codigo, nomeCliente, endereco, outrasInformacoesCliente);

				//Produto
				int produto_id = rs.getInt("produto_id");
				String descricao = rs.getString("descricao");
				String nomeProduto = rs.getString("nome");
				Float preco = rs.getFloat("preco");

				Produto produto = new Produto(produto_id, nomeProduto, descricao, preco);

				compra = new Compra(compraId ,data, outrasInformacoesCompra, produto, cliente);
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
		List<Compra> compras = new LinkedList<Compra>();

		try {
			Connection con = MysqlFactory.getConnection();

			String sql = "select * from compras inner join produtos on compras.produto_id = produtos.produto_id inner join clientes on clientes.cliente_id = compras.cliente_id;";
			PreparedStatement pstmt = con.prepareStatement(sql);

			// pstmt.setString(1, value);

			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				//Compra
				int compraId = rs.getInt("compra_id");
				LocalDate data = rs.getDate("data").toLocalDate();
				String outrasInformacoesCompra = rs.getString("outras_informacoes");

				//Cliente
				int clienteId = rs.getInt("cliente_id");
				int codigo = rs.getInt("codigo");
				String nomeCliente = rs.getString("nome");
				String endereco = rs.getString("endereco");
				String outrasInformacoesCliente = rs.getString("outras_informacaoes");

				Cliente cliente = new Cliente(clienteId, codigo, nomeCliente, endereco, outrasInformacoesCliente);

				//Produto
				int produto_id = rs.getInt("produto_id");
				String descricao = rs.getString("descricao");
				String nomeProduto = rs.getString("nome");
				Float preco = rs.getFloat("preco");

				Produto produto = new Produto(produto_id, nomeProduto, descricao, preco);

				Compra compra = new Compra(compraId, data, outrasInformacoesCompra, produto, cliente);
				compras.add(compra);
			}

			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return compras;

	}

	@Override
	public boolean save(Compra t) {
		boolean succesfull = false;

		try {
			Connection con = MysqlFactory.getConnection();

			String sql = "INSERT INTO `compras` (`data`, `outras_informacoes`, `produto_id`, `cliente_id`) VALUES (?,?,?,?);";

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setDate(1, Date.valueOf(t.getData()));
			pstmt.setString(2, t.getOutrasInformacoes());
			pstmt.setInt(3, t.getProduto().getProdutoId());
			pstmt.setInt(4, t.getCliente().getClienteId());

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

			String sql = "UPDATE `compras` SET `data` = ?, `outras_informacoes` = ?, `produto_id` = ?, `cliente_id` = ? WHERE `compra_id` = ?;";

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setDate(1, Date.valueOf(t.getData()));
			pstmt.setString(2, t.getOutrasInformacoes());
			pstmt.setInt(3, t.getProduto().getProdutoId());
			pstmt.setInt(4, t.getCliente().getClienteId());
			pstmt.setInt(5, t.getCompraId());

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
		System.out.println(t.getCompraId());
		boolean succesfull = false;

		try {
			Connection con = MysqlFactory.getConnection();

			String sql = "DELETE FROM `compras` WHERE (`compra_id` = ?);";

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, t.getCompraId());

			succesfull = pstmt.execute();

			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return succesfull;
	}



}
