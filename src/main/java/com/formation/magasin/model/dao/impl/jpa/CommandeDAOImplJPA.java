package com.formation.magasin.model.dao.impl.jpa;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.formation.magasin.model.dao.CommandeDAO;
import com.formation.magasin.model.entity.Commande;

/**
 * The Class CommandeDAOImplJPA.
 */
@Repository
public class CommandeDAOImplJPA implements CommandeDAO {

	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public boolean create(Commande obj) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Commande obj) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Commande obj) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Commande find(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
