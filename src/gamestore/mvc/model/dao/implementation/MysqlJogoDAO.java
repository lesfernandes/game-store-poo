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
			
			String sql = "select * from produtos p inner join jogos j on j.produto_id = p.produto_id where j.jogo_id = ?;";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int produto_id = rs.getInt("produto_id"); 
				String descricao = rs.getString("descricao");
				String nome = rs.getString("nome");
				Float preco = rs.getFloat("preco");
				int  memoriaNecessaria = rs.getInt("memoria_necessaria");
				int numeroJogadores = rs.getInt("numero_de_jogadores");
				String outrasInformacoes = rs.getString("outras_informacoes");
				int jogoId = rs.getInt("jogo_id");
				
				jogo = new Jogo(produto_id, nome, descricao, preco, jogoId, memoriaNecessaria,
						numeroJogadores, outrasInformacoes);
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
		List<Jogo> jogos = new LinkedList<Jogo>();
		
		try {
			Connection con = MysqlFactory.getConnection();
			
			String sql = "select * from produtos p inner join jogos j on j.produto_id = p.produto_id;";
			
			PreparedStatement pstmt = con.prepareStatement(sql);	
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int produto_id = rs.getInt("produto_id"); 
				String descricao = rs.getString("descricao");
				String nome = rs.getString("nome");
				Float preco = rs.getFloat("preco");
				int  memoriaNecessaria = rs.getInt("memoria_necessaria");
				int numeroJogadores = rs.getInt("numero_de_jogadores");
				String outrasInformacoes = rs.getString("outras_informacoes");
				int jogoId = rs.getInt("jogo_id");
				
				Jogo jogo = new Jogo(produto_id, nome, descricao, preco, jogoId, memoriaNecessaria,
						numeroJogadores, outrasInformacoes);
				
				jogos.add(jogo);
			}
			
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jogos;
	}

	@Override
	public boolean save(Jogo j) {
		boolean succesfull = false;
		Connection con = null;
		try {
			con = MysqlFactory.getConnection();
			con.setAutoCommit(false);
			
			String sql = "INSERT INTO `produtos` (`descricao`, `nome`, `preco`) ";
			sql += "VALUES (?, ?, ?);";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, j.getDescricao());
			pstmt.setString(2, j.getNome());
			pstmt.setFloat(3, j.getPreco());
			pstmt.execute();
			
			ResultSet rs = pstmt.executeQuery();
			int produtoId = 0;
			while(rs.next()) {
				produtoId = rs.getInt(0);
			}
			
			sql = "INSERT INTO `jogos` (`memoria_necessaria`, `numero_de_jogadores`, `outras_informacoes`, `produto_id`) " + 
					"VALUES (?,?,?,?);";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, j.getMemoriaNecessaria());
			pstmt.setInt(2, j.getNumeroDeJogadores());
			pstmt.setString(3, j.getOutrasInformacoes());
			pstmt.setInt(4, produtoId);
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
	public boolean update(Jogo j) {
		boolean succesfull = false;
		Connection con = null;
		try {
			con = MysqlFactory.getConnection();
			con.setAutoCommit(false);
			
			MysqlProdutoDAO produtoDao = new MysqlProdutoDAO();
			produtoDao.update(j);
			
			String sql = "UPDATE `jogos` SET `memoria_necessaria` = ?, `numero_de_jogadores` = '?', `outras_informacoes` = ? WHERE (`jogo_id` = ?);";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, j.getMemoriaNecessaria());
			pstmt.setInt(2, j.getNumeroDeJogadores());
			pstmt.setString(3, j.getOutrasInformacoes());
			pstmt.setInt(4, j.getJogoId());
			
			succesfull = pstmt.execute();
			
			pstmt.close();
			
			con.commit();
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
	public boolean delete(Jogo j) {
		MysqlProdutoDAO produtoDao = new MysqlProdutoDAO();
		return produtoDao.delete(j);
	}
	
}
