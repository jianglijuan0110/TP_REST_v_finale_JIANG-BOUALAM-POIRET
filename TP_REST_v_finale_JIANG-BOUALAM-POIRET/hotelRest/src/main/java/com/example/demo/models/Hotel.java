package com.example.demo.models;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

public class Hotel {
	/* ATTRIBUTS */
	private String nom;
	private int nbEtoiles;

	private ArrayList<Chambre> chambres;
	
	
	/* CONSTRUCTORS */
	public Hotel() {
		nom = "";
		chambres = new ArrayList<>();
	
	}


	public Hotel(String nom, int nbEtoiles, ArrayList<Chambre> chambres) {
		super();
		this.nom = nom;
		this.nbEtoiles = nbEtoiles;
		this.chambres = chambres;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public int getNbEtoiles() {
		return nbEtoiles;
	}


	public void setNbEtoiles(int nbEtoiles) {
		this.nbEtoiles = nbEtoiles;
	}


	public ArrayList<Chambre> getChambres() {
		return chambres;
	}


	public void setChambres(ArrayList<Chambre> chambres) {
		this.chambres = chambres;
	}


	@Override
	public int hashCode() {
		return Objects.hash(chambres, nbEtoiles, nom);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hotel other = (Hotel) obj;
		return Objects.equals(chambres, other.chambres) && nbEtoiles == other.nbEtoiles
				&& Objects.equals(nom, other.nom);
	}


	@Override
	public String toString() {
		return "Hotel [nom=" + nom + ", nbEtoiles=" + nbEtoiles + ", chambres=" + chambres + "]";
	}

}
