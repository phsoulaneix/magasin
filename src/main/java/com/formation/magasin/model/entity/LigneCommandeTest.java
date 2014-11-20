package com.formation.magasin.model.entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.formation.magasin.model.entity.memory.ArticleMemory;
import com.formation.magasin.model.entity.memory.LigneCommandeMemory;

public class LigneCommandeTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetPrixTotal() {
		final Article article = new ArticleMemory(1, "nom", 10);
		final LigneCommande ligne = new LigneCommandeMemory(1, article, 3);
		final Integer result = ligne.getPrixTotal();
		Assert.assertEquals(result, new Integer(30));

	}

}
