package br.com.quartzapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class AtivoDAO {

	public Boolean cadastrar(Ativo ativo) {

		String sql = "INSERT INTO ativos (nome, preco, data_registro) VALUES (?, ?, ?)";

		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = MySQLDAO.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, ativo.getNome());
			statement.setBigDecimal(2, ativo.getPreco());
			statement.setTimestamp(3, Timestamp.valueOf(ativo.getDataRegistro()));
			statement.execute();
		} catch (SQLException ex) {
			throw new RuntimeException("Erro ao cadastrar ativo.", ex);
		} finally {
			try {
				connection.close();
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return Boolean.TRUE;
	}

}
