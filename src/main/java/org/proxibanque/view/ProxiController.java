package org.proxibanque.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import org.proxibanque.model.Client;

@ManagedBean(name = "proxiController")
@ViewScoped
public class ProxiController implements Serializable {

	private static final long serialVersionUID = 8712592816548989949L;
	private List<Client> clients;
	private Client selectedClient;

	@ManagedProperty("#{clientService}")
	private ClientService service;

	@PostConstruct
	public void init() {
		clients = service.createClients(10);
	}

	public List<Client> getClients() {
		return clients;
	}

	public Client getSelectedClient() {
		return selectedClient;
	}

	public void setSelectedClient(Client selectedClient) {
		this.selectedClient = selectedClient;
	}

	public void setService(ClientService service) {
		this.service = service;
	}

	public void delete() {
		clients.remove(selectedClient);
		selectedClient = null;
	}


	public void onRowEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Client Edited", ((Client) event.getObject()).getNom());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edit Cancelled", ((Client) event.getObject()).getNom());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}
