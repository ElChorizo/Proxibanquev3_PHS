package org.proxibanque.model;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CompteEpargne")
public class CompteEpargne extends Compte{

	private double tauxRemuneration = 1.03;

	public CompteEpargne() {
		
	}
	
	public CompteEpargne(double solde, Client theClient) {
		
	}

	public double getTauxRemuneration() {
		return tauxRemuneration;
	}

	public void setTauxRemuneration(double tauxRemuneration) {
		this.tauxRemuneration = tauxRemuneration;
	}
	
	
}
