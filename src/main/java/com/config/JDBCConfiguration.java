package com.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.annotation.Configuration;

@Configuration
public class JDBCConfiguration {
	
	static final String JDBC_DRIVER = "org.h2.Driver";
	static final String DB_URL = "jdbc:h2:tcp://localhost/~/test";

	static final String USER = "sa";
	static final String PASS = "";
	
	public static Connection connectionBDD() {
		Connection conn = null;
		try {
			Class.forName(JDBC_DRIVER);

			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			System.out.println("Connected database successfully...");

		} catch (SQLException se) {
			se.printStackTrace();
			System.out.println("Erreur");
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erreur");
			System.exit(0);
		}
		
		return conn;
	}
}
