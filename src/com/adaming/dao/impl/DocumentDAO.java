package com.adaming.dao.impl;

import org.springframework.stereotype.Repository;

import com.adaming.entities.Document;
import com.adaming.interfaces.IDocumentDAO;

@Repository
public class DocumentDAO extends DaoGenericImpl<Document> implements IDocumentDAO{

}
