package com.formation.magasin.model.dao.impl.jpa;

import static org.junit.Assert.fail;

import java.sql.SQLException;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.formation.magasin.model.dao.ClientDAO;
import com.formation.magasin.model.dao.impl.jpa.ClientDAOImplJPA;
import com.formation.magasin.model.entity.Client;
import com.formation.magasin.model.entity.jpa.ClientJPA;

/**
 * The Class ClientDAOImplJPATest.
 */
public class ClientDAOImplJPATest {

	private ClientDAO clientDAO;

	/**
	 * Sets the up.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Before
	public void setUp() throws Exception {
		clientDAO = new ClientDAOImplJPA();
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

			final Client clientOk = new ClientJPA(1, "nom", "prenom");
			final Boolean createClientOk = clientDAO.create(clientOk);
			Assert.assertTrue(createClientOk);

			final Client clientKoId = new ClientJPA(null, "nom", "prenom");
			final Boolean createClientKOId = clientDAO.create(clientKoId);
			Assert.assertFalse(createClientKOId);

			final Boolean createClientKONull = clientDAO.create(null);
			Assert.assertFalse(createClientKONull);

			final Boolean createClientKOExisteDeja = clientDAO.create(clientOk);
			Assert.assertFalse(createClientKOExisteDeja);

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
			final Client clientOk1 = new ClientJPA(1, "nom", "prenom");
			final Client clientOk2 = new ClientJPA(2, "nom", "prenom");
			final Client clientOk3 = new ClientJPA(3, "nom", "prenom");
			clientDAO.create(clientOk1);
			clientDAO.create(clientOk2);
			clientDAO.create(clientOk3);

			final Boolean delete1 = clientDAO.delete(clientOk2);
			Assert.assertTrue(delete1);
			final Client clientSupprimer = clientDAO.find(2);
			Assert.assertNull(clientSupprimer);

			final Client clientNotCreate = new ClientJPA(4, "nom", "prenom");
			final Boolean delete2 = clientDAO.delete(clientNotCreate);
			Assert.assertFalse(delete2);

			final Client clientIdNull = new ClientJPA(null, "nom", "prenom");
			final Boolean delete3 = clientDAO.delete(clientIdNull);
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
		final Client clientOk1 = new ClientJPA(1, "nom", "prenom");
		final Client clientOk2 = new ClientJPA(2, "nom", "prenom");
		final Client clientOk3 = new ClientJPA(3, "nom", "prenom");
		clientDAO.create(clientOk1);
		clientDAO.create(clientOk2);
		clientDAO.create(clientOk3);
		clientOk1.setId(null);
		final Boolean update1 = clientDAO.update(clientOk1);
		Assert.assertFalse(update1);
		final Boolean update2 = clientDAO.update(clientOk2);
		Assert.assertTrue(update2);

		final Client clientTrouver = clientDAO.find(2);
		Assert.assertEquals(clientTrouver, clientOk2);

		final Boolean update3 = clientDAO.update(null);
		Assert.assertFalse(update3);
	}

	/**
	 * Test find.
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testFind() throws SQLException {
		final Client clientOk1 = new ClientJPA(1, "nom", "prenom");
		final Client clientOk2 = new ClientJPA(2, "nom", "prenom");
		final Client clientOk3 = new ClientJPA(3, "nom", "prenom");
		clientDAO.create(clientOk1);
		clientDAO.create(clientOk2);
		clientDAO.create(clientOk3);

		final Client clientTrouver = clientDAO.find(2);

		Assert.assertNotNull(clientTrouver);
		Assert.assertEquals(clientOk2, clientTrouver);
	}

}
