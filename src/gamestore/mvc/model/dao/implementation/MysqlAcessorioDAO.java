package gamestore.mvc.model.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.mysql.jdbc.Statement;

import gamestore.mvc.model.dao.factories.MysqlFactory;
import gamestore.mvc.model.dao.interfaces.IAcessorioDAO;
import gamestore.mvc.model.pojo.Acessorio;

public class MysqlAcessorioDAO implements IAcessorioDAO{

		@Override
	public Acessorio get(Integer id) {
		Acessorio acessorio = null;

		try {
			Connection con = MysqlFactory.getConnection();

			String sql = "select * from produtos p inner join acessorios a on a.produto_id = p.produto_id where a.acessorio_id = ?;";

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				//Produto
				int produto_id = rs.getInt("produto_id");
				String descricao = rs.getString("descricao");
				String nome = rs.getString("nome");
				Float preco = rs.getFloat("preco");
				//Acessorio
				int acessorioId = rs.getInt("acessorio_id");
				String outrasInformacoes = rs.getString("outras_informacoes");

				acessorio = new Acessorio(produto_id, nome, descricao, preco, acessorioId,
						outrasInformacoes);
			}

			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return acessorio;
	}

	@Override
	public List<Acessorio> getAll() {
		List<Acessorio> acessorios = new LinkedList<Acessorio>();

		try {
			Connection con = MysqlFactory.getConnection();

			String sql = "select * from produtos p inner join acessorios a on a.produto_id = p.produto_id;";

			PreparedStatement pstmt = con.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				//Produto
				int produto_id = rs.getInt("produto_id");
				String descricao = rs.getString("descricao");
				String nome = rs.getString("nome");
				Float preco = rs.getFloat("preco");
				//Console
				int acessorioId = rs.getInt("acessorio_id");
				String outrasInformacoes = rs.getString("outras_informacoes");

				Acessorio acessorio = new Acessorio(produto_id, nome, descricao, preco, acessorioId,
						outrasInformacoes);

				acessorios.add(acessorio);
			}

			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return acessorios;
	}

	@Override
	public boolean save(Acessorio acessorio) {
		boolean succesfull = false;
		Connection con = null;
		try {
			con = MysqlFactory.getConnection();
			con.setAutoCommit(false);

			String sql = "INSERT INTO `produtos` (`descricao`, `nome`, `preco`) ";
			sql += "VALUES (?, ?, ?);";

			PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, acessorio.getDescricao());
			pstmt.setString(2, acessorio.getNome());
			pstmt.setFloat(3, acessorio.getPreco());
			pstmt.execute();

			ResultSet rs = pstmt.getGeneratedKeys();
			int produtoId = 0;
			while(rs.next()) {
				produtoId = rs.getInt(1);
			}

			sql = "INSERT INTO `acessorios` (`outras_informacoes`, `produto_id`) VALUES (?, ?);";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, acessorio.getOutrasInformacoes());
			pstmt.setInt(2, produtoId);
			succesfull = pstmt.execute();

			con.commit();

			pstmt.close();
		} catch (SQLException e) {
			if(con != null) {
				try {
					con.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

			e.printStackTrace();
		}finally {
			if(con != null) {
				try {
					con.setAutoCommit(true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return succesfull;
	}

	@Override
	public boolean update(Acessorio t) {
		boolean succesfull = false;
		Connection con = null;

		try {
			con = MysqlFactory.getConnection();
			con.setAutoCommit(false);

			MysqlProdutoDAO produtoDao = new MysqlProdutoDAO();
			produtoDao.update(t);

			String sql = "UPDATE `acessorios` SET `outras_informacoes` = '?' WHERE (`acessorio_id` = ?);";

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, t.getOutrasInformacoes());
			pstmt.setFloat(2, t.getAcessorioId());

			succesfull = pstmt.execute();

			pstmt.close();
		} catch (SQLException e) {
			if(con != null) {
				try {
					con.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

			e.printStackTrace();
		}finally {
			if(con != null) {
				try {
					con.setAutoCommit(true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return succesfull;
	}

	@Override
	public boolean delete(Acessorio c) {
		MysqlProdutoDAO produtoDao = new MysqlProdutoDAO();
		return produtoDao.delete(c);
	}

}
