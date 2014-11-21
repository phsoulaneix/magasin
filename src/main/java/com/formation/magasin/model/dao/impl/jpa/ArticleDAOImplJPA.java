package com.formation.magasin.model.dao.impl.jpa;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.formation.magasin.model.dao.ArticleDAO;
import com.formation.magasin.model.entity.Article;

/**
 * The Class ArticleDAOImplJPA.
 */
@Repository
public class ArticleDAOImplJPA implements ArticleDAO {

	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public boolean create(Article obj) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Article obj) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Article obj) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Article find(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
