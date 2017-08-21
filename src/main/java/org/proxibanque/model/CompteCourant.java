package org.proxibanque.model;


import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;

@ManagedBean
@Entity
public class CompteCourant extends Compte{

	private double decouvert=-1000;

	public CompteCourant() {
		
	}
	
	public CompteCourant(double solde, Client theClient) {
		
	}
	
	

	public CompteCourant(int numeroCompte, double solde, int dateOuverture, Client client) {
		super(numeroCompte, solde, dateOuverture, client);
		
	}

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}
	
	
}
