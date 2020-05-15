package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {

	private static Connection conn = null;

	public static Connection getConnection() {// implementa��o do m�todo apra gerar cone��o no bd
		if (conn == null) {// se conex�o ainda � nula
			try {
				Properties props = loadProperties(); // propriedades do banco
				String url = props.getProperty("dburl");// url do banco
				conn = DriverManager.getConnection(url, props);// conex�o com o banco (instanciar um obj do tipo
																// connection)
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		return conn;
	}

	public static void closeConnection() { // para fechar a conex�o com o banco
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}

	private static Properties loadProperties() {
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;
		} catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}
}
