package com.dao;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleDAO {
	
	public ArrayList<Ville> getInfoVille();
	
	public ArrayList<Ville> getInfoVilles(String param);

	public void setVille(Ville ville);
	
	public void supprimer(String Code_commune_INSEE);

	public void mettreAJour(Ville ville);
}
