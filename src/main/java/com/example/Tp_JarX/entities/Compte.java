package com.example.Tp_JarX.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Compte {
	@Id
	@GeneratedValue()
	private Long id;
	private double solde;
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	@Enumerated(EnumType.ORDINAL)
	private TypeCompte type;
	public Compte(Long id, double solde, Date dateCreation, TypeCompte type) {
		super();
		this.id = id;
		this.solde = solde;
		this.dateCreation = dateCreation;
		this.type = type;
	}
	public Compte() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public TypeCompte getType() {
		return type;
	}
	public void setType(TypeCompte type) {
		this.type = type;
	}
	

}
