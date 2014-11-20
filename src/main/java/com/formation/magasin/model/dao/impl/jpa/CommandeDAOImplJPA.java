package com.formation.magasin.model.dao.impl.jpa;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.formation.magasin.model.dao.CommandeDAO;
import com.formation.magasin.model.entity.Commande;

/**
 * The Class CommandeDAOImplJPA.
 */
public class CommandeDAOImplJPA implements CommandeDAO {

	private final Map<Integer, Commande> listCommandes = new HashMap<Integer, Commande>();

	@Override
	public boolean create(Commande obj) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Commande obj) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Commande obj) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Commande find(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
