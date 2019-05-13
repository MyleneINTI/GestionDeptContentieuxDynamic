package com.adaming.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.adaming.entities.Utilisateur;
import com.adaming.interfaces.IUtilisateurDAO;

@Repository
public class UtilisateurDAO extends DaoGenericImpl<Utilisateur> implements IUtilisateurDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public Utilisateur findByUsername(String username) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Utilisateur.class).add(Restrictions.like("username", username));
		return (Utilisateur) crit.uniqueResult();
	}

}
