package fr.diginamic.jdbc.dao;

import java.util.List;

import fr.diginamic.jdbc.entities.Fournisseur;

public interface FournisseurDao {
	List<Fournisseur> extraire();
	void insert( Fournisseur fournisseur);
	int update( int id, String nouveauNom);
	boolean delete( int id);
	

}
