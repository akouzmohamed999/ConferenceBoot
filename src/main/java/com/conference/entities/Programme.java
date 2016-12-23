package com.conference.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the programme database table.
 * 
 */
@Entity
@NamedQuery(name="Programme.findAll", query="SELECT p FROM Programme p")
public class Programme implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_prog")
	private int idProg;

	@Temporal(TemporalType.DATE)
	@Column(name="date_deb")
	private Date dateDeb;

	@Temporal(TemporalType.DATE)
	@Column(name="date_fin")
	private Date dateFin;

	@Lob
	private String intitule;

	//bi-directional many-to-one association to Session
	@OneToMany(mappedBy="programme")
	private List<Session> sessions;

	public Programme() {
	}

	public int getIdProg() {
		return this.idProg;
	}

	public void setIdProg(int idProg) {
		this.idProg = idProg;
	}

	public Date getDateDeb() {
		return this.dateDeb;
	}

	public void setDateDeb(Date dateDeb) {
		this.dateDeb = dateDeb;
	}

	public Date getDateFin() {
		return this.dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getIntitule() {
		return this.intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public List<Session> getSessions() {
		return this.sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

	public Session addSession(Session session) {
		getSessions().add(session);
		session.setProgramme(this);

		return session;
	}

	public Session removeSession(Session session) {
		getSessions().remove(session);
		session.setProgramme(null);

		return session;
	}

}