package com.conference.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the migration_versions database table.
 * 
 */
@Entity
@Table(name="migration_versions")
@NamedQuery(name="MigrationVersion.findAll", query="SELECT m FROM MigrationVersion m")
public class MigrationVersion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String version;

	public MigrationVersion() {
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}