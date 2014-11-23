package com.formation.magasin.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * The Class Article.
 */
@Entity
public class Article {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/** The nom. */
	private String nom;

	/** The prix. */
	private Integer prix;

	/**
	 * Instantiates a new article.
	 */
	public Article() {
		super();
	}

	/**
	 * Instantiates a new article.
	 *
	 * @param nom
	 *            the nom
	 * @param prix
	 *            the prix
	 */
	public Article(String nom, int prix) {
		this.nom = nom;
		this.prix = prix;
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
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the nom.
	 *
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Sets the nom.
	 *
	 * @param nom
	 *            the new nom
	 */
	public void setNom(String nom) {
		this.nom = nom;

	}

	/**
	 * Gets the prix.
	 *
	 * @return the prix
	 */
	public Integer getPrix() {
		return prix;
	}

	/**
	 * Sets the prix.
	 *
	 * @param prix
	 *            the new prix
	 */
	public void setPrix(Integer prix) {
		this.prix = prix;

	}
}
