package com.formation.magasin.model.dao.impl.jpa;

import java.sql.SQLException;

import javax.persistence.EntityManager;

import com.formation.magasin.model.dao.CommandeDAO;
import com.formation.magasin.model.entity.Commande;

/**
 * The Class CommandeDAOImplJPA.
 */
public class CommandeDAOImplJPA implements CommandeDAO {

	/** The entity manager. */
	private EntityManager entityManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.magasin.model.dao.DAO#create(java.lang.Object)
	 */
	@Override
	public boolean create(Commande obj) throws SQLException {
		if (obj == null) {
			return false;
		}
		entityManager.persist(obj);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.magasin.model.dao.DAO#delete(java.lang.Object)
	 */
	@Override
	public boolean delete(Commande obj) throws SQLException {
		if (obj == null) {
			return false;
		}
		entityManager.remove(obj);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.magasin.model.dao.DAO#update(java.lang.Object)
	 */
	@Override
	public boolean update(Commande obj) throws SQLException {
		if (obj == null) {
			return false;
		}
		entityManager.persist(obj);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.magasin.model.dao.DAO#find(java.lang.Integer)
	 */
	@Override
	public Commande find(Integer id) throws SQLException {
		if (id == null) {
			return null;
		}
		return entityManager.find(Commande.class, id);
	}

}
