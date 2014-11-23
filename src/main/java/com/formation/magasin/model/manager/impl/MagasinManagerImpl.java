package com.formation.magasin.model.manager.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.formation.magasin.model.dao.ArticleDAO;
import com.formation.magasin.model.dao.ClientDAO;
import com.formation.magasin.model.dao.CommandeDAO;
import com.formation.magasin.model.dao.LigneCommandeDAO;
import com.formation.magasin.model.entity.Article;
import com.formation.magasin.model.entity.Client;
import com.formation.magasin.model.entity.Commande;
import com.formation.magasin.model.entity.LigneCommande;
import com.formation.magasin.model.manager.MagasinManager;

/**
 * The Class BanqueManagerImpl.
 */
public class MagasinManagerImpl implements MagasinManager {

	/** The client dao. */
	private ClientDAO clientDao;

	/** The compte dao. */
	private CommandeDAO commandeDao;

	/** The argent dao. */
	private ArticleDAO articleDao;

	/** The ligne commande dao. */
	private LigneCommandeDAO ligneCommandeDao;

	/**
	 * Instantiates a new magasin manager impl.
	 */
	public MagasinManagerImpl() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.formation.magasin.model.service.MagasinManager#addCommande(com.formation
	 * .magasin.model.entity.Commande)
	 */
	@Override
	@Transactional(readOnly = false)
	public Boolean addCommande(Commande commande) {
		if (commande.getClient() == null) {
			return Boolean.FALSE;
		}
		try {
			// Verification
			for (final LigneCommande ligne : commande.getLignesCommande()) {
				if (ligne.getArticle() == null
						|| articleDao.find(ligne.getArticle().getId()) == null) {
					return Boolean.FALSE;
				}
			}
			// sauvegarde
			commandeDao.create(commande);
			for (final LigneCommande ligne : commande.getLignesCommande()) {
				ligneCommandeDao.create(ligne);
			}
		} catch (final SQLException e) {
			e.printStackTrace();
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.formation.magasin.model.service.MagasinManager#removeCommande(com.
	 * formation.magasin.model.entity.Commande)
	 */
	@Override
	@Transactional(readOnly = false)
	public Boolean removeCommande(Commande commande) {
		try {
			for (final LigneCommande ligne : commande.getLignesCommande()) {
				ligneCommandeDao.delete(ligne);
			}
			commandeDao.delete(commande);
		} catch (final SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.formation.magasin.model.service.MagasinManager#addClient(com.formation
	 * .magasin.model.entity.Client)
	 */
	@Override
	@Transactional(readOnly = false)
	public Boolean addClient(Client client) {
		try {
			// Verification
			if (client == null) {
				return Boolean.FALSE;
			}
			for (final Commande commande : client.getCommande()) {
				if (commande.getLignesCommande() == null) {
					return Boolean.FALSE;
				}
				for (final LigneCommande ligne : commande.getLignesCommande()) {
					if (ligne.getArticle() == null
							|| articleDao.find(ligne.getArticle().getId()) == null) {
						return Boolean.FALSE;
					}
				}
			}
			// Sauvegarde
			clientDao.create(client);
			for (final Commande commande : client.getCommande()) {
				commandeDao.create(commande);
				for (final LigneCommande ligne : commande.getLignesCommande()) {
					ligneCommandeDao.create(ligne);
				}
			}
		} catch (final SQLException e) {
			try {
				clientDao.delete(client);
			} catch (final SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return Boolean.FALSE;
		}

		return Boolean.TRUE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.formation.magasin.model.manager.MagasinManager#addArticle(com.formation
	 * .magasin.model.entity.Article)
	 */
	@Override
	@Transactional(readOnly = false)
	public Boolean addArticle(Article article) {
		try {
			articleDao.create(article);
		} catch (final SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.magasin.model.manager.MagasinManager#getClients()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Client> getClients() {
		return clientDao.findAll();
	}

}
