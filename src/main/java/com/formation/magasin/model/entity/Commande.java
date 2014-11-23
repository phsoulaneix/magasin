package com.formation.magasin.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * The Class Commande.
 */
@Entity
public class Commande {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/** Liste des lignes de la commande. */
	@OneToMany
	private List<LigneCommande> lignesCommande = new ArrayList<LigneCommande>();

	/** Le client. */
	@ManyToOne
	private Client client;

	/**
	 * Instantiates a new commande memory.
	 */
	public Commande() {
		super();
	}

	/**
	 * Instantiates a new commande memory.
	 *
	 * @param client
	 *            the client
	 */
	public Commande(Client client) {
		super();
		this.client = client;
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
	 * Gets the lignes commande.
	 *
	 * @return the lignes commande
	 */
	public List<LigneCommande> getLignesCommande() {
		return lignesCommande;
	}

	/**
	 * Sets the lignes commande.
	 *
	 * @param lignesCommande
	 *            the new lignes commande
	 */
	public void setLignesCommande(List<LigneCommande> lignesCommande) {
		this.lignesCommande = lignesCommande;
	}

	/**
	 * Gets the client.
	 *
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * Sets the client.
	 *
	 * @param client
	 *            the new client
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * Adds the ligne commande.
	 *
	 * @param ligne
	 *            the ligne
	 */
	public void addLigneCommande(LigneCommande ligne) {
		getLignesCommande().add(ligne);
	}
}
