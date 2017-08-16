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

public class Dao implements IDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");

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

	@Override
	public Compte getCompte(int numeroCompte) throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tnx = em.getTransaction();
		Compte compte = new Compte();
		try {
			tnx.begin();
			compte = em.find(Compte.class, numeroCompte);
			

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

		return compte;
	}

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
