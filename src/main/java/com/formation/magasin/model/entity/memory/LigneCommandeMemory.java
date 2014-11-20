package com.formation.magasin.model.entity.memory;

import com.formation.magasin.model.entity.Article;
import com.formation.magasin.model.entity.LigneCommande;

/**
 * The Class LigneCommandeMemory.
 */
public class LigneCommandeMemory extends LigneCommande {

	/** The id. */
	private Integer id;

	/** The article. */
	private Article article;

	/** The quantité. */
	private Integer quantité;

	/**
	 * Instantiates a new ligne commande memory.
	 *
	 * @param id
	 *            the id
	 * @param article
	 *            the article
	 * @param quantité
	 *            the quantité
	 */
	public LigneCommandeMemory(Integer id, Article article, Integer quantité) {
		super();
		this.id = id;
		this.article = article;
		this.quantité = quantité;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.magasin.model.entity.LigneCommande#getId()
	 */
	@Override
	public Integer getId() {
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.magasin.model.entity.LigneCommande#getQuantité()
	 */
	@Override
	public Integer getQuantité() {
		return quantité;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.formation.magasin.model.entity.LigneCommande#setQuantité(java.lang
	 * .Integer)
	 */
	@Override
	public void setQuantité(Integer quantité) {
		this.quantité = quantité;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.magasin.model.entity.LigneCommande#getArticle()
	 */
	@Override
	public Article getArticle() {
		return article;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.formation.magasin.model.entity.LigneCommande#setArticle(com.formation
	 * .magasin.model.entity.Article)
	 */
	@Override
	public void setArticle(Article article) {
		this.article = article;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;

	}

}
