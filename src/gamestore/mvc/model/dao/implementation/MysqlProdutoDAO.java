package gamestore.mvc.model.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import gamestore.mvc.model.dao.factories.MysqlFactory;
import gamestore.mvc.model.dao.interfaces.IProdutoDAO;
import gamestore.mvc.model.pojo.Produto;

public class MysqlProdutoDAO implements IProdutoDAO {

	@Override
	public Produto get(Integer id) {
		Produto produto = null;

		try {
			Connection con = MysqlFactory.getConnection();

			String sql = "select * from produtos where produto_id = ?;";

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int produto_id = rs.getInt("produto_id");
				String descricao = rs.getString("descricao");
				String nome = rs.getString("nome");
				Float preco = rs.getFloat("preco");

				produto = new Produto(produto_id, nome, descricao, preco);
			}

			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return produto;
	}

	@Override
	public List<Produto> getAll() {
		List<Produto> produtos = new LinkedList<Produto>();

		try {
			Connection con = MysqlFactory.getConnection();

			String sql = "SELECT * FROM produtos;";

			PreparedStatement pstmt = con.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int produto_id = rs.getInt("produto_id");
				String descricao = rs.getString("descricao");
				String nome = rs.getString("nome");
				Float preco = rs.getFloat("preco");

				Produto produto = new Produto(produto_id, nome, descricao, preco);
				produtos.add(produto);
			}

			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return produtos;
	}

	@Override
	public boolean save(Produto p) {
		boolean succesfull = false;

		try {
			Connection con = MysqlFactory.getConnection();

			String sql = "INSERT INTO `produtos` (`descricao`, `nome`, `preco`) ";
			sql += "VALUES (?, ?, ?);";

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, p.getDescricao());
			pstmt.setString(2, p.getNome());
			pstmt.setFloat(3, p.getPreco());

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

			String sql = "update produtos " + "set descricao = ?, nome = ?, preco = '?' " + "where produto_id = '1';";

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, t.getDescricao());
			pstmt.setString(1, t.getNome());
			pstmt.setFloat(1, t.getPreco());
			pstmt.setInt(1, t.getProdutoId());

			succesfull = pstmt.execute();

			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return succesfull;
	}

	@Override
	public boolean delete(Produto p) {
		boolean succesfull = false;

		try {
			Connection con = MysqlFactory.getConnection();

			String sql = "delete from produtos where produto_id = ?;";

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, p.getProdutoId());

			succesfull = pstmt.execute();

			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return succesfull;
	}

}
