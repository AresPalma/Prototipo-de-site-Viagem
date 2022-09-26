package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelo.Hospedagem;

public class HospedagemDAO {
	
	Connection conn = null;
	PreparedStatement pstm = null;

	// Metodo pra salvar
	public void save(Hospedagem hospedagem) {
		String sql = "INSERT INTO hospedagem (nome_hospedagem, tel_hospedagem, cidade_estado,"
				+ " logradouro, preco_hospedagem ) values(?, ?, ?, ?, ?);";

		try {
			// Cria uma conexão com o banco
			conn = ConnectionMySQL.createConnectionMySQL();

			// Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adicionar o valor dos parametros da sql
			pstm.setString(1, hospedagem.getNome());
			
			pstm.setString(2, hospedagem.getTel());
			
			pstm.setString(3, hospedagem.getCidadeEstado());
			
			pstm.setString(4, hospedagem.getLogradouro());
			
			pstm.setDouble(5, hospedagem.getPrecoHosped());

			// Executar a sql para inserção dos dados
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

	// Metodo para READ
	public List<Hospedagem> getHospedagem() {
		String sql = "select * from hospedagem;";

		List<Hospedagem> hospedagens = new ArrayList<Hospedagem>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Hospedagem hosped = new Hospedagem();

				hosped.setId(rset.getInt("id_hospedagem"));
				
				hosped.setNome(rset.getString("nome_hospedagem"));
				
				hosped.setTel(rset.getString("tel_hospedagem"));
				
				hosped.setCidadeEstado(rset.getString("cidade_estado"));
				
				hosped.setLogradouro(rset.getString("logradouro"));
				
				hosped.setPrecoHosped(rset.getDouble("preco_hospedagem"));

				hospedagens.add(hosped);
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

		return hospedagens;
	}
	
	// Metodo pra UPDATE
	public void update(Hospedagem hospedagem) {
		String sql = "UPDATE hospedagem set nome_hospedagem = ?, tel_hospedagem = ?,cidade_estado = ?"
				+ ",logradouro= ?, preco_hospedagem = ? WHERE id_hospedagem = ?;";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, hospedagem.getNome());
			
			pstm.setString(2, hospedagem.getTel());
			
			pstm.setString(3, hospedagem.getCidadeEstado());
			
			pstm.setString(4, hospedagem.getLogradouro());
			
			pstm.setDouble(5, hospedagem.getPrecoHosped());
			
			pstm.setInt(6, hospedagem.getId());
			
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
		String sql = "DELETE FROM hospedagem WHERE id_hospedagem = ?";

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
	public Hospedagem getHospedagemById(int id) {
		
		String sql = "SELECT * FROM hospedagem where id_hospedagem = ?";
		Hospedagem hospedagens = new Hospedagem();

		ResultSet rset = null;

		try {
			
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			rset.next();
			
			hospedagens.setId(rset.getInt("id_hospedagem"));	

			hospedagens.setNome(rset.getString("nome_hospedagem"));
			
			hospedagens.setTel(rset.getString("tel_hospedagem"));
			
			hospedagens.setCidadeEstado(rset.getString("cidade_estado"));
			
			hospedagens.setLogradouro(rset.getString("logradouro"));
						
			hospedagens.setPrecoHosped(rset.getDouble("preco_Hospedagem"));					
			
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
		return hospedagens;
	}
	
}
