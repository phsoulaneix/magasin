package com.formation.magasin.model.dao.impl.jpa;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.formation.magasin.model.dao.ClientDAO;
import com.formation.magasin.model.entity.Client;

/**
 * The Class ClientDAOImplJPA.
 */
public class ClientDAOImplJPA implements ClientDAO {

	/** The entity manager. */
	private EntityManager entityManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.magasin.model.dao.DAO#create(java.lang.Object)
	 */
	@Override
	public boolean create(Client obj) throws SQLException {
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
	public boolean delete(Client obj) throws SQLException {
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
	public boolean update(Client obj) throws SQLException {
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
	public Client find(Integer id) throws SQLException {
		if (id == null) {
			return null;
		}
		return entityManager.find(Client.class, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.magasin.model.dao.ClientDAO#findAll()
	 */
	@Override
	public List<Client> findAll() {
		final CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<Client> cq = builder.createQuery(Client.class);
		final Root<Client> root = cq.from(Client.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

}
