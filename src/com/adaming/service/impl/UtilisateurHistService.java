package com.adaming.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.entitiesHist.UtilisateurHist;
import com.adaming.service.interfaces.IUtilisateurHistService;
import com.adaming.service.interfaces.IUtilisateurService;

@Service
@Transactional
public class UtilisateurHistService extends ServiceGenericImpl<UtilisateurHist> implements IUtilisateurHistService{

}
