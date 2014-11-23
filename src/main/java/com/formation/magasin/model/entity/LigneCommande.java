package com.formation.magasin.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * The Class LigneCommande.
 */
@Entity
public class LigneCommande {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/** The article. */
	@ManyToOne
	private Article article;

	/** The quantité. */
	private Integer quantité;

	/**
	 * Instantiates a new ligne commande.
	 */
	public LigneCommande() {
		super();
	}

	/**
	 * Instantiates a new ligne commande memory.
	 *
	 * @param article
	 *            the article
	 * @param quantité
	 *            the quantité
	 */
	public LigneCommande(Article article, Integer quantité) {
		super();
		this.article = article;
		this.quantité = quantité;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Gets the quantité.
	 *
	 * @return the quantité
	 */
	public Integer getQuantité() {
		return quantité;
	}

	/**
	 * Sets the quantité.
	 *
	 * @param quantité
	 *            the new quantité
	 */
	public void setQuantité(Integer quantité) {
		this.quantité = quantité;
	}

	/**
	 * Gets the article.
	 *
	 * @return the article
	 */
	public Article getArticle() {
		return article;
	}

	/**
	 * Sets the article.
	 *
	 * @param article
	 *            the new article
	 */
	public void setArticle(Article article) {
		this.article = article;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(Integer id) {
		this.id = id;

	}

	/**
	 * Gets the prix total.
	 *
	 * @return the prix total
	 */
	public Integer getPrixTotal() {
		final Article article = getArticle();
		if (article != null) {
			return getQuantité() * article.getPrix();
		}
		return 0;
	}
}
