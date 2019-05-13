package com.adaming.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.entitiesHist.TacheHist;
import com.adaming.service.interfaces.ITacheHistService;

@Service
@Transactional
public class TacheHistService extends ServiceGenericImpl<TacheHist> implements ITacheHistService{

}
