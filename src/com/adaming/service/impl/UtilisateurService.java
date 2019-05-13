package com.adaming.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.entities.Utilisateur;
import com.adaming.interfaces.IUtilisateurDAO;
import com.adaming.service.interfaces.IUtilisateurService;

@Service
@Transactional
public class UtilisateurService extends ServiceGenericImpl<Utilisateur> implements IUtilisateurService{
	
	@Autowired
	private IUtilisateurDAO utilisateurDao;

	public Utilisateur findByUsername(String username) {
		return utilisateurDao.findByUsername(username);
	}
}
