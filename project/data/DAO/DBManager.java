package project.data.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.net.ssl.SSLException;

public class DBManager {
	private static Connection connection = null;
	private DBManager () {}
	
	public static Connection getConnection () throws Exception {
		try {
			// Chargement du driver jdbc mysql
			Class.forName ("com.mysql.cj.jdbc.Driver");

			// Ouverture de la connexion
			connection = DriverManager.getConnection ("jdbc:mysql://localhost:8889/e-sante?useSSL=false&serverTimezone=UTC","root","root");

			return connection;
		} catch (ClassNotFoundException e) {
			throw new Exception ("ClassNotFoundException:'" + e.getMessage () + "' ");
		} catch (SQLException e) {
			throw new Exception ("SQLException:Connection failed:" + e.getMessage());
		}
	}
}
