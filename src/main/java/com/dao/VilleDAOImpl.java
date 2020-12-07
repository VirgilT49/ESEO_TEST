package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.config.JDBCConfiguration;
import com.dto.Ville;

@Repository
public class VilleDAOImpl implements VilleDAO {

	public ArrayList<Ville> getInfoVille() {
		Ville ville = null;
		ArrayList<Ville> villes = new ArrayList<>();
		Connection con = JDBCConfiguration.connectionBDD();
		Statement stmt = null;
		ResultSet rs = null;
		
		String requete = "SELECT * FROM ville_france";

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(requete);
			while (rs.next()) {
				ville = new Ville();
				ville.setCodeCommune(rs.getString(1));
				ville.setCodePostal(rs.getString(3));
				ville.setNomCommune(rs.getString(2));
				ville.setLibelleAcheminement(rs.getString(4));
				ville.setLigne(rs.getString(5));
				ville.setLatitude(rs.getString(6));
				ville.setLongitude(rs.getString(7));
				villes.add(ville);
			}
			con.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
				se2.printStackTrace();
			}
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException se3) {
				se3.printStackTrace();
			}
		}
		
		return villes;
	}

	public ArrayList<Ville> getInfoVilles(String param) {
		ArrayList<Ville> villes = new ArrayList<>();
		Ville ville = null;
		Connection con = JDBCConfiguration.connectionBDD();
		Statement stmt = null;
		ResultSet rs = null;
		
		String requete = "SELECT * FROM ville_france WHERE code_postal = " + param;

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(requete);
			while (rs.next()) {
				ville = new Ville();
				ville.setCodeCommune(rs.getString(1));
				ville.setCodePostal(rs.getString(3));
				ville.setNomCommune(rs.getString(2));
				ville.setLibelleAcheminement(rs.getString(4));
				ville.setLigne(rs.getString(5));
				ville.setLatitude(rs.getString(6));
				ville.setLongitude(rs.getString(7));
				villes.add(ville);
			}
			rs.close();
			return villes;
		} catch (SQLException se) {
			System.out.println("Une erreur s'est produite.");
			return null;
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
				se2.printStackTrace();
			}
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException se3) {
				se3.printStackTrace();
			}
		}
	}

	public void setVille(Ville ville) {
		Statement stmt = null;
		
		try {
			Connection con = JDBCConfiguration.connectionBDD();
			stmt = con.createStatement();
			stmt.executeUpdate(
					"Insert into ville_france(Code_commune_INSEE,Nom_commune,Libelle_acheminement,Ligne_5,Latitude,Code_postal,Longitude)"
							+ " values(" + ville.getCodeCommune() + ",'" + ville.getNomCommune() + "','"
							+ ville.getLibelleAcheminement() + "','" + ville.getLigne() + "'," + ville.getLatitude()
							+ "," + ville.getCodePostal() + "," + ville.getLongitude() + ")");
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
		}
	}
	
	public void supprimer(String codeCommune) {
		Statement stmt = null;
		
		try {
			Connection con = JDBCConfiguration.connectionBDD();
			stmt = con.createStatement();
			stmt.executeUpdate("DELETE FROM ville_france WHERE Code_commune_INSEE = '" +codeCommune + "'");
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
		}
	}

	public void mettreAJour(Ville ville) {
		Statement stmt = null;
		
		try {
			Connection con = JDBCConfiguration.connectionBDD();
			stmt = con.createStatement();
			stmt.executeUpdate("UPDATE ville_france SET Nom_commune=' " + ville.getNomCommune() + "', Code_postal='"
					+ ville.getCodePostal() + "', Libelle_acheminement='" + ville.getLibelleAcheminement()
					+ "', Ligne_5 = '" + ville.getLigne() + "', Latitude='" + ville.getLatitude() + "', Longitude='"
					+ ville.getLongitude() + "'  WHERE Code_commune_INSEE=' " + ville.getCodeCommune() + "'");

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
		}
	}
	
}
