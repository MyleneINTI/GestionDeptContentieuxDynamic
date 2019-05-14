package com.adaming.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Affaire implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAffaire;
	private String reference;
	private String titre;
	private String description;
	private int statut;
	
	@OneToMany(mappedBy = "affaire", fetch = FetchType.EAGER)
	private Set<Tache> taches = new HashSet<Tache>();

	
	public Affaire() {
		super();
	}

	public Affaire(Long idAffaire, String reference, String titre, String description, int statut, Set<Tache> taches) {
		super();
		this.idAffaire = idAffaire;
		this.reference = reference;
		this.titre = titre;
		this.description = description;
		this.statut = statut;
		this.taches = taches;
	}

	public Affaire(String reference, String titre, String description, int statut, Set<Tache> taches) {
		super();
		this.reference = reference;
		this.titre = titre;
		this.description = description;
		this.statut = statut;
		this.taches = taches;
	}

	public Affaire(String reference, String titre, String description, int statut) {
		super();
		this.reference = reference;
		this.titre = titre;
		this.description = description;
		this.statut = statut;
	}

	public Long getIdAffaire() {
		return idAffaire;
	}

	public void setIdAffaire(Long idAffaire) {
		this.idAffaire = idAffaire;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Tache> getTaches() {
		return taches;
	}

	public void setTaches(Set<Tache> taches) {
		this.taches = taches;
	}

	public int getStatut() {
		return statut;
	}

	public void setStatut(int statut) {
		this.statut = statut;
	}

	@Override
	public String toString() {
		return "Affaire [idAffaire=" + idAffaire + ", reference=" + reference + ", titre=" + titre + ", description="
				+ description + ", statut=" + statut + "]";
	}

}
