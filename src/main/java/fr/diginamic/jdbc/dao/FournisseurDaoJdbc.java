package fr.diginamic.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.diginamic.jdbc.entities.Fournisseur;

public class FournisseurDaoJdbc implements FournisseurDao {
	Statement		stat = null;
	ResultSet		rs	 = null ;
	
	static Connection		con  = null ;
	// Bloc static pour ouvrir la connection BD
	{
		Connection();
	}

	public static void Connection() {
		try {
			// Connexion BD 
			ResourceBundle prop = ResourceBundle.getBundle("DataBaseCloud");
			String url 			= prop.getString("url");
			String user 		= prop.getString("user");
			String passwd 		= prop.getString("passwd");
			
			DriverManager.registerDriver( new org.mariadb.jdbc.Driver());
			con = DriverManager.getConnection( url, user, passwd);
					
			
		} catch (SQLException e) {
			System.out.println( e.getMessage());

		} finally {
			
		}
	}
	public static void CloseConnection() {
		try {
			con.close();
					
			
		} catch (SQLException e) {
			System.out.println( e.getMessage());

		} finally {
			
		}
	}
	
	@Override
	public List<Fournisseur> extraire() {
		Fournisseur 	fournisseur ;
		
		List<Fournisseur>	lstFou = new ArrayList<>();
		
		try {
					
			// Lire les  fournisseurs
			stat = con.createStatement();
			rs = stat.executeQuery( "SELECT * FROM FOURNISSEUR");
			
			
			while( rs.next()) {
				fournisseur = new Fournisseur( rs.getInt("ID"), rs.getString( "NOM"));
				lstFou.add( fournisseur);
			}
			// Fermetures
			rs.close();
			stat.close();
			
		} catch (SQLException e) {
			System.out.println( e.getMessage());
		} finally {
			
		}
		return lstFou;
	}

	@Override
	public void insert(Fournisseur fournisseur) {
		
		try {
			// Insertion d'un nouveau fournisseur
			stat = con.createStatement();
			stat.executeUpdate( "INSERT INTO FOURNISSEUR ( ID, NOM) "
					           + "VALUES ( " + fournisseur.getId() + ", '" + fournisseur.getNom() + "' )");
			
			// Fermeture
			con.commit();
			stat.close();
			
		} catch (SQLException e) {
			System.out.println( e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println( e.getMessage());
			}
		} 

		
	}

	@Override
	public int update(int id, String nouveauNom) {
		int				rs 	= 0;
		
		try {
			// Maj d'un nouveau fournisseur
			stat = con.createStatement();
			rs = stat.executeUpdate( "UPDATE FOURNISSEUR SET NOM = '" + nouveauNom + "' WHERE ID = " + id);
				
			// Fermeture
			con.commit();
			stat.close();
			
		} catch (SQLException e) {
			System.out.println( e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println( e.getMessage());
			}
		} 

		
		return rs;
	}

	@Override
	public boolean delete(Fournisseur fournisseur) {
		boolean				rs 	= false;
		int					nbDel = 0;
		
		try {
			// Maj d'un nouveau fournisseur
			stat = con.createStatement();
			nbDel = stat.executeUpdate( "DELETE FROM FOURNISSEUR  WHERE ID = " + fournisseur.getId());
			if( nbDel==1) {
				rs = true;
			}
				
			// Fermeture
			con.commit();
			stat.close();
			
		} catch (SQLException e) {
			System.out.println( e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println( e.getMessage());
			}
		} 

		
		return rs;
	}

}
