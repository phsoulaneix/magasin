package com.formation.magasin.model.manager.impl;

import java.sql.SQLException;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
 * The Class MagasinManagerImplTest.
 */
@RunWith(MockitoJUnitRunner.class)
public class MagasinManagerImplTest {

	/** The magasin manager. */
	private MagasinManager magasinManager;

	/** The client dao. */
	@InjectMocks
	private final ClientDAO clientDao = Mockito.mock(ClientDAO.class);

	/** The commande dao. */
	@InjectMocks
	private final CommandeDAO commandeDao = Mockito.mock(CommandeDAO.class);

	/** The article dao. */
	@InjectMocks
	private final ArticleDAO articleDao = Mockito.mock(ArticleDAO.class);

	/** The ligne commande dao. */
	@InjectMocks
	private final LigneCommandeDAO ligneCommandeDao = Mockito
	.mock(LigneCommandeDAO.class);

	/**
	 * Sets the up.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		// clientDao = Mockito.mock(ClientDAO.class);
		// commandeDao = Mockito.mock(CommandeDAO.class);
		// articleDao = Mockito.mock(ArticleDAO.class);
		// ligneCommandeDao = Mockito.mock(LigneCommandeDAO.class);

		final ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring_test.xml");

		magasinManager = (MagasinManager) ctx.getBean("magasinManagerImpl");

	}

	/**
	 * Tear down.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test add client.
	 *
	 * @throws SQLException
	 *             the SQL exception
	 */
	@Test
	public void testAddClient() throws SQLException {

		final Client client = new Client("nom", "prenom");
		final Commande commande = new Commande();
		final Article article1 = new Article("toto", 10);
		final Article article2 = new Article("titi", 20);
		magasinManager.addArticle(article1);
		magasinManager.addArticle(article2);
		final LigneCommande ligne1 = new LigneCommande(article1, 1);
		final LigneCommande ligne2 = new LigneCommande(article2, 2);

		commande.addLigneCommande(ligne1);
		commande.addLigneCommande(ligne2);
		client.addCommande(commande);

		Mockito.when(clientDao.create(Mockito.any(Client.class))).thenReturn(
				Boolean.TRUE);
		Mockito.when(commandeDao.create(Mockito.any(Commande.class)))
		.thenReturn(Boolean.TRUE);
		Mockito.when(articleDao.create(Mockito.any(Article.class))).thenReturn(
				Boolean.TRUE);
		Mockito.when(articleDao.find(1)).thenReturn(article1);
		Mockito.when(articleDao.find(2)).thenReturn(article2);
		Mockito.when(ligneCommandeDao.create(Mockito.any(LigneCommande.class)))
		.thenReturn(Boolean.TRUE);
		final Boolean b1 = magasinManager.addClient(client);
		Assert.assertTrue(b1);

		final Boolean b2 = magasinManager.addClient(null);
		Assert.assertFalse(b2);
	}
}
