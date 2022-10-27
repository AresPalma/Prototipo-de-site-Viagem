package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import connection.ConnectionMySQL;
import model.Companhias;

public class CompanhiasDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	// Metodo pra salvar
	public void save(Companhias companhia) {
		String sql = "INSERT INTO companhias (nome_companhia) values(?);";

		try {
		
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, companhia.getNome());
			
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// Metodo para Ler
	public List<Companhias> getCompanhias() {
		String sql = "select * from companhias;";

		List<Companhias> companhias = new ArrayList<Companhias>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Companhias companhia1 = new Companhias();

				companhia1.setId(rset.getInt("id_companhia"));

				companhia1.setNome(rset.getString("nome_companhia"));

				companhias.add(companhia1);

			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return companhias;
	}

	// Metodo pra atualizar
	public void update(Companhias companhia) {
		String sql = "UPDATE companhias set id_companhia = ? where nome_companhia = ?;";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, companhia.getId());

			pstm.setString(2, companhia.getNome());

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// Metodo para deletar
	public void deleteById(int id) {
		String sql = "DELETE FROM companhias WHERE id_companhia = ?";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public Companhias getCopmpanhiasById(int id_companhia) {

		String sql = "SELECT * FROM permissoes where id = ?";

		Companhias companhias = new Companhias();

		ResultSet rset = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id_companhia);

			rset = pstm.executeQuery();

			rset.next();

			companhias.setId(rset.getInt("id_companhia"));

			companhias.setNome(rset.getString("Nome_companhia"));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return companhias;
	}
}
