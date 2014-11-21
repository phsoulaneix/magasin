package com.formation.magasin.model.manager;

import com.formation.magasin.model.dao.ArticleDAO;
import com.formation.magasin.model.dao.ClientDAO;
import com.formation.magasin.model.dao.CommandeDAO;
import com.formation.magasin.model.dao.LigneCommandeDAO;
import com.formation.magasin.model.entity.Client;
import com.formation.magasin.model.entity.Commande;

/**
 * The Interface MagasinManager.
 */
public interface MagasinManager {

	public ClientDAO getClientDao();

	public void setClientDao(ClientDAO clientDao);

	public CommandeDAO getCommandeDao();

	public void setCommandeDao(CommandeDAO commandeDao);

	public ArticleDAO getArticleDao();

	public void setArticleDao(ArticleDAO articleDao);

	public LigneCommandeDAO getLigneCommandeDao();

	public void setLigneCommandeDao(LigneCommandeDAO ligneCommandeDao);

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
