package com.formation.magasin.model.dao;

import java.util.List;

import com.formation.magasin.model.entity.Client;

/**
 * The Interface ClientDAO.
 */
public interface ClientDAO extends DAO<Client> {

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	List<Client> findAll();

}
