package com.formation.magasin.model.dao.impl.memory;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.formation.magasin.model.dao.LigneCommandeDAO;
import com.formation.magasin.model.entity.LigneCommande;

/**
 * The Class LigneCommandeDAOImpl.
 */
public class LigneCommandeDAOImplMemory implements LigneCommandeDAO {

	private final Map<Integer, LigneCommande> listLigneCommandes = new HashMap<Integer, LigneCommande>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.magasin.model.dao.DAO#create(java.lang.Object)
	 */
	@Override
	public boolean create(LigneCommande obj) throws SQLException {
		if (obj == null || obj.getId() == null) {
			return Boolean.FALSE;
		}
		if (listLigneCommandes.containsKey(obj.getId())) {
			return Boolean.FALSE;
		}
		listLigneCommandes.put(obj.getId(), obj);
		return Boolean.TRUE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.magasin.model.dao.DAO#delete(java.lang.Object)
	 */
	@Override
	public boolean delete(LigneCommande obj) throws SQLException {
		if (obj == null || obj.getId() == null) {
			return Boolean.FALSE;
		}
		if (!listLigneCommandes.containsKey(obj.getId())) {
			return Boolean.FALSE;
		}
		listLigneCommandes.remove(obj.getId());
		return Boolean.TRUE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.magasin.model.dao.DAO#update(java.lang.Object)
	 */
	@Override
	public boolean update(LigneCommande obj) throws SQLException {
		if (obj == null || obj.getId() == null) {
			return Boolean.FALSE;
		}
		if (!listLigneCommandes.containsKey(obj.getId())) {
			return Boolean.FALSE;
		}
		listLigneCommandes.put(obj.getId(), obj);
		return Boolean.TRUE;
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
		if (!listLigneCommandes.containsKey(id)) {
			return null;
		}
		return listLigneCommandes.get(id);
	}

}
