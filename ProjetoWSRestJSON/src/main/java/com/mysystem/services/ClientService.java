package com.mysystem.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mysystem.entities.Client;


public class ClientService {
	
	private static EntityManagerFactory emf;
	
	
	public ClientService() {
		emf = Persistence.createEntityManagerFactory("ProjetoWSRestJSON");
	}
	
	public Client save(Client client){
	
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
	    em.persist(client);
	    em.flush();
	    em.getTransaction().commit();
		em.close();
		return client;
	}
	
	
	public Client update(Client client){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
	    client = em.merge(client);
	    em.getTransaction().commit();
		em.close();
		return client;
	}
	
	

	@SuppressWarnings("unchecked")
	public List<Client> getAllClients(){
		
		EntityManager em = emf.createEntityManager();
		List <Client> list = em.createQuery("Select c From Client c").getResultList();
		em.close();
		return list;
	}

	public Client getUserById(int id) {
		EntityManager em = emf.createEntityManager();
		Client client = em.find(Client.class, id);
		em.close();
		return client;
	}

	
	public void delete(Integer id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
	
		Client user = em.find(Client.class, id);
		
		if(user != null)
			em.remove(user);
		
		em.getTransaction().commit();
		em.close();
	}
	
}
