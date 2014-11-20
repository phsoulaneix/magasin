package com.formation.magasin.model.entity.jpa;

import java.util.List;

import com.formation.magasin.model.entity.Client;
import com.formation.magasin.model.entity.Commande;
import com.formation.magasin.model.entity.LigneCommande;

public class CommandeJPA extends Commande {

	public CommandeJPA(Integer id, Client client) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setId(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<LigneCommande> getLignesCommande() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLignesCommande(List<LigneCommande> lignesCommande) {
		// TODO Auto-generated method stub

	}

	@Override
	public Client getClient() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setClient(Client client) {
		// TODO Auto-generated method stub

	}

}
