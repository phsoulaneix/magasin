package com.formation.magasin.model.entity;

import java.util.List;

/**
 * The Class Client.
 */
public abstract class Client {

	/**
	 * Gets the commande.
	 *
	 * @return the commande
	 */
	abstract public List<Commande> getCommande();

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	abstract public Integer getId();

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	abstract public void setId(Integer id);

	/**
	 * Gets the nom.
	 *
	 * @return the nom
	 */
	abstract public String getNom();

	/**
	 * Sets the nom.
	 *
	 * @param nom
	 *            the new nom
	 */
	abstract public void setNom(String nom);

	/**
	 * Gets the premon.
	 *
	 * @return the premon
	 */
	abstract public String getPremon();

	/**
	 * Sets the premon.
	 *
	 * @param prenom
	 *            the new premon
	 */
	abstract public void setPremon(String prenom);

	/**
	 * Gets the liste commande.
	 *
	 * @return the liste commande
	 */
	abstract public List<Commande> getListeCommande();

	/**
	 * Sets the liste commande.
	 *
	 * @param listCommande
	 *            the new liste commande
	 */
	abstract public void setListeCommande(List<Commande> listCommande);

	/**
	 * Adds the commande.
	 *
	 * @param commande
	 *            the commande
	 */
	public void addCommande(Commande commande) {
		getListeCommande().add(commande);
	}

}
