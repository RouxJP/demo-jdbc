package fr.diginamic.jdbc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.jdbc.entities.Article;
import fr.diginamic.jdbc.entities.Fournisseur;

public class ArticleDaoJdbc implements ArticleDao {
	Connection 					con 		= null;
	Statement					stat 		= null;
	ResultSet					rs	 		= null ;
	ConnectionBaseCompta		conCompta  	= new ConnectionBaseCompta();

	// Static bloc pour récupérer la 1ere fois la connection à la BD
	{
		 con = conCompta.getConnection();
	}
	
	public float moyennePrix() {
		Float moyenne = 0f;
		
		try {
					
			stat = con.createStatement();
			
			rs = stat.executeQuery( "SELECT AVG( prix) MOYENNE FROM ARTICLE");
			while( rs.next()) {
				moyenne =  	rs.getFloat( "MOYENNE");
			}
			
		} catch (SQLException e) {
			System.out.println( e.getMessage());
		} finally {
			// Fermetures
			try {
				rs.close();
				stat.close();
			} catch (SQLException e) {
				System.out.println( e.getMessage());
			}
		}
		return moyenne;
	}

	@Override
	public List<Article> extraire() {
		Article 	Article ;
		
		List<Article>	lstFou = new ArrayList<>();
		
		try {				
			// Lire les  Articles
			stat = con.createStatement();
			rs = stat.executeQuery( "SELECT ARTICLE.*, FOURNISSEUR.* FROM ARTICLE, FOURNISSEUR WHERE ARTICLE.ID_FOU = FOURNISSEUR.ID");
			
			
			while( rs.next()) {
				Article = new Article( 	rs.getInt("ARTICLE.ID"), 
										rs.getString( "REF"),
										rs.getString( "DESIGNATION"),
										rs.getFloat( "PRIX"),
										new Fournisseur( rs.getInt("FOURNISSEUR.ID"),rs.getString( "NOM"))
										);
				lstFou.add( Article);
			}
			
		} catch (SQLException e) {
			System.out.println( e.getMessage());
		} finally {
			// Fermetures
			try {
				rs.close();
				stat.close();
			} catch (SQLException e) {
				System.out.println( e.getMessage());
			}
		}
		return lstFou;
	}

	@Override
	public void insert(Article article) {
		try {
			// Insertion d'un nouveau Article
			
			stat = con.createStatement();
			stat.executeUpdate( "INSERT INTO ARTICLE ( ID, REF, DESIGNATION, PRIX, ID_FOU) "
					           + "VALUES ( " 	+ article.getId()  + ", '" 
					           					+ article.getRef() + "', '" 
					           					+ article.getDesignation() + "', " 
					           					+ article.getPrix() + ", " 
					           					+ article.getFournisseur().getId() + 
					           					" )");
			
			con.commit();
		
		} catch (SQLException e) {
			System.out.println( e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println( e.getMessage());
			}
		} finally {
			// Fermetures
			try {
				stat.close();
			} catch (SQLException e) {
				System.out.println( e.getMessage());
			}
		}

		

	}

	@Override
	public int update(Article article) {
		int		rs 	= 0;
		
		try {
			// Maj d'un nouveau Article
			stat = con.createStatement();
			rs = stat.executeUpdate( "UPDATE ARTICLE SET PRIX = "  + article.getPrix() 
			                           + " WHERE ID = " + article.getId());
			
			con.commit();
		
		} catch (SQLException e) {
			System.out.println( e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println( e.getMessage());
			}
		} finally {
			// Fermetures
			try {
				stat.close();
			} catch (SQLException e) {
				System.out.println( e.getMessage());
			}
		}

		
		return rs;
	}

	@Override
	public boolean delete(Article article) {
		boolean				rs 	= false;
		int					nbDel = 0;
		
		try {
			// Maj d'un nouveau Article
			stat = con.createStatement();
			nbDel = stat.executeUpdate( "DELETE FROM ARTICLE  WHERE ID = " + article.getId());
			if( nbDel==1) {
				rs = true;
			}
				
			con.commit();
	
		} catch (SQLException e) {
			System.out.println( e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println( e.getMessage());
			}
		} finally {
			// Fermetures
			try {
				stat.close();
			} catch (SQLException e) {
				System.out.println( e.getMessage());
			}
		}

		
		return rs;
	}

}
