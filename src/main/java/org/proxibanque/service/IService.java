package org.proxibanque.service;

import java.util.List;

import org.proxibanque.model.Client;
import org.proxibanque.model.Compte;

public interface IService {
	List<Client> getClients() throws Exception;

	void addClident(Client client) throws Exception;

	Client getClient(int clientId) throws Exception;

	void updateClient(Client client) throws Exception;

	void deleteClient(int clientId) throws Exception;
	
	List<Compte> getComptes() throws Exception;

}
