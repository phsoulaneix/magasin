package com.formation.magasin.model.dao.impl.jpa;

import java.sql.SQLException;

import javax.persistence.EntityManager;

import com.formation.magasin.model.dao.LigneCommandeDAO;
import com.formation.magasin.model.entity.LigneCommande;

/**
 * The Class LigneCommandeDAOImplDAO.
 */
public class LigneCommandeDAOImplJPA implements LigneCommandeDAO {

	/** The entity manager. */
	private EntityManager entityManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.magasin.model.dao.DAO#create(java.lang.Object)
	 */
	@Override
	public boolean create(LigneCommande obj) throws SQLException {
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
	public boolean delete(LigneCommande obj) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.magasin.model.dao.DAO#update(java.lang.Object)
	 */
	@Override
	public boolean update(LigneCommande obj) throws SQLException {
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
	public LigneCommande find(Integer id) throws SQLException {
		if (id == null) {
			return null;
		}
		return entityManager.find(LigneCommande.class, id);
	}

}
