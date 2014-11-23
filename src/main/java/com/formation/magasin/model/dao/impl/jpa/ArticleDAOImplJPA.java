package com.formation.magasin.model.dao.impl.jpa;

import java.sql.SQLException;

import javax.persistence.EntityManager;

import com.formation.magasin.model.dao.ArticleDAO;
import com.formation.magasin.model.entity.Article;

/**
 * The Class ArticleDAOImplJPA.
 */
public class ArticleDAOImplJPA implements ArticleDAO {

	/** The entity manager. */
	private EntityManager entityManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.magasin.model.dao.DAO#create(java.lang.Object)
	 */
	@Override
	public boolean create(Article obj) throws SQLException {
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
	public boolean delete(Article obj) throws SQLException {
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
	public boolean update(Article obj) throws SQLException {
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
	public Article find(Integer id) throws SQLException {
		if (id == null) {
			return null;
		}
		return entityManager.find(Article.class, id);
	}

}
