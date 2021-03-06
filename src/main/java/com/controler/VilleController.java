package com.controler;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLO;
import com.dto.Ville;

@RestController
public class VilleController {
	
	@Autowired
	VilleBLO villeService;

	// GET
	@RequestMapping(value = "/ville", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<Ville> appelGet(@RequestParam(required = false, value = "codePostal") String monParam)
			throws ClassNotFoundException, SQLException {
		System.out.println("Requete GET");
		System.out.println("Param = " + monParam);
		return villeService.getInfoVille(monParam);
	}
	
	// POST
	@RequestMapping(value = "/ville", method = RequestMethod.POST)
	@ResponseBody
	public ArrayList<Ville> appelPost(@RequestBody Ville ville) throws ClassNotFoundException, SQLException {
		System.out.println("Requete POST");
		villeService.creerVille(ville);
		return null;
	}

	// PUT
	@RequestMapping(value = "/ville", method = RequestMethod.PUT)
	@ResponseBody
	public void appelPut(@RequestBody Ville ville) throws ClassNotFoundException, SQLException {
		System.out.println("Requete PUT");
		villeService.mettreAJour(ville);
	}

	// DELETE
	@RequestMapping(value = "/ville/delete/{Code_commune_INSEE}", method = RequestMethod.DELETE)
	public void deleteEmployeeById(@PathVariable("Code_commune_INSEE") String codeCommune) throws Exception {
		System.out.println("Requete DELETE");
		villeService.supprimer(codeCommune);
	}
}
