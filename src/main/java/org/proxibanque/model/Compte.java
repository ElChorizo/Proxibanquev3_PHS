package org.proxibanque.model;



import java.util.Calendar;

import javax.faces.bean.ManagedBean;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@ManagedBean
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Compte {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int numeroCompte;
	private double solde;
	private int dateOuverture = Calendar.DATE;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	@JoinColumn(name = "clientId", referencedColumnName="clientId")
	private Client client;

	public Compte() {

	}

	public Compte(double solde, Client client) {
		super();
		this.solde = solde;
		this.client = client;
	}

	public Compte(int numeroCompte, double solde, int dateOuverture, Client client) {
		super();
		this.numeroCompte = numeroCompte;
		this.solde = solde;
		this.dateOuverture = dateOuverture;
		this.client = client;
	}

	

	public int getDateOuverture() {
		return dateOuverture;
	}

	public void setDateOuverture(int dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public int getNumeroCompte() {
		return numeroCompte;
	}

	public void setNumeroCompte(int numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

}
