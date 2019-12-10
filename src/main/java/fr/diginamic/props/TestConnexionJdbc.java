package fr.diginamic.props;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnexionJdbc {

	public static void main(String[] args) {
		try {
			DriverManager.registerDriver( new org.mariadb.jdbc.Driver());
			Connection		con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/compa", "root", "");
					
			System.out.println("connection " + con.toString());
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
