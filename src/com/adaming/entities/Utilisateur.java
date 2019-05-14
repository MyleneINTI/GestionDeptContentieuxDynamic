package com.adaming.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Utilisateur implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUtilisateur;
	private String email;
	private String nom;
	private String prenom;
	
	//Pour Spring Security
	@Column(unique = true)
	private String username;
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable( name = "PROFIL",
				joinColumns = @JoinColumn(name = "UTILISATEUR_ID", referencedColumnName = "idUtilisateur"),
				inverseJoinColumns = @JoinColumn(name = "ROLE_ID", table = "role", referencedColumnName = "idRole"))
	private Set<Role> roles = new HashSet<Role>();
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(	name = "UTILISATEUR_TACHE",
				joinColumns = @JoinColumn(name = "UTILISATEUR_ID", referencedColumnName = "idUtilisateur"),
				inverseJoinColumns = @JoinColumn(name = "TACHE_ID", referencedColumnName = "idTache"))
	private Set<Tache> taches;

	
	public Utilisateur() {
		super();
	}

	public Utilisateur(Long idUtilisateur, String email, String nom, String prenom, Set<Tache> taches) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		//this.taches = taches;
	}
	
	public Utilisateur(Long idUtilisateur, String email, String nom, String prenom) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
	}

	public Utilisateur(String email, String nom, String prenom, Set<Tache> taches) {
		super();
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.taches = taches;
	}

	public Utilisateur(String email, String nom, String prenom) {
		super();
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
	}

	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Set<Tache> getTaches() {
		return taches;
	}

	public void setTaches(Set<Tache> taches) {
		this.taches = taches;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", email=" + email + ", nom=" + nom + ", prenom="
				+ prenom + "]";
	}	

}
