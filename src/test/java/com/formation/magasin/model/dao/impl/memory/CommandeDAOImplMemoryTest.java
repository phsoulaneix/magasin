package com.formation.magasin.model.dao.impl.memory;

import static org.junit.Assert.fail;

import java.sql.SQLException;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.formation.magasin.model.dao.CommandeDAO;
import com.formation.magasin.model.entity.Client;
import com.formation.magasin.model.entity.Commande;
import com.formation.magasin.model.entity.memory.ClientMemory;
import com.formation.magasin.model.entity.memory.CommandeMemory;

/**
 * The Class CommandeDAOImplMemoryTest.
 */
public class CommandeDAOImplMemoryTest {

	/** The commande dao. */
	private CommandeDAO commandeDAO;

	/**
	 * Sets the up.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Before
	public void setUp() throws Exception {
		commandeDAO = new CommandeDAOImplMemory();
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
			final Client client = new ClientMemory(1, "nom", "prenom");

			final Commande commandeOk = new CommandeMemory(1, client);
			final Boolean createCommandeOk = commandeDAO.create(commandeOk);
			Assert.assertTrue(createCommandeOk);

			final Commande commandeKoId = new CommandeMemory(null, client);
			final Boolean createCommandeKOId = commandeDAO.create(commandeKoId);
			Assert.assertFalse(createCommandeKOId);

			final Commande commandeKoClient = new CommandeMemory(2, null);
			final Boolean createCommandeKOClient = commandeDAO
					.create(commandeKoClient);
			Assert.assertFalse(createCommandeKOClient);

			final Boolean createCommandeKONull = commandeDAO.create(null);
			Assert.assertFalse(createCommandeKONull);

			final Boolean createCommandeKOExisteDeja = commandeDAO
					.create(commandeOk);
			Assert.assertFalse(createCommandeKOExisteDeja);

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
			final Client client = new ClientMemory(1, "nom", "prenom");

			final Commande commandeOk1 = new CommandeMemory(1, client);
			final Commande commandeOk2 = new CommandeMemory(2, client);
			final Commande commandeOk3 = new CommandeMemory(3, client);
			commandeDAO.create(commandeOk1);
			commandeDAO.create(commandeOk2);
			commandeDAO.create(commandeOk3);

			final Boolean delete1 = commandeDAO.delete(commandeOk2);
			Assert.assertTrue(delete1);
			final Commande commandeSupprimer = commandeDAO.find(2);
			Assert.assertNull(commandeSupprimer);

			final Commande commandeNotCreate = new CommandeMemory(4, client);
			final Boolean delete2 = commandeDAO.delete(commandeNotCreate);
			Assert.assertFalse(delete2);

			final Commande commandeIdNull = new CommandeMemory(null, client);
			final Boolean delete3 = commandeDAO.delete(commandeIdNull);
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
	 *             the SQL exception
	 */
	@Test
	public void testUpdate() throws SQLException {
		final Client client = new ClientMemory(1, "nom", "prenom");

		final Commande commandeOk1 = new CommandeMemory(1, client);
		final Commande commandeOk2 = new CommandeMemory(2, client);
		final Commande commandeOk3 = new CommandeMemory(3, client);
		commandeDAO.create(commandeOk1);
		commandeDAO.create(commandeOk2);
		commandeDAO.create(commandeOk3);
		commandeOk1.setId(null);
		final Boolean update1 = commandeDAO.update(commandeOk1);
		Assert.assertFalse(update1);
		final Boolean update2 = commandeDAO.update(commandeOk2);
		Assert.assertTrue(update2);

		final Commande CommandeTrouver = commandeDAO.find(2);
		Assert.assertEquals(CommandeTrouver, commandeOk2);

		final Boolean update3 = commandeDAO.update(null);
		Assert.assertFalse(update3);
	}

	/**
	 * Test find ok.
	 *
	 * @throws SQLException
	 *             the SQL exception
	 */
	@Test
	public void testFindOK() throws SQLException {
		final Client client = new ClientMemory(1, "nom", "prenom");

		final Commande commandeOk1 = new CommandeMemory(1, client);
		final Commande commandeOk2 = new CommandeMemory(2, client);
		final Commande commandeOk3 = new CommandeMemory(3, client);
		commandeDAO.create(commandeOk1);
		commandeDAO.create(commandeOk2);
		commandeDAO.create(commandeOk3);

		final Commande commandeTrouver = commandeDAO.find(2);

		Assert.assertNotNull(commandeTrouver);
		Assert.assertEquals(commandeOk2, commandeTrouver);
	}

}
