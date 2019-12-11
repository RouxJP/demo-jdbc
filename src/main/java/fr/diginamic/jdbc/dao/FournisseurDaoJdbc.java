package fr.diginamic.jdbc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import fr.diginamic.jdbc.entities.Fournisseur;

public class FournisseurDaoJdbc  extends ConnectionBaseCompta implements FournisseurDao {
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
	public void insert(Fournisseur fournisseur) {
		
		try {
			// Insertion d'un nouveau fournisseur
			stat = con.createStatement();
			stat.executeUpdate( "INSERT INTO FOURNISSEUR ( ID, NOM) "
					           + "VALUES ( " + fournisseur.getId() + ", '" + fournisseur.getNom() + "' )");
			
			con.commit();
			
		} catch (SQLException e) {
			System.out.println( e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println( e1.getMessage());
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
	public int update(int id, String nouveauNom) {
		int				rs 	= 0;
		
		try {
			// Maj d'un nouveau fournisseur
			stat = con.createStatement();
			rs = stat.executeUpdate( "UPDATE FOURNISSEUR SET NOM = '" + nouveauNom + "' WHERE ID = " + id);
				
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
	public boolean delete(int  idFou) {
		boolean				rs 	= false;
		int					nbDel = 0;
		
		try {
			// Maj d'un nouveau fournisseur
			stat = con.createStatement();
			nbDel = stat.executeUpdate( "DELETE FROM FOURNISSEUR  WHERE ID = " + idFou);
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
