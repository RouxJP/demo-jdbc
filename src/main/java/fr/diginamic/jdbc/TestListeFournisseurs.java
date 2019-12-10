package fr.diginamic.jdbc;

import java.util.ArrayList;
import java.util.List;

import fr.diginamic.jdbc.dao.FournisseurDaoJdbc;
import fr.diginamic.jdbc.entities.Fournisseur;

public class TestListeFournisseurs {

	public static void main(String[] args) {
		/**
		Fournisseur fournisseur = new Fournisseur();
		ArrayList<Fournisseur> lstFou = fournisseur.extraire();
		
		for( Fournisseur fou : lstFou) {
			System.out.println("id : " + fou.getId() + "/ nom : " + fou.getNom());
		}
		**/
		
		FournisseurDaoJdbc fDaoJdbc = new FournisseurDaoJdbc();
		List<Fournisseur> lstFou =  fDaoJdbc.extraire();
		for( Fournisseur fou : lstFou) {
			System.out.println("id : " + fou.getId() + "/ nom : " + fou.getNom());
		}
		fr.diginamic.jdbc.dao.FournisseurDaoJdbc.CloseConnection();

		
	}

}
