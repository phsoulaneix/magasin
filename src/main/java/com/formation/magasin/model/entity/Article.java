package com.formation.magasin.model.entity;

/**
 * The Class Article.
 */
public abstract class Article {
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	abstract public Integer getId();

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	abstract public void setId(Integer id);

	/**
	 * Gets the nom.
	 *
	 * @return the nom
	 */
	abstract public String getNom();

	/**
	 * Sets the nom.
	 *
	 * @param nom
	 *            the new nom
	 */
	abstract public void setNom(String nom);

	/**
	 * Gets the prix.
	 *
	 * @return the prix
	 */
	abstract public Integer getPrix();

	/**
	 * Sets the prix.
	 *
	 * @param prix
	 *            the new prix
	 */
	abstract public void setPrix(Integer prix);
}
