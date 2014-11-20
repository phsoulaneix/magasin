package com.formation.magasin.model.entity.jpa;

import java.util.List;

import com.formation.magasin.model.entity.Client;
import com.formation.magasin.model.entity.Commande;

public class ClientJPA extends Client {

	public ClientJPA(Integer id, String nom, String prenom) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Commande> getCommande() {
		// TODO Auto-generated method stub
		return null;
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
	public String getNom() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setNom(String nom) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getPremon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPremon(String prenom) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Commande> getListeCommande() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setListeCommande(List<Commande> listCommande) {
		// TODO Auto-generated method stub

	}

}
