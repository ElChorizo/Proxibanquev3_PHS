package org.proxibanque.service;

import java.util.List;


import org.proxibanque.model.Client;
import org.proxibanque.model.Compte;

/**
 * 
 * @author Pierre-Henri, Sébastien
 *
 */
public interface IService {
	List<Client> getClients() throws Exception;

	void addClient(Client client) throws Exception;

	Client getClient(int clientId) throws Exception;

	void updateClient(Client client) throws Exception;

	void deleteClient(int clientId) throws Exception;

	List<Compte> getAllComptes() throws Exception;

	void virement(int numCompteDebiter, int numCompteCrediter, double montant) throws Exception;

	List<Compte> getComptes(int clientId) throws Exception;
	
}
