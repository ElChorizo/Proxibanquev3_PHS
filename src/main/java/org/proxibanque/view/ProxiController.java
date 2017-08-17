package org.proxibanque.view;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;
import org.proxibanque.model.Client;
import org.proxibanque.model.Compte;
import org.proxibanque.service.IService;

/**
 * 
 * @author Pierre-Henri, Sébastien
 *
 */
@Named
@ManagedBean(name = "proxiController")
@SessionScoped
public class ProxiController implements Serializable {

	private static final long serialVersionUID = 8712592816548989949L;
	private List<Client> clients;
	private List<Compte> comptes;
	private Client selectedClient;
	private double montant;

	@Inject
	private IService services;

	/**
	 * La méthode getClients() permet d'afficher la liste des clients
	 */
	public List<Client> getClients() {
		return clients;
	}

	/**
	 * La méthode loadClients() permet d'importer les informations de tout les
	 * clients de la base de données pour pouvoir les afficher
	 */
	public void loadClients() {

		try {
			clients = services.getClients();
		} catch (Exception exc) {

			addErrorMessage(exc);
		}

	}

	/**
	 * La méthode addClients() permet d'ajouter un nouveau client
	 */
	public String addClient(Client theClient) {

		try {

			services.addClient(theClient);

		} catch (Exception exc) {

			addErrorMessage(exc);

			return null;
		}

		return "index?faces-redirect=true";
	}

	/**
	 * La méthode loadClient() permet de charger les informations d'un client pour
	 * pouvoir les éditer
	 */
	public String loadClient(int clientId) {

		try {
			Client theClient = services.getClient(clientId);

			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

			Map<String, Object> requestMap = externalContext.getRequestMap();
			requestMap.put("client", theClient);

		} catch (Exception exc) {

			addErrorMessage(exc);

			return null;
		}

		return "editerClient.xhtml";
	}

	/**
	 * La méthode updateClient() permet d'éditer les informations du client et de
	 * les transmettre au service
	 */
	public String updateClient(Client theClient) {

		try {

			services.updateClient(theClient);

		} catch (Exception exc) {

			addErrorMessage(exc);

			return null;
		}

		return "index?faces-redirect=true";
	}

	/**
	 * La méthode deleteClient() permet de supprimer le client selectionné
	 */
	public String deleteClient(int clientId) {

		try {

			services.deleteClient(clientId);

		} catch (Exception exc) {

			addErrorMessage(exc);

			return null;
		}

		return "index";
	}

	/**
	 * La méthode addErrorMessage() permet d'envoyer un message d'erreur à
	 * l'utilisateur lorsqu'une exception est apparue
	 */
	private void addErrorMessage(Exception exc) {
		FacesMessage message = new FacesMessage("Error: " + exc.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	/**
	 * La méthode getSelectedClient() permet de retourner un client spécifique
	 */
	public Client getSelectedClient() {
		return selectedClient;
	}

	/**
	 * La méthode setSelectedClient() permet de setter un client spécifique
	 */
	public void setSelectedClient(Client selectedClient) {
		this.selectedClient = selectedClient;
	}

	/**
	 * La méthode logOut() permet d'invalider la session utilisateur
	 */
	// public String logOut() {
	// FacesContext facesContext = FacesContext.getCurrentInstance();
	// ExternalContext externalContext = facesContext.getExternalContext();
	// externalContext.invalidateSession();
	// return "list-students";
	// }

	/**
	 * La méthode getComptes permet de récupérer les comptes d'un client
	 */
	public List<Compte> getComptes() {

		return comptes;
	}

	/**
	 * La méthode getMontant() permet de récupérer le montant d'un virement
	 */
	public double getMontant() {
		return montant;
	}

	/**
	 * La méthode setMontant() permet de définir le montant d'un virement
	 */
	public void setMontant(double montant) {
		this.montant = montant;
	}

	/**
	 * La méthode virement() permet récupérer les données du virement et de les
	 * transmettre au service
	 */
	public String virement(int numCompteDebiter, int numCompteCrediter, double montant) {

		try {

			services.virement(numCompteDebiter, numCompteCrediter, montant);

		} catch (Exception exc) {

			addErrorMessage(exc);

		}
		return null;
	}

	/**
	 * La méthode getCompte() permet de récupérer la liste de tout les comptes
	 */
	public List<Compte> getCompte(int clientId) {

		return comptes;
	}
}
