package com.formation.magasin.model.dao.impl.jpa;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.formation.magasin.model.dao.ClientDAO;
import com.formation.magasin.model.entity.Client;

/**
 * The Class ClientDAOImplJPA.
 */
@Repository
public class ClientDAOImplJPA implements ClientDAO {

	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public boolean create(Client obj) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Client obj) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Client obj) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Client find(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
