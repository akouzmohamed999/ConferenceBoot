package com.conference.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the article database table.
 * 
 */
@Entity
@NamedQuery(name="Article.findAll", query="SELECT a FROM Article a")
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_art")
	private int idArt;

	@Lob
	private String titre;

	//bi-directional many-to-one association to Session
	@ManyToOne
	@JoinColumn(name="id_sess")
	private Session session;

	//bi-directional many-to-many association to Auteur
	@ManyToMany(mappedBy="articles")
	private List<Auteur> auteurs;

	public Article() {
	}

	public int getIdArt() {
		return this.idArt;
	}

	public void setIdArt(int idArt) {
		this.idArt = idArt;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Session getSession() {
		return this.session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public List<Auteur> getAuteurs() {
		return this.auteurs;
	}

	public void setAuteurs(List<Auteur> auteurs) {
		this.auteurs = auteurs;
	}

}