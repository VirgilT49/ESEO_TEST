package com.blo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.VilleDAO;
import com.dto.Ville;

@Service
public class VilleBLOImpl implements VilleBLO {

	@Autowired
	private VilleDAO villeDAO;
	
	public ArrayList<Ville> getInfoVille(String param) {
		ArrayList<Ville> listeVilles = null;
		if (param != null) {
			listeVilles = villeDAO.getInfoVilles(param);
		} else {
			listeVilles = villeDAO.getInfoVille();
		}
		
		return listeVilles;
	}
	
	public void creerVille(Ville ville) {
		villeDAO.setVille(ville);
	}

	public void supprimer(String CodeCommune) {
		villeDAO.supprimer(CodeCommune);
	}
	
	public void mettreAJour(Ville ville) {
		villeDAO.mettreAJour(ville);
	}
}
