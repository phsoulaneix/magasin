package com.formation.magasin.model.manager.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.magasin.model.dao.ArticleDAO;
import com.formation.magasin.model.dao.ClientDAO;
import com.formation.magasin.model.dao.CommandeDAO;
import com.formation.magasin.model.dao.LigneCommandeDAO;
import com.formation.magasin.model.entity.Client;
import com.formation.magasin.model.entity.Commande;
import com.formation.magasin.model.entity.LigneCommande;
import com.formation.magasin.model.manager.MagasinManager;

/**
 * The Class BanqueManagerImpl.
 */
@Service
public class MagasinManagerImpl implements MagasinManager {

	/** The client dao. */
	@Autowired
	private ClientDAO clientDao;

	/** The compte dao. */
	@Autowired
	private CommandeDAO commandeDao;

	/** The argent dao. */
	@Autowired
	private ArticleDAO articleDao;

	/** The ligne commande dao. */
	@Autowired
	private LigneCommandeDAO ligneCommandeDao;

	public MagasinManagerImpl() {
		super();
	}

	/**
	 * Instantiates a new magasin manager impl.
	 *
	 * @param clientDao
	 *            the client dao
	 * @param commandeDao
	 *            the commande dao
	 * @param articleDao
	 *            the article dao
	 * @param ligneCommandeDao
	 *            the ligne commande dao
	 */
	public MagasinManagerImpl(ClientDAO clientDao, CommandeDAO commandeDao,
			ArticleDAO articleDao, LigneCommandeDAO ligneCommandeDao) {
		super();
		this.clientDao = clientDao;
		this.commandeDao = commandeDao;
		this.articleDao = articleDao;
		this.ligneCommandeDao = ligneCommandeDao;
	}

	public ClientDAO getClientDao() {
		return clientDao;
	}

	public void setClientDao(ClientDAO clientDao) {
		this.clientDao = clientDao;
	}

	public CommandeDAO getCommandeDao() {
		return commandeDao;
	}

	public void setCommandeDao(CommandeDAO commandeDao) {
		this.commandeDao = commandeDao;
	}

	public ArticleDAO getArticleDao() {
		return articleDao;
	}

	public void setArticleDao(ArticleDAO articleDao) {
		this.articleDao = articleDao;
	}

	public LigneCommandeDAO getLigneCommandeDao() {
		return ligneCommandeDao;
	}

	public void setLigneCommandeDao(LigneCommandeDAO ligneCommandeDao) {
		this.ligneCommandeDao = ligneCommandeDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.formation.magasin.model.service.MagasinManager#addCommande(com.formation
	 * .magasin.model.entity.Commande)
	 */
	@Override
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

}
