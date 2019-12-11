package fr.diginamic.jdbc;



import fr.diginamic.jdbc.dao.ConnectionBaseCompta;
import fr.diginamic.jdbc.dao.FournisseurDaoJdbc;


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
		ConnectionBaseCompta conBaseCompta = new ConnectionBaseCompta();
		
		FournisseurDaoJdbc fDaoJdbc = new FournisseurDaoJdbc();
		fDaoJdbc.delete( 4);
	
		conBaseCompta.CloseConnection();
		
	}

}
