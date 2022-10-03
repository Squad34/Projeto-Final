package br.com.recode.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	// Nome do usuário do mysql
	private static final String USERNAME = "daniel";
	// Senha do mysql
	private static final String PASSWORD = "Ag581xyz";
	// Dados de caminho, porta e nome da base de dados que irá ser feita a conexão
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/conexao360";

	// * Cria uma conexão com o banco de dados MySQL utilizando o nome de usuário e
	// senha fornecidos
	// * @param username
	// * @param senha
	// * @return uma conexão com o banco de dados
	// * @throws Exception

	public static Connection createConnectionMySQL() throws Exception {
		// Cria a conexão com o banco de dados
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		return connection;
	}
	
	public static void main(String[] args) throws Exception {
		// Recupera uma conex�o com o banco de dados
		Connection con = createConnectionMySQL();
		
		// testar a conex�o 
		if (con != null) {
			System.out.println(con + "\n\n ****  Conex�o obtida com sucesso!  ****");
			con.close();
		}
	}
}