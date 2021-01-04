package gamestore.mvc.model.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.mysql.jdbc.Statement;

import gamestore.mvc.model.dao.factories.MysqlFactory;
import gamestore.mvc.model.dao.interfaces.IConsoleDAO;
import gamestore.mvc.model.pojo.Console;

public class MysqlConsoleDAO implements IConsoleDAO{

		@Override
	public Console get(Integer id) {
		Console console = null;

		try {
			Connection con = MysqlFactory.getConnection();

			String sql = "select * from produtos p inner join consoles c on c.produto_id = p.produto_id where c.console_id = ?;";

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				//Produto
				int produto_id = rs.getInt("produto_id");
				String descricao = rs.getString("descricao");
				String nome = rs.getString("nome");
				Float preco = rs.getFloat("preco");
				//Console
				int consoleId = rs.getInt("console_id");
				String tipoDrive = rs.getString("tipo_drive");
				String outrasInformacoes = rs.getString("outras_informacoes");

				console = new Console(produto_id, nome, descricao, preco, consoleId, tipoDrive,
						outrasInformacoes);
			}

			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return console;
	}

	@Override
	public List<Console> getAll() {
		List<Console> consoles = new LinkedList<Console>();

		try {
			Connection con = MysqlFactory.getConnection();

			String sql = "select * from produtos p inner join consoles c on c.produto_id = p.produto_id;";

			PreparedStatement pstmt = con.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				//Produto
				int produto_id = rs.getInt("produto_id");
				String descricao = rs.getString("descricao");
				String nome = rs.getString("nome");
				Float preco = rs.getFloat("preco");
				//Console
				int consoleId = rs.getInt("console_id");
				String tipoDrive = rs.getString("tipo_drive");
				String outrasInformacoes = rs.getString("outras_informacoes");

				Console console = new Console(produto_id, nome, descricao, preco, consoleId, tipoDrive,
						outrasInformacoes);
				consoles.add(console);
			}

			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return consoles;
	}

	@Override
	public boolean save(Console console) {
		boolean succesfull = false;
		Connection con = null;
		try {
			con = MysqlFactory.getConnection();
			con.setAutoCommit(false);

			String sql = "INSERT INTO `produtos` (`descricao`, `nome`, `preco`) ";
			sql += "VALUES (?, ?, ?);";

			PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, console.getDescricao());
			pstmt.setString(2, console.getNome());
			pstmt.setFloat(3, console.getPreco());
			pstmt.execute();

			ResultSet rs = pstmt.getGeneratedKeys();
			int produtoId = 0;
			while(rs.next()) {
				produtoId = rs.getInt(1);
			}

			sql = "INSERT INTO `consoles` (`tipo_drive`, `outras_informacoes`, `produto_id`) VALUES (?,?,?);";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, console.getTipoDrive());
			pstmt.setString(2, console.getOutrasInformacoes());
			pstmt.setInt(3, produtoId);
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
	public boolean update(Console t) {
		boolean succesfull = false;
		Connection con = null;

		try {
			con = MysqlFactory.getConnection();
			con.setAutoCommit(false);

			MysqlProdutoDAO produtoDao = new MysqlProdutoDAO();
			produtoDao.update(t);

			String sql = "UPDATE `consoles` SET `tipo_drive` = ?, `outras_informacoes` = ? WHERE (`console_id` = ?);";

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, t.getTipoDrive());
			pstmt.setString(2, t.getOutrasInformacoes());
			pstmt.setFloat(3, t.getConsoleId());

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
	public boolean delete(Console c) {
		MysqlProdutoDAO produtoDao = new MysqlProdutoDAO();
		return produtoDao.delete(c);
	}

}
