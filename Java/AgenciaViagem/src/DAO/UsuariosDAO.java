package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelo.Usuarios;
import modelo.Permissoes;

public class UsuariosDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	// Metodo pra salvar
	public void save(Usuarios usuario) {
		String sql = "INSERT INTO usuario(nome_usuario, cpf, tel_usuario, email, senha, id_permissao)"
				+ " VALUES(?, ?, ?, ?, ?, ?);";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			// Adicionar o valor dos parametros da sql
			pstm.setString(1, usuario.getNome());
			
			pstm.setString(2, usuario.getCpf());
			
			pstm.setString(3, usuario.getTel());
			
			pstm.setString(4, usuario.getEmail());
			
			pstm.setString(5, usuario.getSenha());
			
			pstm.setInt(6, usuario.getPermissoes().getId());

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
	public List<Usuarios> getUsuarios() {
		String sql = "select * from usuarios;";

		List<Usuarios> usuarios = new ArrayList<Usuarios>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {

				Usuarios usuario = new Usuarios();
				Permissoes permissao = new Permissoes();

				usuario.setId(rset.getInt("id_usuario"));
				
				usuario.setNome(rset.getString("nome_usuario"));
				
				usuario.setCpf(rset.getString("cpf"));
				
				usuario.setTel(rset.getString("tel"));
				
				usuario.setEmail(rset.getString("email"));
				
				usuario.setSenha(rset.getString("senha"));

				permissao.setId(rset.getInt("id_permissao"));
				
				permissao.setTipo(rset.getString("tipo_permissao"));

				usuario.setPermissoes(permissao);

				usuarios.add(usuario);

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

		return usuarios;
	}

	// Metodo pra UPDATE
	public void update(Usuarios usuario) {
		String sql = "UPDATE usuarios SET nome_usuario = ?, cpf = ?, tel_usuario = ?,"
				+ " email = ?,senha = ?, id_permissao = ? where id_usuario = ?;";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, usuario.getNome());
			
			pstm.setString(2, usuario.getCpf());
			
			pstm.setString(3, usuario.getTel());
			
			pstm.setString(4, usuario.getEmail());
			
			pstm.setString(5, usuario.getSenha());
			
			pstm.setInt(6, usuario.getPermissoes().getId());
			
			pstm.setInt(7, usuario.getId());
			
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
	public void removeById(int id) {
		String sql = "DELETE FROM usuarios WHERE id_usuario = ?";

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
	public Usuarios getUsuariosById(int id) {

		String sql = "SELECT * FROM usuarios where id_usuario= ?";
		
		Usuarios usuarios = new Usuarios();
		Permissoes permissoes = new Permissoes();

		ResultSet rset = null;

		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			rset.next();
			
			usuarios.setId(rset.getInt("id_usuario"));	

			usuarios.setNome(rset.getString("nome_usuario"));
			
			usuarios.setCpf(rset.getString("cpf"));
			
			usuarios.setTel(rset.getString("tel_usuario"));
			
			usuarios.setEmail(rset.getString("email"));
			
			usuarios.setSenha(rset.getString("senha"));
			
			permissoes.setTipo(rset.getString("tipo"));	
			
			permissoes.setId(rset.getInt("id_permissao"));						
		
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
		return usuarios;
	}
		
}
