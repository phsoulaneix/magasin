package com.formation.magasin.model.entity.memory;

import java.util.ArrayList;
import java.util.List;

import com.formation.magasin.model.entity.Client;
import com.formation.magasin.model.entity.Commande;
import com.formation.magasin.model.entity.LigneCommande;

/**
 * The Class Compte.
 */
public class CommandeMemory extends Commande {

	/** The id. */
	private Integer id;

	/** Liste des lignes de la commande. */
	private List<LigneCommande> lignesCommande = new ArrayList<LigneCommande>();

	/** Le client. */
	private Client client;

	/**
	 * Instantiates a new commande memory.
	 */
	public CommandeMemory() {
		super();
	}

	/**
	 * Instantiates a new commande memory.
	 *
	 * @param id
	 *            the id
	 * @param client
	 *            the client
	 */
	public CommandeMemory(Integer id, Client client) {
		super();
		this.id = id;
		this.client = client;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.magasin.model.entity.Commande#getId()
	 */
	@Override
	public Integer getId() {
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.magasin.model.entity.Commande#setId(java.lang.Integer)
	 */
	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.magasin.model.entity.Commande#getLignesCommande()
	 */
	@Override
	public List<LigneCommande> getLignesCommande() {
		return lignesCommande;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.formation.magasin.model.entity.Commande#setLignesCommande(java.util
	 * .List)
	 */
	@Override
	public void setLignesCommande(List<LigneCommande> lignesCommande) {
		this.lignesCommande = lignesCommande;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.magasin.model.entity.Commande#getClient()
	 */
	@Override
	public Client getClient() {
		return client;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.formation.magasin.model.entity.Commande#setClient(com.formation.magasin
	 * .model.entity.Client)
	 */
	@Override
	public void setClient(Client client) {
		this.client = client;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((lignesCommande == null) ? 0 : lignesCommande.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final CommandeMemory other = (CommandeMemory) obj;
		if (client == null) {
			if (other.client != null) {
				return false;
			}
		} else if (!client.equals(other.client)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (lignesCommande == null) {
			if (other.lignesCommande != null) {
				return false;
			}
		} else if (!lignesCommande.equals(other.lignesCommande)) {
			return false;
		}
		return true;
	}

}
