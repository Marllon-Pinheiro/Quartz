package br.com.quartzapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDAO {

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost/ativo";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	
	public static Connection getConnection() {
		try {
			Class.forName(DRIVER);
			return DriverManager.
					getConnection(URL, USER, PASSWORD);
		} catch (SQLException | ClassNotFoundException ex){
			throw new RuntimeException("Erro ao tentar conexão com o banco.");
		}
	}
	
}
