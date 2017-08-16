package org.proxibanque.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;



import com.mysql.fabric.xmlrpc.Client;

public class Cinema {
	
	public static void main(String[] args) {
		
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	try
	{

		et.begin();

		
		Client client = new Client(null);

		
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