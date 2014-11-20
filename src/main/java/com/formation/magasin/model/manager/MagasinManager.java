package com.formation.magasin.model.manager;

import com.formation.magasin.model.entity.Client;
import com.formation.magasin.model.entity.Commande;

/**
 * The Interface MagasinManager.
 */
public interface MagasinManager {

	/**
	 * Adds the client.
	 *
	 * @param client
	 *            the client
	 * @return the boolean
	 */
	public Boolean addClient(Client client);

	/**
	 * Adds the commande.
	 *
	 * @param commande
	 *            the commande
	 * @return the boolean
	 */
	public Boolean addCommande(Commande commande);

	/**
	 * Removes the commande.
	 *
	 * @param commande
	 *            the commande
	 * @return the boolean
	 */
	public Boolean removeCommande(Commande commande);

}
