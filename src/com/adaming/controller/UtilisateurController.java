package com.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.entities.Affaire;
import com.adaming.entities.Utilisateur;
import com.adaming.entitiesHist.UtilisateurHist;
import com.adaming.service.impl.UtilisateurHistService;
import com.adaming.service.interfaces.IUtilisateurHistService;
import com.adaming.service.interfaces.IUtilisateurService;

@CrossOrigin("*")
@RestController
public class UtilisateurController {
	
	@Autowired
	IUtilisateurService utilisateurService;
	@Autowired
	IUtilisateurHistService utilisateurHistService;
	/*
	@Autowired
	private PasswordEncoder passwordEncoder;*/
	
	@RequestMapping(value="utilisateurs", method=RequestMethod.GET)
	public List<Utilisateur> findAll() {
		return utilisateurService.find(Utilisateur.class);
	}
	
	@RequestMapping(value="utilisateurs/{id}", method = RequestMethod.GET)
	public Utilisateur findOne(@PathVariable("id") Long id) {
		return utilisateurService.getById(Utilisateur.class, id);
	}
	
	@RequestMapping(value="utilisateurs", method = RequestMethod.POST)
	public Utilisateur saveUtilisateur(@RequestBody Utilisateur utilisateur)  {
		Utilisateur utilisateur1 = new Utilisateur();
		utilisateur1.setEmail(utilisateur.getEmail());
		utilisateur1.setNom(utilisateur.getNom());
		utilisateur1.setPrenom(utilisateur.getPrenom());
		utilisateur1.setUsername(utilisateur.getUsername());
		//utilisateur1.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
		utilisateur1.setRoles(utilisateur.getRoles());
		utilisateur1.setTaches(utilisateur.getTaches());
		utilisateurService.create(utilisateur1);
		return utilisateur1;
	}
	
	@RequestMapping(value="utilisateurs/{id}", method = RequestMethod.DELETE)
	public void deleteUtilisateur(@PathVariable("id") Long id) {
		Utilisateur utilisateur1 = new Utilisateur();
		utilisateur1 = utilisateurService.getById(Utilisateur.class, id);
		UtilisateurHist utilHist = new UtilisateurHist();
		utilHist.setNom(utilisateur1.getNom());
		utilHist.setPrenom(utilisateur1.getPrenom());
		utilHist.setEmail(utilisateur1.getEmail());
		utilHist.setUsername(utilisateur1.getUsername());
		utilHist.setPassword(utilisateur1.getPassword());
		//utilisateur1.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
		utilisateurHistService.create(utilHist);
		utilisateurService.delete(utilisateur1);
		
	}
	
	@RequestMapping(value = "utilisateurs/{id}", method = RequestMethod.PUT)
	public Utilisateur updateUtilisateur(@PathVariable("id") Long id, @RequestBody Utilisateur utilisateur) {
		Utilisateur currentUtilisateur = utilisateurService.getById(Utilisateur.class, id);
		currentUtilisateur.setEmail(utilisateur.getEmail());
		currentUtilisateur.setNom(utilisateur.getNom());
		currentUtilisateur.setPrenom(utilisateur.getPrenom());
		currentUtilisateur.setUsername(utilisateur.getUsername());
		//currentUtilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
		currentUtilisateur.setRoles(utilisateur.getRoles());
		currentUtilisateur.setTaches(utilisateur.getTaches());
		utilisateurService.update(currentUtilisateur);
		return currentUtilisateur;
	}

	
	

}
