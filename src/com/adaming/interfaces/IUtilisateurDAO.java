package com.adaming.interfaces;

import com.adaming.entities.Utilisateur;
import com.adaming.utils.DaoGeneric;

public interface IUtilisateurDAO extends DaoGeneric<Utilisateur> {
	
	public Utilisateur findByUsername(String username);

}
