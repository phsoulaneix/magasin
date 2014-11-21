package com.formation.magasin.model.dao.impl.jpa;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.formation.magasin.model.dao.LigneCommandeDAO;
import com.formation.magasin.model.entity.LigneCommande;

/**
 * The Class LigneCommandeDAOImplDAO.
 */
@Repository
public class LigneCommandeDAOImplJPA implements LigneCommandeDAO {

	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public boolean create(LigneCommande obj) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(LigneCommande obj) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(LigneCommande obj) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LigneCommande find(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
