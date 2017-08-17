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

	public List<Client> getClients() {
		return clients;
	}

	public void loadClients() {

		try {
			clients = services.getClients();
		} catch (Exception exc) {

			addErrorMessage(exc);
		}

	}

	public String addClient(Client theClient) {

		try {

			services.addClient(theClient);

		} catch (Exception exc) {

			addErrorMessage(exc);

			return null;
		}

		return "index?faces-redirect=true";
	}

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

	public String updateClient(Client theClient) {

		try {

			services.updateClient(theClient);

		} catch (Exception exc) {

			addErrorMessage(exc);

			return null;
		}

		return "index?faces-redirect=true";
	}

	public String deleteClient(int clientId) {

		try {

			services.deleteClient(clientId);

		} catch (Exception exc) {

			addErrorMessage(exc);

			return null;
		}

		return "index";
	}

	private void addErrorMessage(Exception exc) {
		FacesMessage message = new FacesMessage("Error: " + exc.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public Client getSelectedClient() {
		return selectedClient;
	}

	public void setSelectedClient(Client selectedClient) {
		this.selectedClient = selectedClient;
	}

	public void onRowEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Client Edited", ((Client) event.getObject()).getNom());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edit Cancelled", ((Client) event.getObject()).getNom());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	// public String logOut() {
	// FacesContext facesContext = FacesContext.getCurrentInstance();
	// ExternalContext externalContext = facesContext.getExternalContext();
	// externalContext.invalidateSession();
	// return "list-students";
	// }

	public List<Compte> getComptes() {

		return comptes;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String virement(int numCompteDebiter, int numCompteCrediter, double montant) {

		try {

			services.virement(numCompteDebiter, numCompteCrediter, montant);

		} catch (Exception exc) {

			addErrorMessage(exc);

		}
		return null;
	}
}
