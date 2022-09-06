package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionMySQL {

	private static String URL = "jdbc:mysql://localhost:3306/agenciaViagem";
	private static String USUARIO = "root";
	private static String SENHA = "Angel*15/?#*";

	public static Connection createConnectionMySQL() throws Exception {

		// faz com que a classe seja carregada pela JVM
		Class.forName("com.mysql.cj.jdbc.Driver");

		//Cria conexão com bacos de dados ======= com senha
		Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA);
		
		return connection;

	}

	public static void main(String[] args) throws Exception{
		
	
		Connection con = createConnectionMySQL();

		// Testa a conexão 
		if (con != null) {
			System.out.println("\n\nConexâo obtida com sucesso!" + con);

			con.close();

	}
}
}
