package com.formation.magasin.model.dao.impl.memory;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.formation.magasin.model.dao.CommandeDAO;
import com.formation.magasin.model.entity.Commande;

/**
 * The Class CommandeDAOImplMemory.
 */
public class CommandeDAOImplMemory implements CommandeDAO {

	/** The list commandes. */
	private final Map<Integer, Commande> listCommandes = new HashMap<Integer, Commande>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.magasin.model.dao.DAO#create(java.lang.Object)
	 */
	@Override
	public boolean create(Commande obj) throws SQLException {
		if (obj == null) {
			return Boolean.FALSE;
		}
		if (obj.getId() == null || obj.getClient() == null) {
			return Boolean.FALSE;
		}
		if (listCommandes.containsKey(obj.getId())) {
			return Boolean.FALSE;
		}
		listCommandes.put(obj.getId(), obj);
		return Boolean.TRUE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.magasin.model.dao.DAO#delete(java.lang.Object)
	 */
	@Override
	public boolean delete(Commande obj) throws SQLException {
		if (obj == null || obj.getId() == null) {
			return Boolean.FALSE;
		}
		if (!listCommandes.containsKey(obj.getId())) {
			return Boolean.FALSE;
		}
		listCommandes.remove(obj.getId());
		return Boolean.TRUE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.magasin.model.dao.DAO#update(java.lang.Object)
	 */
	@Override
	public boolean update(Commande obj) throws SQLException {
		if (obj == null || obj.getId() == null) {
			return Boolean.FALSE;
		}
		if (!listCommandes.containsKey(obj.getId())) {
			return Boolean.FALSE;
		}
		listCommandes.put(obj.getId(), obj);
		return Boolean.TRUE;
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
		if (!listCommandes.containsKey(id)) {
			return null;
		}
		return listCommandes.get(id);
	}

	/**
	 * Gets the list commandes.
	 *
	 * @return the list commandes
	 */
	public Map<Integer, Commande> getListCommandes() {
		return listCommandes;
	}

}
