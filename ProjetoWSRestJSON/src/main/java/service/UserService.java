package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Usuario;


public class UserService {
	
	private static EntityManagerFactory emf;
	
	
	public UserService() {
		emf = Persistence.createEntityManagerFactory("ProjetoWSRestJSON");
	}
	
	public Usuario save(Usuario user){
	
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
	    em.persist(user);
	    em.flush();
	    em.getTransaction().commit();
		em.close();
		return user;
	}
	
	
	public Usuario update(Usuario user){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
	    user = em.merge(user);
	    em.getTransaction().commit();
		em.close();
		return user;
	}
	
	

	@SuppressWarnings("unchecked")
	public List<Usuario> getAllUsarios(){
		
		EntityManager em = emf.createEntityManager();
		List <Usuario> list = em.createQuery("Select u From Usuario u").getResultList();
		em.close();
		return list;
	}

	public Usuario getUserById(int id) {
		EntityManager em = emf.createEntityManager();
		Usuario user = em.find(Usuario.class, id);
		em.close();
		return user;
	}

	
	public void delete(int id) {
		EntityManager em = emf.createEntityManager();
		Usuario user = em.find(Usuario.class, id);
		em.getTransaction().begin();
		em.remove(user);
		em.getTransaction().commit();
		em.close();
	}
	
}
