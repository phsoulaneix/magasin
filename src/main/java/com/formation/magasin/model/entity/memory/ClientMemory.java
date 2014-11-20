package com.formation.magasin.model.entity.memory;

import java.util.ArrayList;
import java.util.List;

import com.formation.magasin.model.entity.Client;
import com.formation.magasin.model.entity.Commande;

/**
 * The Class Client.
 */
public class ClientMemory extends Client {

	/** The id. */
	private Integer id;

	/** The nom. */
	private String nom;

	/** The prenom. */
	private String prenom;

	/** The liste commande. */
	private List<Commande> listeCommande;

	/**
	 * Instantiates a new client memory.
	 *
	 * @param id
	 *            the id
	 * @param nom
	 *            the nom
	 * @param prenom
	 *            the prenom
	 */
	public ClientMemory(Integer id, String nom, String prenom) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.listeCommande = new ArrayList<Commande>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.magasin.model.entity.Client#getId()
	 */
	@Override
	public Integer getId() {
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.magasin.model.entity.Client#setId(java.lang.Integer)
	 */
	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Sets the prenom.
	 *
	 * @param prenom
	 *            the new prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.magasin.model.entity.Client#getCommande()
	 */
	@Override
	public List<Commande> getCommande() {
		return listeCommande;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.magasin.model.entity.Client#getNom()
	 */
	@Override
	public String getNom() {
		return nom;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.magasin.model.entity.Client#getPremon()
	 */
	@Override
	public String getPremon() {
		return prenom;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.magasin.model.entity.Client#getListeCommande()
	 */
	@Override
	public List<Commande> getListeCommande() {
		return listeCommande;
	}

	/**
	 * Gets the prenom.
	 *
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.formation.magasin.model.entity.Client#setPremon(java.lang.String)
	 */
	@Override
	public void setPremon(String prenom) {
		this.prenom = prenom;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.magasin.model.entity.Client#setNom(java.lang.String)
	 */
	@Override
	public void setNom(String nom) {
		this.nom = nom;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.formation.magasin.model.entity.Client#setListeCommande(java.util.
	 * List)
	 */
	@Override
	public void setListeCommande(List<Commande> listeCommande) {
		this.listeCommande = listeCommande;
	}

}
