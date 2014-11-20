package com.formation.magasin.model.entity;

/**
 * The Class LigneCommande.
 */
public abstract class LigneCommande {

	/**
	 * Gets the article.
	 *
	 * @return the article
	 */
	abstract public Article getArticle();

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	abstract public Integer getId();

	abstract public void setId(Integer id);

	/**
	 * Gets the quantité.
	 *
	 * @return the quantité
	 */
	abstract public Integer getQuantité();

	/**
	 * Sets the quantité.
	 *
	 * @param quantité
	 *            the new quantité
	 */
	abstract public void setQuantité(Integer quantité);

	/**
	 * Sets the article.
	 *
	 * @param article
	 *            the new article
	 */
	abstract public void setArticle(Article article);

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
