package com.formation.magasin.model.dao.impl.memory;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.formation.magasin.model.dao.ClientDAO;
import com.formation.magasin.model.entity.Client;

/**
 * The Class ClientDAOImplMemory.
 */
public class ClientDAOImplMemory implements ClientDAO {

	private final Map<Integer, Client> listClient = new HashMap<Integer, Client>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.magasin.model.dao.DAO#create(java.lang.Object)
	 */
	@Override
	public boolean create(Client obj) throws SQLException {
		if (obj == null || obj.getId() == null) {
			return Boolean.FALSE;
		}
		if (listClient.containsKey(obj.getId())) {
			return Boolean.FALSE;
		}
		listClient.put(obj.getId(), obj);
		return Boolean.TRUE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.magasin.model.dao.DAO#delete(java.lang.Object)
	 */
	@Override
	public boolean delete(Client obj) throws SQLException {
		if (obj == null || obj.getId() == null) {
			return Boolean.FALSE;
		}
		if (!listClient.containsKey(obj.getId())) {
			return Boolean.FALSE;
		}
		listClient.remove(obj.getId());
		return Boolean.TRUE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.magasin.model.dao.DAO#update(java.lang.Object)
	 */
	@Override
	public boolean update(Client obj) throws SQLException {
		if (obj == null || obj.getId() == null) {
			return Boolean.FALSE;
		}
		if (!listClient.containsKey(obj.getId())) {
			return Boolean.FALSE;
		}
		listClient.put(obj.getId(), obj);
		return Boolean.TRUE;
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
		if (!listClient.containsKey(id)) {
			return null;
		}
		return listClient.get(id);
	}

}
