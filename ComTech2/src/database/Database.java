package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Util.ComTechTools;

public class Database {

	private static Connection connection = null;

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://sql3.freesqldatabase.com/sql3284576";
			try {
				connection = DriverManager.getConnection(url, "sql3284576", "mvvyWVfLWu");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				ComTechTools.Setnotification("Error", "No hay coneccion de internet", 2, "delete.png");

			}
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			
		}
		return connection;
	}

	public static void main(String[] args) {
		getConnection();
	}

}
