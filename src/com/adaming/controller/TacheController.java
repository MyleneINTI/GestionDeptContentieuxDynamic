package com.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.entities.Tache;
import com.adaming.entitiesHist.TacheHist;
import com.adaming.service.interfaces.ITacheHistService;
import com.adaming.service.interfaces.ITacheService;

@RestController
public class TacheController {
	
	@Autowired
	ITacheService tacheService;
	@Autowired
	ITacheHistService tacheHistService;
	
	@RequestMapping(value = "taches", method = RequestMethod.GET)
	public List<Tache> findAll(){
		return tacheService.find(Tache.class);
	}

	@RequestMapping(value = "taches/{id}", method = RequestMethod.GET)
	public Tache findOne(@PathVariable("id") Long id) {
		return tacheService.getById(Tache.class, id);
	}

	@RequestMapping(value = "taches", method = RequestMethod.POST)
	public Tache saveTache (@RequestBody Tache tache) {
		Tache tache1 = new Tache();
		tache1.setDateCreation(tache.getDateCreation());
		tache1.setDescription(tache.getDescription());
		tache1.setTitre(tache.getTitre());
		tache1.setStatutAudience(tache.isStatutAudience());
		tache1.setAffaire(tache.getAffaire());
		tache1.setTribunal(tache.getTribunal());
		tache1.setPhases(tache.getPhases());
		tacheService.create(tache1);
		return tache1;
	}
	
	@RequestMapping(value = "taches/{id}", method = RequestMethod.DELETE)
	public void deleteTache(@PathVariable("id") Long id) {
		Tache tache1 = new Tache();
		tache1 = tacheService.getById(Tache.class, id);
		TacheHist tacheHist = new TacheHist();
		tacheHist.setDateCreation(tache1.getDateCreation());
		tacheHist.setDescription(tache1.getDescription());
		tacheHist.setStatutAudience(tache1.isStatutAudience());
		tacheHist.setTitre(tache1.getTitre());
		tacheHistService.create(tacheHist);
		tacheService.delete(tache1);
		
	}
}
