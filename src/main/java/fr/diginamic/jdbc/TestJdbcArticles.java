package fr.diginamic.jdbc;

import java.util.List;

import fr.diginamic.jdbc.dao.ArticleDaoJdbc;
import fr.diginamic.jdbc.dao.ConnectionBaseCompta;
import fr.diginamic.jdbc.dao.FournisseurDaoJdbc;
import fr.diginamic.jdbc.entities.Article;
import fr.diginamic.jdbc.entities.Fournisseur;

public class TestJdbcArticles {

	public static void main(String[] args) {
		ConnectionBaseCompta conBaseCompta = new ConnectionBaseCompta();
		
		// Fournisseurs
		FournisseurDaoJdbc fDaoJdbc = new FournisseurDaoJdbc();
		fDaoJdbc.insert( new Fournisseur( 4, "La Maison de la Peinture"));
		
		// Articles
		ArticleDaoJdbc artDaoJdbc = new ArticleDaoJdbc();
		artDaoJdbc.insert( new Article( 11, "Peinture", "Peinture blanche 1L", 12.5f, new Fournisseur( 4, "")));
		artDaoJdbc.insert( new Article( 12, "Peinture", "Peinture rouge mate 1L", 15.5f, new Fournisseur( 4, "")));
		artDaoJdbc.insert( new Article( 13, "Peinture", "Peinture noire laquée 1L", 17.8f, new Fournisseur( 4, "")));
		artDaoJdbc.insert( new Article( 14, "Peinture", "Peinture bleue mate 1L", 15.5f, new Fournisseur( 4, "")));
	
		// Promo de 25% sur toutes les peintures mates
		List<Article> lstArt = artDaoJdbc.extraire();
		for( Article art : lstArt) {
			if( art.getDesignation().contains( "mate")) {
				art.setPrix( art.getPrix() * 0.75f);
				artDaoJdbc.update( art);
			}		
		}
		
		// Liste des articles
		for( Article art : lstArt) {
			System.out.println("id : " + art.getId() 
							+ " / designation : " + art.getDesignation()
							+ "/ prix : " + art.getPrix());
		
		}
		
		
		System.out.println( "La moyenne des prix des articles est " + artDaoJdbc.moyennePrix());
		
		
		// Suppressions
		for( Article art : lstArt) {
			if( art.getDesignation().contains( "Peinture")) {
				artDaoJdbc.delete( art);
			}		
		}
		fDaoJdbc.delete( 4);
		
		
		// Fermeture
		conBaseCompta.CloseConnection();
		

	}

}
