package com.blo;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleBLO {

	public ArrayList<Ville> getInfoVille(String param);

	public void creerVille(Ville ville);
	
	public void supprimer(String codeCommune);

	public void mettreAJour(Ville ville);
}
