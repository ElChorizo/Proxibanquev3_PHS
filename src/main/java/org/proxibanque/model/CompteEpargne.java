package org.proxibanque.model;


import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;

@ManagedBean
@Entity
public class CompteEpargne extends Compte{

	private double tauxRemuneration = 1.03;

	public CompteEpargne() {
		
	}
	
	public CompteEpargne(double solde, Client theClient) {
		
	}
	
	

	public CompteEpargne(int numeroCompte, double solde, int dateOuverture, Client client) {
		super(numeroCompte, solde, dateOuverture, client);
	
	}

	public double getTauxRemuneration() {
		return tauxRemuneration;
	}

	public void setTauxRemuneration(double tauxRemuneration) {
		this.tauxRemuneration = tauxRemuneration;
	}
	
	
}
