package org.proxibanque.dao;

import java.util.List;

import org.proxibanque.model.Client;

public interface IDao {
	
	List<Client> getClients() throws Exception;

	void addClient(Client theClient) throws Exception;

	Client getClient(int id) throws Exception;

	void updateClient(Client theClient) throws Exception;

	void deleteClient(int id) throws Exception;
}


