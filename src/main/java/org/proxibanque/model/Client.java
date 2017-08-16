package org.proxibanque.model;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
@ManagedBean
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int clientId;
	private String nom;
	private String prenom;
	private String adresse;
	private String codePostal;
	private String ville;
	private String email;
	
	
	private String telephone;

//	@OneToMany(mappedBy = "client", cascade = { CascadeType.PERSIST })
	private List<Compte> comptes = new ArrayList<>();

	public Client() {

	}

	public Client(int clientId, String nom, String prenom, String adresse, String codePostal, String ville,
			String email, String telephone, List<Compte> comptes) {
		super();
		this.clientId = clientId;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.email = email;
		this.telephone = telephone;
		this.comptes = comptes;
	}

	public void addCompte (Compte compte) {
		comptes.add(compte);
		compte.setClient(this);
		
	}
	
	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	public int getclientId() {
		return clientId;
	}

	public void setclientId(int clientId) {
		this.clientId = clientId;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}

}
