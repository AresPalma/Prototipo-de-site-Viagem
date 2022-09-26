package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelo.Companhias;
import modelo.Destino;

public class DestinoDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	// Metodo pra salvar
	public void save(Destino destino) {
		String sql = "INSERT INTO destino ( tipo_destino, origem_destino,"
				+ "nome_destino, preco_destino, id_companhia) values(?, ?, ?, ?, ?);";
		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, destino.getTipoDestino());
			
			pstm.setString(2, destino.getOrigem());
			
			pstm.setString(3, destino.getNome());
			
			pstm.setDouble(4, destino.getPrecoDestino());
			
			pstm.setInt(5, destino.getCompanhias().getId());

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
	public List<Destino> getDestino() {
		String sql = "select * from destino;";

		List<Destino> destinos = new ArrayList<Destino>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Destino dest = new Destino();
				Companhias companhia = new Companhias();

				dest.setId(rset.getInt("id_destino"));
				
				dest.setTipoDestino(rset.getString("Tipo_destino"));
				
				dest.setOrigem(rset.getString("origem_destino"));
				
				dest.setNome(rset.getString("nome_destino"));
				
				dest.setPrecoDestino(rset.getDouble("preco_destino"));
				
				companhia.setId(rset.getInt("id_companhia"));
				
				companhia.setNome(rset.getString("nome_companhia"));
				
				dest.setCompanhias(companhia);

				destinos.add(dest);
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

		return destinos;
	}

	// Metodo pra atualizar

	public void update(Destino destino) {

		String sql = "UPDATE destino set tipo_destino = ?, origem_destino = ?, nome_destino = ?,"
				+ " preco_destino = ?, id_companhia = ? ;" + " WHERE id = ?";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, destino.getTipoDestino());
			
			pstm.setString(2, destino.getOrigem());
			
			pstm.setString(3, destino.getNome());
		
			pstm.setDouble(5, destino.getPrecoDestino());
			
			pstm.setInt(6, destino.getCompanhias().getId());
			
			pstm.setInt(7, destino.getId());
			
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
		
		String sql = "DELETE FROM destino WHERE id_destino = ?";

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
	public Destino getDestinoById(int id) { 

		String sql = "SELECT * FROM destino where id_destino = ?;";
		
		Destino destinos = new Destino();
		Companhias companhias = new Companhias();

		ResultSet rset = null;

		try {
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			rset = pstm.executeQuery();

			rset.next();
			
			destinos.setId(rset.getInt("id_destino"));
			
			destinos.setTipoDestino(rset.getString("Tipo_destino"));
			
			destinos.setOrigem(rset.getString("origem_destino"));
			
			destinos.setNome(rset.getString("nome_destino"));
			
			destinos.setPrecoDestino(rset.getDouble("preco_destino"));
			
			companhias.setId(rset.getInt("id_companhia"));
			
			companhias.setNome(rset.getString("nome_companhia"));			
						
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
		return destinos;
	}

	
}
