package gamestore.mvc.model.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

import gamestore.mvc.model.dao.factories.MysqlFactory;
import gamestore.mvc.model.dao.interfaces.IPedidoDAO;
import gamestore.mvc.model.pojo.Cliente;
import gamestore.mvc.model.pojo.Pedido;
import gamestore.mvc.model.pojo.Produto;

public class MysqlPedidoDAO implements IPedidoDAO {

	@Override
	public Pedido get(Integer id) {
		Pedido pedido = null;
		try {
			Connection con = MysqlFactory.getConnection();


			String sql = "select * from pedidos "
					+ " inner join produtos on pedidos.produto_id = produtos.produto_id "
					+ " inner join clientes on clientes.cliente_id = pedidos.cliente_id "
					+ " where pedidos.pedido_id = ?;";

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);


			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				//Pedido
				int pedidoId = rs.getInt("pedido_id");
				LocalDate data = rs.getDate("data").toLocalDate();
				String outrasInformacoesProduto = rs.getString("outras_informacoes");

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

				pedido = new Pedido(pedidoId, data, outrasInformacoesProduto, produto, cliente);
			}

			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pedido;
	}

	@Override

	public List<Pedido> getAll() {
		List<Pedido> pedidos = new LinkedList<Pedido>();

		try {
			Connection con = MysqlFactory.getConnection();

			String sql = "select pe.pedido_id, pe.data, pe.outras_informacoes, pe.produto_id, pe.cliente_id, p.descricao, p.nome as nomeP, p.preco, cli.codigo, cli.nome as nomeCli, cli.endereco, cli.outras_informacaoes from pedidos pe inner join produtos p on pe.produto_id = p.produto_id inner join clientes cli on cli.cliente_id = pe.cliente_id;";
			PreparedStatement pstmt = con.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				//Pedido
				int pedidoId = rs.getInt("pedido_id");
				LocalDate data = rs.getDate("data").toLocalDate();
				String outrasInformacoesProduto = rs.getString("outras_informacoes");

				//Cliente
				int clienteId = rs.getInt("cliente_id");
				int codigo = rs.getInt("codigo");
				String nomeCliente = rs.getString("nomeCli");
				String endereco = rs.getString("endereco");
				String outrasInformacoesCliente = rs.getString("outras_informacaoes");

				Cliente cliente = new Cliente(clienteId, codigo, nomeCliente, endereco, outrasInformacoesCliente);

				//Produto
				int produto_id = rs.getInt("produto_id");
				String descricao = rs.getString("descricao");
				String nomeProduto = rs.getString("nomeP");
				Float preco = rs.getFloat("preco");

				Produto produto = new Produto(produto_id, nomeProduto, descricao, preco);

				Pedido pedido = new Pedido(pedidoId, data, outrasInformacoesProduto, produto, cliente);
				pedidos.add(pedido);
			}

			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pedidos;

	}

	@Override
	public boolean save(Pedido t) {
		boolean succesfull = false;

		try {
			Connection con = MysqlFactory.getConnection();

			String sql = "INSERT INTO `pedidos` (`data`, `outras_informacoes`, `produto_id`, `cliente_id`) VALUES (?,?,?,?);";

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
	public boolean update(Pedido t) {
		boolean succesfull = false;

		try {
			Connection con = MysqlFactory.getConnection();

			String sql = "UPDATE `pedidos` SET `data` = ?, `outras_informacoes` = ?, `produto_id` = ?, `cliente_id` = ? WHERE `pedido_id` = ?;";

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setDate(1, Date.valueOf(t.getData()));
			pstmt.setString(2, t.getOutrasInformacoes());
			pstmt.setInt(3, t.getProduto().getProdutoId());
			pstmt.setInt(4, t.getCliente().getClienteId());
			pstmt.setInt(5, t.getPedidoId());

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

			String sql = "DELETE FROM `pedidos` WHERE (`pedido_id` = ?);";

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, t.getPedidoId());

			succesfull = pstmt.execute();

			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return succesfull;
	}



}
