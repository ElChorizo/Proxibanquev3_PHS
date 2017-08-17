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
 * @author Pierre-Henri, S�bastien
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
	 * La m�thode getClients() permet de r�cup�rer la liste de tout les clients
	 * depuis la DAO pour la transmettre � la vue
	 */
	@Override
	public List<Client> getClients() throws Exception {

		List<Client> clients = dao.getClients();
		return clients;
	}

	/**
	 * La m�thode addClients() permet de r�cup�rer les donn�es d'ajout d'un client
	 * depuis la vue et de les persister gr�ce � la m�thode addClient() du DAO
	 */
	@Override
	public void addClient(Client client) throws Exception {
		dao.addClient(client);

	}

	/**
	 * La m�thode getClient() permet de r�cup�rer les informations d'un client
	 * depuis la DAO pour la transmettre � la vue
	 */
	@Override
	public Client getClient(int clientId) throws Exception {
		Client client = dao.getClient(clientId);
		return client;

	}

	/**
	 * La m�thode updateClients() permet de r�cup�rer les donn�es d'�dition des
	 * informations d'un client depuis la vue et de les persister gr�ce � la m�thode
	 * updateClient() du DAO
	 */
	@Override
	public void updateClient(Client client) throws Exception {
		dao.updateClient(client);

	}

	/**
	 * La m�thode deleteClients() permet de transmettre l'ordre de supression d'un
	 * client au DAO
	 */
	@Override
	public void deleteClient(int clientId) throws Exception {
		dao.deleteClient(clientId);

	}

	/**
	 * La m�thode getComptes() permet de r�cup�rer la liste des comptes d'un client
	 * depuis le DAO pour les transmettre � la vue
	 */
	@Override
	public List<Compte> getComptes(int clientId) throws Exception {
		List<Compte> comptes = dao.getCompte(clientId);
		return comptes;
	}

	/**
	 * La m�thode getAllComptes() permet de r�cup�rer la liste de tout les comptes
	 * depuis le DAO pour les transmettre � la vue
	 */
	@Override
	public List<Compte> getAllComptes() throws Exception {
		List<Compte> comptes = dao.getComptes();
		return comptes;
	}

	/**
	 * La m�thode virement() permet de r�aliser un transfer d'argent entre deux
	 * comptes en �ditant le solde du compte d�biteur et celui du compte cr�diteur
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
