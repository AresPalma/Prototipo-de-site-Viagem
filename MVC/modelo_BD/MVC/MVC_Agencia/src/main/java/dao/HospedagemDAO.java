package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.Hospedagem;

public class HospedagemDAO {
	
	Connection conn = null;
	PreparedStatement pstm = null;

	//SALVE
	public void save(Hospedagem hospedagem) {
		
		String sql = "INSERT INTO hospedagem (nome_hospedagem, tel_hospedagem, cidade_estado,"
				+ " logradouro, preco_hospedagem ) values(?, ?, ?, ?, ?);";

		try {
			
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

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

	// READ
	public List<Hospedagem> getHospedagem() {
		String sql = "select * from hospedagem;";

		List<Hospedagem> hospedagens = new ArrayList<Hospedagem>();

		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Hospedagem hospedagem = new Hospedagem();

				hospedagem.setId(rset.getInt("id_hospedagem"));
				
				hospedagem.setNome(rset.getString("nome_hospedagem"));
				
				hospedagem.setTel(rset.getString("tel_hospedagem"));
				
				hospedagem.setCidadeEstado(rset.getString("cidade_estado"));
				
				hospedagem.setLogradouro(rset.getString("logradouro"));
				
				hospedagem.setPrecoHosped(rset.getDouble("preco_hospedagem"));

				hospedagens.add(hospedagem);
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
	
	// UPDATE
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

	// DELETAR
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
		Hospedagem hospedagem = new Hospedagem();

		ResultSet rset = null;

		try {
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			rset = pstm.executeQuery();

			rset.next();
			
			hospedagem.setId(rset.getInt("id_hospedagem"));	

			hospedagem.setNome(rset.getString("nome_hospedagem"));
			
			hospedagem.setTel(rset.getString("tel_hospedagem"));
			
			hospedagem.setCidadeEstado(rset.getString("cidade_estado"));
			
			hospedagem.setLogradouro(rset.getString("logradouro"));
						
			hospedagem.setPrecoHosped(rset.getDouble("preco_Hospedagem"));					
			
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
		return hospedagem;
	}
	
}
