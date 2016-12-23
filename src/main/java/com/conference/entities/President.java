package com.conference.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the president database table.
 * 
 */
@Entity
@NamedQuery(name="President.findAll", query="SELECT p FROM President p")
public class President implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_pres")
	private int idPres;

	@Lob
	private String departement;

	@Lob
	private String email;

	@Lob
	private String nom;

	@Lob
	private String prenom;

	//bi-directional many-to-one association to Session
	@OneToMany(mappedBy="president")
	private List<Session> sessions;

	public President() {
	}

	public int getIdPres() {
		return this.idPres;
	}

	public void setIdPres(int idPres) {
		this.idPres = idPres;
	}

	public String getDepartement() {
		return this.departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
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

	public List<Session> getSessions() {
		return this.sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

	public Session addSession(Session session) {
		getSessions().add(session);
		session.setPresident(this);

		return session;
	}

	public Session removeSession(Session session) {
		getSessions().remove(session);
		session.setPresident(null);

		return session;
	}

}