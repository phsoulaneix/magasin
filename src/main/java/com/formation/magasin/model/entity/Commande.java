package com.formation.magasin.model.entity;

import java.util.List;

/**
 * The Class Commande.
 */
public abstract class Commande {

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
	 * Gets the lignes commande.
	 *
	 * @return the lignes commande
	 */
	abstract public List<LigneCommande> getLignesCommande();

	/**
	 * Sets the lignes commande.
	 *
	 * @param lignesCommande
	 *            the new lignes commande
	 */
	abstract public void setLignesCommande(List<LigneCommande> lignesCommande);

	/**
	 * Gets the client.
	 *
	 * @return the client
	 */
	abstract public Client getClient();

	/**
	 * Sets the client.
	 *
	 * @param client
	 *            the new client
	 */
	abstract public void setClient(Client client);

	/**
	 * Adds the ligne commande.
	 *
	 * @param ligne
	 *            the ligne
	 */
	public void addLigneCommande(LigneCommande ligne) {
		getLignesCommande().add(ligne);
	}
}
