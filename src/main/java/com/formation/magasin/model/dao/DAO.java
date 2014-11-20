package com.formation.magasin.model.dao;

import java.sql.SQLException;

/**
 * The Interface DAO.
 *
 * @param <T>
 *            the generic type
 */
public interface DAO<T> {

	/**
	 * Méthode de création.
	 *
	 * @param obj
	 *            the obj
	 * @return boolean
	 * @throws SQLException
	 *             the SQL exception
	 */
	public abstract boolean create(T obj) throws SQLException;

	/**
	 * Méthode pour effacer.
	 *
	 * @param obj
	 *            the obj
	 * @return boolean. true si la suppression à eut lien, false sinon
	 * @throws SQLException
	 *             the SQL exception
	 */
	public abstract boolean delete(T obj) throws SQLException;

	/**
	 * Méthode de mise à jour.
	 *
	 * @param obj
	 *            the obj
	 * @return boolean
	 * @throws SQLException
	 *             the SQL exception
	 */
	public abstract boolean update(T obj) throws SQLException;

	/**
	 * Méthode de recherche des informations.
	 *
	 * @param id
	 *            the id
	 * @return T
	 * @throws SQLException
	 *             the SQL exception
	 */
	public abstract T find(Integer id) throws SQLException;
}
