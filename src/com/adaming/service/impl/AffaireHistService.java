package com.adaming.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.entities.Affaire;
import com.adaming.entitiesHist.AffaireHist;
import com.adaming.service.interfaces.IAffaireHistService;

@Service
@Transactional
public class AffaireHistService extends ServiceGenericImpl<AffaireHist> implements IAffaireHistService{

}
