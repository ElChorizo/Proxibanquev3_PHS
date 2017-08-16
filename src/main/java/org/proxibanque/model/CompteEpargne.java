package org.proxibanque.model;

import javax.persistence.Entity;

@Entity
public class CompteEpargne extends Compte{

	private double tauxRemuneration = 1.03;

	public double getTauxRemuneration() {
		return tauxRemuneration;
	}

	public void setTauxRemuneration(double tauxRemuneration) {
		this.tauxRemuneration = tauxRemuneration;
	}
	
	
}
