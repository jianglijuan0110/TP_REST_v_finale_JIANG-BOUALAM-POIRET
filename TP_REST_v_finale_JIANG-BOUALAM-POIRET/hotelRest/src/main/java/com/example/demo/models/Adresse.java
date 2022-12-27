package com.example.demo.models;

import java.util.Objects;

public class Adresse {
	private String pays;
	private String ville;
	private String rue;
	
	public Adresse() {
		
	}

	public Adresse(String pays, String ville, String rue) {
		super();
		this.pays = pays;
		this.ville = ville;
		this.rue = rue;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	@Override
	public int hashCode() {
		return Objects.hash(pays, rue, ville);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adresse other = (Adresse) obj;
		return Objects.equals(pays, other.pays) && Objects.equals(rue, other.rue) && Objects.equals(ville, other.ville);
	}

	@Override
	public String toString() {
		return "Adresse [pays=" + pays + ", ville=" + ville + ", rue=" + rue + "]";
	}

	
}
