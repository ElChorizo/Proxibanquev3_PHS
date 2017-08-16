package org.proxibanque.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.proxibanque.dao.Dao;
import org.proxibanque.model.Client;
import org.proxibanque.model.Compte;

@Named
public class Service implements IService, Serializable {

	@Inject
	private Dao dao;

	@Override
	public List<Client> getClients() throws Exception {

		List<Client> clients = dao.getClients();
		return clients;
	}

	@Override
	public void addClident(Client client) throws Exception {
		dao.addClient(client);

	}

	@Override
	public Client getClient(int clientId) throws Exception {
		Client client = dao.getClient(clientId);
		return client;

	}

	@Override
	public void updateClient(Client client) throws Exception {
		dao.updateClient(client);

	}

	@Override
	public void deleteClient(int clientId) throws Exception {
		dao.deleteClient(clientId);

	}

	@Override
	public List<Compte> getComptes() throws Exception {
		List<Compte> comptes = dao.getComptes();
		return comptes;
	}

}
