package org.proxibanque.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


import org.proxibanque.model.Client;

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
	public Client getClient(int id) throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tnx = em.getTransaction();
		Client client = new Client();
		try {
			tnx.begin();

			client = em.find(Client.class, id);

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
	public void deleteClient(int id) throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tnx = em.getTransaction();
		try {
			tnx.begin();

			Client client = em.find(Client.class, id);
			em.remove(client);

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
