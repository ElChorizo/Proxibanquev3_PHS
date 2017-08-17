package org.proxibanque.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.proxibanque.dao.IDao;
import org.proxibanque.model.Client;
import org.proxibanque.model.Compte;
import org.proxibanque.model.CompteCourant;

/**
 * 
 * @author Pierre-Henri, Sébastien
 * 
 *         Le service permet de faire le lien entre le DAO et la vue de
 *         l'application
 *
 */
@Named
public class Service implements IService, Serializable {

	private static final long serialVersionUID = 6243134353021279749L;
	@Inject
	private IDao dao;

	/**
	 * La méthode getClients() permet de récupérer la liste de tout les clients
	 * depuis la DAO pour la transmettre à la vue
	 */
	@Override
	public List<Client> getClients() throws Exception {

		List<Client> clients = dao.getClients();
		return clients;
	}

	/**
	 * La méthode addClients() permet de récupérer les données d'ajout d'un client
	 * depuis la vue et de les persister grâce à la méthode addClient() du DAO
	 */
	@Override
	public void addClient(Client client) throws Exception {
		dao.addClient(client);

	}

	/**
	 * La méthode getClient() permet de récupérer les informations d'un client
	 * depuis la DAO pour la transmettre à la vue
	 */
	@Override
	public Client getClient(int clientId) throws Exception {
		Client client = dao.getClient(clientId);
		return client;

	}

	/**
	 * La méthode updateClients() permet de récupérer les données d'édition des
	 * informations d'un client depuis la vue et de les persister grâce à la méthode
	 * updateClient() du DAO
	 */
	@Override
	public void updateClient(Client client) throws Exception {
		dao.updateClient(client);

	}

	/**
	 * La méthode deleteClients() permet de transmettre l'ordre de supression d'un
	 * client au DAO
	 */
	@Override
	public void deleteClient(int clientId) throws Exception {
		dao.deleteClient(clientId);

	}

	/**
	 * La méthode getComptes() permet de récupérer la liste des comptes d'un client
	 * depuis le DAO pour les transmettre à la vue
	 */
	@Override
	public List<Compte> getComptes(int clientId) throws Exception {
		List<Compte> comptes = dao.getCompte(clientId);
		return comptes;
	}

	/**
	 * La méthode getAllComptes() permet de récupérer la liste de tout les comptes
	 * depuis le DAO pour les transmettre à la vue
	 */
	@Override
	public List<Compte> getAllComptes() throws Exception {
		List<Compte> comptes = dao.getComptes();
		return comptes;
	}

	/**
	 * La méthode virement() permet de réaliser un transfer d'argent entre deux
	 * comptes en éditant le solde du compte débiteur et celui du compte créditeur
	 */
	public void virement(int numCompteDebiter, int numCompteCrediter, double montant) throws Exception {
		Compte compteDebiter = new Compte();
		Compte compteCrediter = new Compte();

		double nouveauSoldeDebiteur = compteDebiter.getSolde() - montant;
		double nouveauSoldeCrediteur = compteCrediter.getSolde() + montant;

		if (compteDebiter instanceof CompteCourant && nouveauSoldeDebiteur >= -1000) {
			dao.updateCompte(compteDebiter);
			dao.updateCompte(compteCrediter);

		} else {

		}
	}

}
