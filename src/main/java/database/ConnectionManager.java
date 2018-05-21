package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private static ConnectionManager instance=null;
	private static final String USERNAME="sql7239135";
	private static final String PASSWORD="8nJrCtVrE3";
	private static final String CONN_STRING="jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7239135"; //?useSSL=false&serverTimezone=UTC";
	
	private Connection connection=null;
	
	private ConnectionManager() {
		
	}
	
	public static ConnectionManager getInstance() {
		if (instance == null) {
			instance = new ConnectionManager();
		}
//		System.out.println("Dao Instancu");
		return instance;
	}

	private boolean openConnection() {
		try {
			connection = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
//			System.out.println("Otvorio konekciju");
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}
	}
	public Connection getConnection() {
		if (connection == null) {
			if (openConnection()) {
//				System.out.println("Vratio konekciju");
				return connection;
			} else {
				return null;
			}
		}
		return connection;
	}

	public void close() {
	//	System.out.println("Konekcija zatvorena.");
		try {
			connection.close();
			connection = null;
		} catch (Exception e) {
		}
	}


}
