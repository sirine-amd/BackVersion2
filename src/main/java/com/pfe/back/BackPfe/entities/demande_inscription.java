package com.pfe.back.BackPfe.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Table(name = "Demandes")
@Entity
public class demande_inscription {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "Type")
	private String type;
	
	@Column(name = "Etat")
	private String etat;

	@Column(name = "Date_Creation")
	@DateTimeFormat (pattern = "Yyyy-mm-dd")
	private Date dateCreation;
	
	@Column(name = "Date_de_traitement")
	@DateTimeFormat (pattern = "Yyyy-mm-dd")
	private Date datetraitement;
	@ManyToOne
	private User candidat;
	
	@ManyToOne
	private Formation formation;

	public demande_inscription() {
		super();
	}

	

	public demande_inscription(long id, String type, String etat, Date dateCreation, Date datetraitement, User candidat,
			Formation formation) {
		super();
		this.id = id;
		this.type = type;
		this.etat = etat;
		this.dateCreation = dateCreation;
		this.datetraitement = datetraitement;
		this.candidat = candidat;
		this.formation = formation;
	}


	@JsonFormat(pattern = "yyyy-MM-dd")

	public Date getDatetraitement() {
		return datetraitement;
	}


	@JsonFormat(pattern = "yyyy-MM-dd")

	public void setDatetraitement(Date datetraitement) {
		this.datetraitement = datetraitement;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getDateCreation() {
		return dateCreation;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public User getCandidat() {
		return candidat;
	}

	public void setCandidat(User candidat) {
		this.candidat = candidat;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}
	

}
