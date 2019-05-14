package com.adaming.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.entities.Utilisateur;
import com.adaming.entitiesHist.UtilisateurHist;
import com.adaming.service.interfaces.IUtilisateurHistService;

@Service
@Transactional
public class UtilisateurHistService extends ServiceGenericImpl<UtilisateurHist> implements IUtilisateurHistService{

}
