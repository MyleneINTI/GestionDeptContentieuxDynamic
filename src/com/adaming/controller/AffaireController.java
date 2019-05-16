package com.adaming.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.entities.Affaire;
import com.adaming.entitiesHist.AffaireHist;
import com.adaming.service.interfaces.IAffaireHistService;
import com.adaming.service.interfaces.IAffaireService;

@CrossOrigin("*")
@RestController
public class AffaireController {
	
	@Autowired
	IAffaireService affaireService;
	@Autowired
	IAffaireHistService affaireHistService;
	
	@RequestMapping(value="affaires", method=RequestMethod.GET)
	public List<Affaire> findAll() {
		return affaireService.find(Affaire.class);
	}
	
	@RequestMapping(value="affaires/{id}", method = RequestMethod.GET)
	public Affaire findOne(@PathVariable("id") Long id) {
		return affaireService.getById(Affaire.class, id);
	}
	
	@RequestMapping(value="affaires", method = RequestMethod.POST)
	public Affaire saveAffaire(@RequestBody Affaire affaire)  {
		Affaire affaire1 = new Affaire();
		affaire1.setReference(affaire.getReference());
		affaire1.setTitre(affaire.getTitre());
		affaire1.setDescription(affaire.getDescription());
		affaire1.setStatut(affaire.getStatut());
		affaireService.create(affaire1);
		return affaire1;
	}
	
	@RequestMapping(value="affaires/{id}", method = RequestMethod.DELETE)
	public void deleteAffaire(@PathVariable("id") Long id) {
		Affaire affaire1 = new Affaire();
		affaire1 = affaireService.getById(Affaire.class, id);
		AffaireHist affaireHist = new AffaireHist();
		affaireHist.setDescription(affaire1.getDescription());
		affaireHist.setReference(affaire1.getReference());
		affaireHist.setTitre(affaire1.getTitre());
		affaireHist.setStatut(affaire1.getStatut());
		affaireHistService.create(affaireHist);
		affaireService.delete(affaire1);
	}
	


}
