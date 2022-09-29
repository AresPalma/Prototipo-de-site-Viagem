package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelo.Destino;
import modelo.Hospedagem;
import modelo.Passagem;
import modelo.Usuarios;

public class PassagemDAO {
	
	Connection conn = null;
	PreparedStatement pstm = null;

	// Metodo pra salvar
	public void save(Passagem passagem) {
		String sql = "INSERT INTO passagem (tipo_pacote, data_embarque, data_retorno,"
				+ "  Qtd_dias, preco_compra, id_usuario, id_destino, id_hospedagem)values(?, ?, ?, ?, ?, ?, ?, ?;";

		try {
			// Cria uma conexão com o banco
			conn = ConnectionMySQL.createConnectionMySQL();

			// Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, passagem.getTipoPacote());		

			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

			pstm.setDate(2, new Date(formatter.parse(passagem.getDataEmbarque()).getTime()));
			pstm.setDate(3, new Date(formatter.parse(passagem.getDataRetorno()).getTime()));
			
			pstm.setInt(5, passagem.getQtd_dias());
			
			pstm.setDouble(6, passagem.getPrecoCompra());

			pstm.setInt(7, passagem.getUsuarios().getId());

			pstm.setInt(8, passagem.getDestino().getId());

			pstm.setInt(9, passagem.getHospedagem().getId());

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

	// Metodo para Resd
	public List<Passagem> getPassagem() {
		String sql = "select * from passagem;";

		List<Passagem> passagem = new ArrayList<Passagem>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				
				Passagem passagens = new Passagem();
				Usuarios usuarios = new Usuarios();
				Destino destino = new Destino();
				Hospedagem hospedagem = new Hospedagem();

				passagens.setId(rset.getInt("id_passagem"));
				
				passagens.setTipoPacote(rset.getString("tipo_pacote"));			

				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				
				passagens.setDataEmbarque(dateFormat.format(rset.getDate("data_embarque")));
				passagens.setDataRetorno(dateFormat.format(rset.getDate("data_retorno")));
				
				passagens.setQtd_dias(rset.getInt("Qtd_dias"));			

				passagens.setPrecoCompra(rset.getDouble("precoCompra"));

				usuarios.setId(rset.getInt("id_usuario"));

				usuarios.setNome(rset.getString("nome_usuario"));

				passagens.setUsuarios(usuarios);

				destino.setId(rset.getInt("id_destino"));

				destino.setNome(rset.getString("nome_destino"));

				passagens.setDestino(destino);		
							
				hospedagem.setId(rset.getInt("id_hospedagem"));

				hospedagem.setNome(rset.getString("nome_hospedagem"));

				passagens.setHospedagem(hospedagem);

				passagem.add(passagens);
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

		return passagem;
	}
	
	// Metodo pra UPDATE
	public void update(Passagem passag) {
		String sql = "UPDATE passagem SET tipo_pacote = ?,data_embarque = ?,"
				+ "data_retorno = ?,Qtd_dias = ?, preco_compra = ?, id_usuario = ?, id_destino = ?id_hospedagem =? WHERE id_passagem = ?";

		try {
								
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);			
			
			pstm.setString(1, passag.getTipoPacote());
				
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

			pstm.setDate(3, new Date(formatter.parse(passag.getDataEmbarque()).getTime()));

			pstm.setDate(4, new Date(formatter.parse(passag.getDataRetorno()).getTime()));
			
			pstm.setInt(1, passag.getQtd_dias());

			pstm.setDouble(2, passag.getPrecoCompra());			
			
			pstm.setInt(5, passag.getUsuarios().getId());

			pstm.setInt(6, passag.getDestino().getId());

			pstm.setInt(7, passag.getHospedagem().getId());

			pstm.setInt(8, passag.getId());

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
		String sql = "DELETE FROM passagem  WHERE id_passagem = ?";

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

	public Passagem getPassagemById(int id) {
		String sql = "select * from passagem_completo WHERE id_passagem = ?;";

		Passagem passagem = new Passagem();
		Usuarios user = new Usuarios();
		Destino destino= new Destino();
		Hospedagem hosped = new Hospedagem();

		ResultSet rset = null;

		try {
			
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			rset = pstm.executeQuery();

			rset.next();

			passagem.setId(rset.getInt("id_passagem"));

			passagem.setTipoPacote(rset.getString("tipo_pacote"));		
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			
			passagem.setDataEmbarque(dateFormat.format(rset.getDate("data_embarque")));
			
			passagem.setDataRetorno(dateFormat.format(rset.getDate("data_embarque")));

			passagem.setQtd_dias(rset.getInt("Qtd_dias"));
			
			passagem.setPrecoCompra(rset.getDouble("preco_compra"));
			
			user.setId(rset.getInt("id_usuario"));

			user.setNome(rset.getString("nome_Usuario"));

			passagem.setUsuarios(user);

			destino.setId(rset.getInt("id_destino"));

			destino.setNome(rset.getString("nome_destino"));

			passagem.setDestino(destino);
			
			hosped.setId(rset.getInt("id_hospedagem"));

			destino.setNome(rset.getString("nome_hospedagem"));

			passagem.setHospedagem(hosped);

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

		return passagem;
	}

}
