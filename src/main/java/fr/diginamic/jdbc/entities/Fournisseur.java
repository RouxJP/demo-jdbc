package fr.diginamic.jdbc.entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Fournisseur {
	private int 	id;
	private String 	nom;
	
	public Fournisseur() {
		
	}
	
	public Fournisseur( int 	id, String 	nom) {
		this.id 		= id ;
		this.nom 	= nom;
	}
	
	public ArrayList<Fournisseur> extraire(){
		Statement		stat = null;
		Connection		con  = null ;
		ResultSet		rs	 = null ;
		Fournisseur 	fournisseur ;
		
		ArrayList<Fournisseur>	lstFou = new ArrayList<>();
		
		try {
			// Connexion BD 
			ResourceBundle prop = ResourceBundle.getBundle("DataBaseCloud");
			String url 			= prop.getString("url");
			String user 		= prop.getString("user");
			String passwd 		= prop.getString("passwd");
			
			DriverManager.registerDriver( new org.mariadb.jdbc.Driver());
			con = DriverManager.getConnection( url, user, passwd);
					
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
			con.close();
			
		} catch (SQLException e) {
			System.out.println( e.getMessage());
		} finally {
			
		}
		return lstFou;
	}
	
	/** Getter
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/** Setter
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/** Getter
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/** Setter
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
}
