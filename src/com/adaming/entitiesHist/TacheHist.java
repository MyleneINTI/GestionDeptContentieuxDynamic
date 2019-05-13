package com.adaming.entitiesHist;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class TacheHist {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTache;
	@Temporal(value = TemporalType.DATE)
	private Date dateCreation;
	private String description;
	private String titre;
	private boolean statutAudience;
	
	public TacheHist() {
		super();
	}
	
	public Long getIdTache() {
		return idTache;
	}
	
	public void setIdTache(Long idTache) {
		this.idTache = idTache;
	}
	
	public Date getDateCreation() {
		return dateCreation;
	}
	
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getTitre() {
		return titre;
	}
	
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	public boolean isStatutAudience() {
		return statutAudience;
	}
	
	public void setStatutAudience(boolean statutAudience) {
		this.statutAudience = statutAudience;
	}
	
	@Override
	public String toString() {
		return "TacheHist [idTache=" + idTache + ", dateCreation=" + dateCreation + ", description=" + description
				+ ", titre=" + titre + ", statutAudience=" + statutAudience + "]";
	}

}
