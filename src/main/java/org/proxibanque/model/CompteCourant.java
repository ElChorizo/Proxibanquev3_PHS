package org.proxibanque.model;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

//@Entity
//@DiscriminatorValue("CompteCourant")
public class CompteCourant extends Compte{

	private double decouvert=-1000;

	public CompteCourant() {
		
	}
	
	public CompteCourant(double solde, Client theClient) {
		
	}

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}
	
	
}
