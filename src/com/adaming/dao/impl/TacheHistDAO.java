package com.adaming.dao.impl;

import org.springframework.stereotype.Repository;

import com.adaming.entities.Tache;
import com.adaming.entitiesHist.TacheHist;
import com.adaming.interfaces.ITacheHistDAO;

@Repository
public class TacheHistDAO extends DaoGenericImpl<TacheHist> implements ITacheHistDAO{

}
