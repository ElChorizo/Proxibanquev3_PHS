package org.proxibanque.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.proxibanque.model.Client;
import org.proxibanque.model.Compte;
import org.proxibanque.model.CompteCourant;
import org.proxibanque.model.CompteEpargne;

/**
 * 
 * @author Pierre-Henri, S�bastien
 * 
 * Le DAO permet de faire le lien avec la base de donn�es.
 *
 */
public class Dao implements IDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");

	/**
	 * La m�thode getClients() permet de r�cup�rer la liste de tout les clients de
	 * la base de donn�es
	 */
	@Override
	public List<Client> getClients() throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tnx = em.getTransaction();
		List<Client> clients = new ArrayList<>();
		try {
			tnx.begin();
			TypedQuery<Client> query = em.createQuery("From Client", Client.class);
			clients = query.getResultList();
			tnx.commit();

		} catch (Exception e) {
			if (tnx != null) {
				tnx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}

		}
		return clients;
	}

	/**
	 * La m�thode addClients() permet d'ajouter un client dans la base de donn�es
	 */
	@Override
	public void addClient(Client theClient) throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tnx = em.getTransaction();

		try {
			tnx.begin();

			Compte compteCourant = new CompteCourant(0, theClient);
			Compte compteEpargne = new CompteEpargne(0, theClient);

			theClient.getComptes().add(compteEpargne);
			theClient.getComptes().add(compteCourant);

			em.persist(theClient);

			tnx.commit();
		} catch (Exception e) {
			if (tnx != null) {
				tnx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}

	}

	/**
	 * La m�thode getClient() permet de r�cup�rer un client sp�cifique de la base de
	 * donn�es � l'aide de son identifiant
	 */
	@Override
	public Client getClient(int clientId) throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tnx = em.getTransaction();
		Client client = new Client();
		try {
			tnx.begin();

			client = em.find(Client.class, clientId);

			tnx.commit();
		} catch (Exception e) {
			if (tnx != null) {
				tnx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}

		return client;
	}

	/**
	 * La m�thode updateClient() permet d'�diter les informations d'un client dans
	 * la base de donn�es
	 */
	@Override
	public void updateClient(Client theClient) throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tnx = em.getTransaction();
		try {
			tnx.begin();

			em.merge(theClient);

			tnx.commit();
		} catch (Exception e) {
			if (tnx != null) {
				tnx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	/**
	 * La m�thode deleteClients() permet de supprimer un client dans la base de
	 * donn�es
	 */

	@Override
	public void deleteClient(int clientId) throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tnx = em.getTransaction();
		try {
			tnx.begin();

			Client client = em.find(Client.class, clientId);
			Compte compteCourant = em.find(CompteCourant.class, clientId);
			Compte compteEpargne = em.find(CompteEpargne.class, clientId);
			em.remove(client);
			em.remove(compteCourant);
			em.remove(compteEpargne);

			tnx.commit();
		} catch (Exception e) {
			if (tnx != null) {
				tnx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}

	}

	/**
	 * La m�thode getComptes() permet de r�cup�rer la liste de tout les comptes de
	 * la base de donn�es
	 */

	@Override
	public List<Compte> getComptes() throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tnx = em.getTransaction();
		List<Compte> comptes = new ArrayList<>();
		try {
			tnx.begin();
			TypedQuery<Compte> query = em.createQuery("Select TypeCompte, Solde from Compte", Compte.class);
			comptes = query.getResultList();
			tnx.commit();

		} catch (Exception e) {
			if (tnx != null) {
				tnx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}

		}
		return comptes;
	}

	/**
	 * La m�thode getCompte() permet de r�cup�rer la liste de tout les comptes d'un
	 * client de la base de donn�es
	 */
	@Override
	public List<Compte> getCompte(int clientId) throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tnx = em.getTransaction();
		List<Compte> comptes = new ArrayList<>();
		Client client = new Client();
		try {
			tnx.begin();
			client = em.find(Client.class, clientId);
			comptes = client.getComptes();

			tnx.commit();
		} catch (Exception e) {
			if (tnx != null) {
				tnx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}

		return comptes;
	}

	/**
	 * La m�thode updateCompte() permet d'�diter les informations d'un compte dans
	 * la base de donn�es
	 */
	@Override
	public void updateCompte(Compte theCompte) throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tnx = em.getTransaction();
		try {
			tnx.begin();

			em.merge(theCompte);

			tnx.commit();
		} catch (Exception e) {
			if (tnx != null) {
				tnx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}
}
