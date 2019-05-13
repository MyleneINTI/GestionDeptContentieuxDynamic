package com.adaming.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adaming.entities.Affaire;
import com.adaming.service.interfaces.IAffaireService;

@Controller
public class AffaireController {
	
	@Autowired
	IAffaireService affaireService;
	
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
		affaire1 = affaireHistService.save(affaire1);
		affaireService.delete(affaire1);
	}
	


}
