package com.formation.magasin.model.dao.impl.jpa;

import static org.junit.Assert.fail;

import java.sql.SQLException;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.formation.magasin.model.dao.ArticleDAO;
import com.formation.magasin.model.dao.impl.jpa.ArticleDAOImplJPA;
import com.formation.magasin.model.entity.Article;
import com.formation.magasin.model.entity.jpa.ArticleJPA;

/**
 * The Class ArgentDAOImplJPATest.
 */
@RunWith(JUnit4.class)
public class ArticleDAOImplJPATest {

	/** The article dao. */
	private ArticleDAO articleDAO;

	/**
	 * Sets the up.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Before
	public void setUp() throws Exception {
		articleDAO = new ArticleDAOImplJPA();
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
			// Article OK
			final Article articleCreate = new ArticleJPA(1, "article 1", 10);
			final Boolean insert1 = articleDAO.create(articleCreate);
			Assert.assertTrue(insert1);
			final Article articleTrouver = articleDAO.find(1);
			Assert.assertNotNull(articleTrouver);

			// Article null
			final Article articleNull = null;
			final Boolean insert2 = articleDAO.create(articleNull);
			Assert.assertFalse(insert2);

			// Id null
			final Article articleIdNull = new ArticleJPA(null, "article null",
					10);
			final Boolean insert3 = articleDAO.create(articleIdNull);
			Assert.assertFalse(insert3);

		} catch (final SQLException e1) {
			fail("Création impossible");
		}
	}

	/**
	 * Test delete.
	 */
	@Test
	public void testDelete() {
		try {
			final Article articleCreate1 = new ArticleJPA(1, "Article 1", 10);
			final Article articleCreate2 = new ArticleJPA(2, "Article 2", 10);
			final Article articleCreate3 = new ArticleJPA(3, "Article 2", 10);
			articleDAO.create(articleCreate1);
			articleDAO.create(articleCreate2);
			articleDAO.create(articleCreate3);

			final Boolean delete1 = articleDAO.delete(articleCreate2);
			Assert.assertTrue(delete1);
			final Article articleSupprimer = articleDAO.find(2);
			Assert.assertNull(articleSupprimer);

			final Article articleNotCreate = new ArticleJPA(4, "Article 2", 10);
			final Boolean delete2 = articleDAO.delete(articleNotCreate);
			Assert.assertFalse(delete2);

		} catch (final SQLException e) {
			fail("Suppression impossible");
		}

	}

	/**
	 * Test update.
	 *
	 * @throws SQLException
	 *             the SQL exception
	 */
	@Test
	public void testUpdate() throws SQLException {
		// Article OK
		final Article articleCreate = new ArticleJPA(1, "article 1", 10);
		articleDAO.create(articleCreate);
		final Boolean update1 = articleDAO.update(articleCreate);
		Assert.assertTrue(update1);

		// Article avec un nom modifier
		final Article articleCreateAndSetNom = new ArticleJPA(2, "article 1",
				10);
		articleDAO.create(articleCreateAndSetNom);
		articleCreateAndSetNom.setNom("Article 2");
		final Boolean update2 = articleDAO.update(articleCreateAndSetNom);
		Assert.assertTrue(update2);

		// Article avec un id modifier à null
		final Article articleCreateAndSetIdNull = new ArticleJPA(3,
				"article 1", 10);
		articleDAO.create(articleCreateAndSetIdNull);
		articleCreateAndSetIdNull.setId(null);
		final Boolean update3 = articleDAO.update(articleCreateAndSetIdNull);
		Assert.assertFalse(update3);

		// Article null
		final Article articleNull = null;
		final Boolean update4 = articleDAO.update(articleNull);
		Assert.assertFalse(update4);

		// Id null
		final Article articleIdNull = new ArticleJPA(null, "article null", 10);
		final Boolean update5 = articleDAO.delete(articleIdNull);
		Assert.assertFalse(update5);

		// Id no create
		final Article articleNotCreate = new ArticleJPA(6, "article", 10);
		final Boolean update6 = articleDAO.delete(articleNotCreate);
		Assert.assertFalse(update6);

	}

	/**
	 * Test find.
	 */
	@Test
	public void testFind() {
		try {
			final Article articleCreate1 = new ArticleJPA(1, "Article 1", 10);
			final Article articleCreate2 = new ArticleJPA(2, "Article 2", 10);
			final Article articleCreate3 = new ArticleJPA(3, "Article 2", 10);
			articleDAO.create(articleCreate1);
			articleDAO.create(articleCreate2);
			articleDAO.create(articleCreate3);

			final Article articleTrouver = articleDAO.find(2);
			Assert.assertNotNull(articleTrouver);
			Assert.assertEquals(articleTrouver, articleCreate2);
			;

			final Article articleNonTrouver = articleDAO.find(4);
			Assert.assertNull(articleNonTrouver);
		} catch (final SQLException e) {
			fail("Suppression impossible");
		}
	}

}
