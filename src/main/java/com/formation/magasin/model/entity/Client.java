package com.formation.magasin.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * The Class Client.
 */
@Entity
public class Client {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/** The nom. */
	private String nom;

	/** The prenom. */
	private String prenom;

	/** The liste commande. */
	@OneToMany
	private List<Commande> listeCommande = new ArrayList<Commande>();

	/**
	 * Instantiates a new client.
	 */
	public Client() {
		super();
	}

	/**
	 * Instantiates a new client memory.
	 *
	 * @param nom
	 *            the nom
	 * @param prenom
	 *            the prenom
	 */
	public Client(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
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
	 * Sets the prenom.
	 *
	 * @param prenom
	 *            the new prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Gets the commande.
	 *
	 * @return the commande
	 */
	public List<Commande> getCommande() {
		return listeCommande;
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
	 * Gets the premon.
	 *
	 * @return the premon
	 */
	public String getPremon() {
		return prenom;
	}

	/**
	 * Gets the liste commande.
	 *
	 * @return the liste commande
	 */
	public List<Commande> getListeCommande() {
		return listeCommande;
	}

	/**
	 * Gets the prenom.
	 *
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Sets the premon.
	 *
	 * @param prenom
	 *            the new premon
	 */
	public void setPremon(String prenom) {
		this.prenom = prenom;
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
	 * Sets the liste commande.
	 *
	 * @param listeCommande
	 *            the new liste commande
	 */
	public void setListeCommande(List<Commande> listeCommande) {
		this.listeCommande = listeCommande;
	}

	/**
	 * Adds the commande.
	 *
	 * @param commande
	 *            the commande
	 */
	public void addCommande(Commande commande) {
		listeCommande.add(commande);
	}

}
