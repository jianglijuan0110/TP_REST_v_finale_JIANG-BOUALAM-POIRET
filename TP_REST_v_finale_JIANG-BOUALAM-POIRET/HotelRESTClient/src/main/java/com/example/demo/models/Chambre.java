package com.example.demo.models;
import java.util.Objects;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Chambre {
	/*ATTRIBUTS*/
	private long id;
	private int nbLits;
	private float prixParNuit;
	
	public Chambre() {
		super();
	}

	public Chambre(int nbLits, float prixParNuit) {
		this.nbLits = nbLits;
		this.prixParNuit = prixParNuit;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNbLits() {
		return nbLits;
	}

	public void setNbLits(int nbLits) {
		this.nbLits = nbLits;
	}

	public float getPrixParNuit() {
		return prixParNuit;
	}

	public void setPrixParNuit(float prixParNuit) {
		this.prixParNuit = prixParNuit;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nbLits, prixParNuit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chambre other = (Chambre) obj;
		return id == other.id && nbLits == other.nbLits
				&& Float.floatToIntBits(prixParNuit) == Float.floatToIntBits(other.prixParNuit);
	}

	@Override
	public String toString() {
		return "Chambre [id=" + id + ", nbLits=" + nbLits + ", prixParNuit=" + prixParNuit + "]";
	}

}
