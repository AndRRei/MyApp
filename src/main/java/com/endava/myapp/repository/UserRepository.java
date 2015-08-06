package com.endava.myapp.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.endava.myapp.dao.UserDAO;

@Repository
public class UserRepository {
	private EntityManager em;

	public EntityManager createEntityManger() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("test");
		EntityManager em = factory.createEntityManager();
		return em;
	}

	public List<UserDAO> getAllUsers() {

		em = createEntityManger();
		return  em.createQuery("Select u from UserDAO u")
				.getResultList();
	}
	public UserDAO findUserByUsername(String username)
	{
		System.out.println("AICI");
		em = createEntityManger();
		Query q = em.createQuery("Select u FROM UserDAO u WHERE u.username=:username)");
		return (UserDAO) q.setParameter("username", username).getSingleResult();
				
	}

}
