package com.conference.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the auteur database table.
 * 
 */
@Entity
@NamedQuery(name="Auteur.findAll", query="SELECT a FROM Auteur a")
public class Auteur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_aut")
	private int idAut;

	@Lob
	private String email;

	@Lob
	private String nom;

	@Lob
	private String prenom;

	//bi-directional many-to-many association to Article
	@ManyToMany
	@JoinTable(
		name="auteur_article"
		, joinColumns={
			@JoinColumn(name="id_aut")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_art")
			}
		)
	private List<Article> articles;

	public Auteur() {
	}

	public int getIdAut() {
		return this.idAut;
	}

	public void setIdAut(int idAut) {
		this.idAut = idAut;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<Article> getArticles() {
		return this.articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

}