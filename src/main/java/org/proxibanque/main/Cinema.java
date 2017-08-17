package org.proxibanque.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.proxibanque.model.Client;





public class Cinema {
	
	public static void main(String[] args) {
		
//		Client client1 = new Client(1, "BOB", "totot", "1rue", "7400", "paris", "060000", "bob@gmail.com");
		
		
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	try
	{

		et.begin();

		
		Client client = new Client();

		
		em.persist(client);

		et.commit();
	}catch(
	Exception e)
	{
		if (et != null) {
			et.rollback();
			e.printStackTrace();
		}
	}finally
	{
		if (em != null) {
			em.close();
		}
	}
}}
