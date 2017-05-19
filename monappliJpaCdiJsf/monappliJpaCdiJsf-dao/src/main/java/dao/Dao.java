package dao;

import java.io.Serializable;
import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import metier.Client;

@Named
@ApplicationScoped
public class Dao implements IDao, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpacdi-pu");

	@Override
	public long addClient(Client c) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(c);
		tx.commit();
		em.close();
		return c.getId();
	}

	@Override
	public Collection<Client> listClients() {
		EntityManager em = emf.createEntityManager();
		Collection<Client> clients = em.createNamedQuery("Client.findAll").getResultList();
		em.close();
		return clients;
	}

	@Override
	public void deleteClient(Client c) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.contains(c) ? c : em.merge(c));
		tx.commit();
		em.close();
	}

	@Override
	public Client findClientById(long idClient) {
		EntityManager em = emf.createEntityManager();
		Client client = em.find(Client.class, idClient);
		em.close();
		return client;
	}

	@Override
	public void majClient(Client c) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(c);
		tx.commit();
		em.close();
	}

}
