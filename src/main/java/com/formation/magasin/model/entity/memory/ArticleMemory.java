package com.formation.magasin.model.entity.memory;

import com.formation.magasin.model.entity.Article;

/**
 * The Class Argent.
 */
public class ArticleMemory extends Article {

	/** The id. */
	private Integer id;

	/** The nom. */
	private String nom;

	/** The prix. */
	private Integer prix;

	/**
	 * Instantiates a new argent.
	 *
	 * @param id
	 *            the id
	 * @param nom
	 *            the nom
	 * @param prix
	 *            the prix
	 */
	public ArticleMemory(Integer id, String nom, Integer prix) {
		super();
		this.id = id;
		this.nom = nom;
		this.prix = prix;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.banque.model.entity.Article#getNom()
	 */
	@Override
	public String getNom() {
		return this.nom;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.banque.model.entity.Article#setNom(java.lang.String)
	 */
	@Override
	public void setNom(String nom) {
		this.nom = nom;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.banque.model.entity.Article#getPrix()
	 */
	@Override
	public Integer getPrix() {
		return prix;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.banque.model.entity.Article#setPrix(java.lang.Integer)
	 */
	@Override
	public void setPrix(Integer prix) {
		this.prix = prix;
	}

}
