package fr.diginamic.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ConnectionBaseCompta {
	Connection 					con 		= null;
	Statement					stat 		= null;
	ResultSet					rs	 		= null ;

	
	// Static bloc pour récupérer la 1ere fois la connection à la BD
	{
		Connection();
	}
	
	public void Connection() {
		try {
			// Connexion BD 
			ResourceBundle prop = ResourceBundle.getBundle("DataBaseCloud");
			String url 			= prop.getString("url");
			String user 		= prop.getString("user");
			String passwd 		= prop.getString("passwd");
			
			DriverManager.registerDriver( new org.mariadb.jdbc.Driver());
			con =  DriverManager.getConnection( url, user, passwd);
					
			
		} catch (SQLException e) {
			System.out.println( e.getMessage());

		} finally {
			
		}
	}
	
	public Connection getConnection() {
		return con;
	}
	
	public  void CloseConnection() {
		try {
			con.close();
					
			
		} catch (SQLException e) {
			System.out.println( e.getMessage());

		} finally {
			
		}
	}
	

}
