package com.formation.magasin.model.dao.impl.jpa;

import static org.junit.Assert.fail;

import java.sql.SQLException;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.formation.magasin.model.dao.LigneCommandeDAO;
import com.formation.magasin.model.dao.impl.jpa.LigneCommandeDAOImplJPA;
import com.formation.magasin.model.entity.Article;
import com.formation.magasin.model.entity.LigneCommande;
import com.formation.magasin.model.entity.jpa.ArticleJPA;
import com.formation.magasin.model.entity.jpa.LigneCommandeJPA;

/**
 * The Class LigneLigneCommandeDAOImplTest.
 */
public class LigneCommandeDAOImplJPATest {

	private LigneCommandeDAO ligneCommandeDAO;

	/**
	 * Sets the up.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Before
	public void setUp() throws Exception {
		ligneCommandeDAO = new LigneCommandeDAOImplJPA();
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
	 * Test create.
	 */
	@Test
	public void testCreate() {
		try {
			final Article article = new ArticleJPA(1, "nom", 10);

			final LigneCommande ligneCommandeOk = new LigneCommandeJPA(1,
					article, 2);
			final Boolean createLigneCommandeOk = ligneCommandeDAO
					.create(ligneCommandeOk);
			Assert.assertTrue(createLigneCommandeOk);

			final LigneCommande ligneCommandeKoId = new LigneCommandeJPA(null,
					article, 2);
			final Boolean createLigneCommandeKOId = ligneCommandeDAO
					.create(ligneCommandeKoId);
			Assert.assertFalse(createLigneCommandeKOId);

			final Boolean createLigneCommandeKONull = ligneCommandeDAO
					.create(null);
			Assert.assertFalse(createLigneCommandeKONull);

			final Boolean createLigneCommandeKOExisteDeja = ligneCommandeDAO
					.create(ligneCommandeOk);
			Assert.assertFalse(createLigneCommandeKOExisteDeja);

		} catch (final SQLException e) {
			e.printStackTrace();
			fail("impossible");
		}
	}

	/**
	 * Test delete.
	 */
	@Test
	public void testDelete() {
		try {
			final Article article = new ArticleJPA(1, "nom", 10);

			final LigneCommande ligneCommandeOk1 = new LigneCommandeJPA(1,
					article, 2);
			final LigneCommande ligneCommandeOk2 = new LigneCommandeJPA(2,
					article, 2);
			final LigneCommande ligneCommandeOk3 = new LigneCommandeJPA(3,
					article, 2);
			ligneCommandeDAO.create(ligneCommandeOk1);
			ligneCommandeDAO.create(ligneCommandeOk2);
			ligneCommandeDAO.create(ligneCommandeOk3);

			final Boolean delete1 = ligneCommandeDAO.delete(ligneCommandeOk2);
			Assert.assertTrue(delete1);
			final LigneCommande ligneCommandeSupprimer = ligneCommandeDAO
					.find(2);
			Assert.assertNull(ligneCommandeSupprimer);

			final LigneCommande ligneCommandeNotCreate = new LigneCommandeJPA(
					4, article, 2);
			final Boolean delete2 = ligneCommandeDAO
					.delete(ligneCommandeNotCreate);
			Assert.assertFalse(delete2);

			final LigneCommande ligneCommandeIdNull = new LigneCommandeJPA(
					null, article, 2);
			final Boolean delete3 = ligneCommandeDAO
					.delete(ligneCommandeIdNull);
			Assert.assertFalse(delete3);

		} catch (final SQLException e) {
			e.printStackTrace();
			fail("Suppression impossible");
		}
	}

	/**
	 * Test update.
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testUpdate() throws SQLException {
		final Article article = new ArticleJPA(1, "nom", 10);

		final LigneCommande ligneCommandeOk1 = new LigneCommandeJPA(1, article,
				2);
		final LigneCommande ligneCommandeOk2 = new LigneCommandeJPA(2, article,
				2);
		final LigneCommande ligneCommandeOk3 = new LigneCommandeJPA(3, article,
				2);
		ligneCommandeDAO.create(ligneCommandeOk1);
		ligneCommandeDAO.create(ligneCommandeOk2);
		ligneCommandeDAO.create(ligneCommandeOk3);
		ligneCommandeOk1.setId(null);
		final Boolean update1 = ligneCommandeDAO.update(ligneCommandeOk1);
		Assert.assertFalse(update1);
		final Boolean update2 = ligneCommandeDAO.update(ligneCommandeOk2);
		Assert.assertTrue(update2);

		final LigneCommande ligneCommandeTrouver = ligneCommandeDAO.find(2);
		Assert.assertEquals(ligneCommandeTrouver, ligneCommandeOk2);

		final Boolean update3 = ligneCommandeDAO.update(null);
		Assert.assertFalse(update3);
	}

	/**
	 * Test find.
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testFind() throws SQLException {
		final Article article = new ArticleJPA(1, "nom", 10);

		final LigneCommande ligneCommandeOk1 = new LigneCommandeJPA(1, article,
				2);
		final LigneCommande ligneCommandeOk2 = new LigneCommandeJPA(2, article,
				2);
		final LigneCommande ligneCommandeOk3 = new LigneCommandeJPA(3, article,
				2);
		ligneCommandeDAO.create(ligneCommandeOk1);
		ligneCommandeDAO.create(ligneCommandeOk2);
		ligneCommandeDAO.create(ligneCommandeOk3);

		final LigneCommande ligneCommandeTrouver = ligneCommandeDAO.find(2);

		Assert.assertNotNull(ligneCommandeTrouver);
		Assert.assertEquals(ligneCommandeOk2, ligneCommandeTrouver);
	}

}
