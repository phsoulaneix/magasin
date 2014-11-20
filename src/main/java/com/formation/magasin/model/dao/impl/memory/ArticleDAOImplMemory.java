package com.formation.magasin.model.dao.impl.memory;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.formation.magasin.model.dao.ArticleDAO;
import com.formation.magasin.model.entity.Article;

/**
 * The Class ArgentDAOImplMemory.
 */
public class ArticleDAOImplMemory implements ArticleDAO {

	/** The articles. */
	private final Map<Integer, Article> listArticles = new HashMap<Integer, Article>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.banque.model.dao.DAO#create(java.lang.Object)
	 */
	@Override
	public boolean create(Article obj) throws SQLException {
		if (obj == null || obj.getId() == null) {
			return Boolean.FALSE;
		}
		if (listArticles.containsKey(obj.getId())) {
			return Boolean.FALSE;
		}
		listArticles.put(obj.getId(), obj);
		return Boolean.TRUE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.banque.model.dao.DAO#delete(java.lang.Object)
	 */
	@Override
	public boolean delete(Article obj) throws SQLException {
		if (obj == null || obj.getId() == null) {
			return Boolean.FALSE;
		}
		if (!listArticles.containsKey(obj.getId())) {
			return Boolean.FALSE;
		}
		listArticles.remove(obj.getId());
		return Boolean.TRUE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.banque.model.dao.DAO#update(java.lang.Object)
	 */
	@Override
	public boolean update(Article obj) throws SQLException {
		if (obj == null || obj.getId() == null) {
			return Boolean.FALSE;
		}
		if (!listArticles.containsKey(obj.getId())) {
			return Boolean.FALSE;
		}
		listArticles.put(obj.getId(), obj);
		return Boolean.TRUE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.banque.model.dao.DAO#find(java.lang.Integer)
	 */
	@Override
	public Article find(Integer id) throws SQLException {
		if (id == null) {
			return null;
		}
		if (!listArticles.containsKey(id)) {
			return null;
		}
		return listArticles.get(id);
	}

}
