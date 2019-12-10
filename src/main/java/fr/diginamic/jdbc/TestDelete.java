package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import fr.diginamic.jdbc.dao.FournisseurDaoJdbc;
import fr.diginamic.jdbc.entities.Fournisseur;

public class TestDelete {
	public static void main(String[] args) {
		/**
		Statement		stat = null;
		Connection		con  = null ;
		
		try {
			// Connexion BD 
			ResourceBundle prop = ResourceBundle.getBundle("DataBaseCloud");
			String url 			= prop.getString("url");
			String user 		= prop.getString("user");
			String passwd 		= prop.getString("passwd");
			
			DriverManager.registerDriver( new org.mariadb.jdbc.Driver());
			con = DriverManager.getConnection( url, user, passwd);
					
			// Insertion d'un nouveau fournisseur
			stat = con.createStatement();
			stat.executeUpdate( "DELETE FROM FOURNISSEUR WHERE ID =4");
			System.out.println("Delete OK");
			// Fermeture
			stat.close();
			con.close();
			
		} catch (SQLException e) {
			System.out.println( e.getMessage());
		} finally {
			
		}
        **/
		FournisseurDaoJdbc fDaoJdbc = new FournisseurDaoJdbc();
		fDaoJdbc.delete( new Fournisseur( 4, ""));
		fr.diginamic.jdbc.dao.FournisseurDaoJdbc.CloseConnection();
	}

}
