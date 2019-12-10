package fr.diginamic.props;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TestConnexionMysqlCloud {

	public static void main(String[] args) {
		try {
			ResourceBundle prop = ResourceBundle.getBundle("DataBaseCloud");
			String url 			= prop.getString("url");
			String user 		= prop.getString("user");
			String passwd 		= prop.getString("passwd");
			
			DriverManager.registerDriver( new org.mariadb.jdbc.Driver());
			Connection		con = DriverManager.getConnection( url, user, passwd);
					
			System.out.println("connection " + con.toString());
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
