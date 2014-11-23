package com.formation.magasin.model.manager;

import java.util.List;

import com.formation.magasin.model.entity.Article;
import com.formation.magasin.model.entity.Client;
import com.formation.magasin.model.entity.Commande;

/**
 * The Interface MagasinManager.
 */
public interface MagasinManager {

	/**
	 * Adds the article.
	 *
	 * @param article
	 *            the article
	 * @return the boolean
	 */
	public Boolean addArticle(Article article);

	/**
	 * Gets the clients.
	 *
	 * @return the clients
	 */
	public List<Client> getClients();

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
