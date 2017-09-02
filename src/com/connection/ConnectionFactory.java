package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionFactory {

	private static ConnectionFactory connectionFactory;
	
	private Connection connection;

	private ConnectionFactory() {

	}

	public static ConnectionFactory createInstance() {
		if (connectionFactory == null) {
			connectionFactory = new ConnectionFactory();
		}
		
		return connectionFactory;
	}
	
	public static Connection getConnection() {
		return createInstance().createConnection();
	}

	private Connection createConnection() {
			
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String url = ("jdbc:mysql://localhost:3306/employeedb?useSSL=true");
		String user = ("root");
		String password =("password");

		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}

	}
