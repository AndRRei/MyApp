package com.endava.myapp.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.endava.myapp.dao.UserDAO;

@Repository
public class UserRepository {

	private EntityManager em;

	@Transactional
	public List<UserDAO> getAllUsers()
	{

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
				EntityManager em = factory.createEntityManager();
				return  em.createQuery("Select u.username from UserDAO u").getResultList();
				

	}

}
