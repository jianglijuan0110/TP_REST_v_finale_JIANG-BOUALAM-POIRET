package com.example.demo.models;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Reservation {
	/*ATTRIBUTS*/
	private long idReservation;
	private int dateArrivee;
	private int dateDepart;
	private long idChambre;
	/*CONSTRUCTORS*/
	public Reservation() {
	}
	public Reservation(int dateArrivee, int dateDepart, long idChambre) {
		super();
		this.dateArrivee = dateArrivee;
		this.dateDepart = dateDepart;
		this.idChambre = idChambre;
	}
	public long getIdReservation() {
		return idReservation;
	}
	public void setIdReservation(long idReservation) {
		this.idReservation = idReservation;
	}
	public int getDateArrivee() {
		return dateArrivee;
	}
	public void setDateArrivee(int dateArrivee) {
		this.dateArrivee = dateArrivee;
	}
	public int getDateDepart() {
		return dateDepart;
	}
	public void setDateDepart(int dateDepart) {
		this.dateDepart = dateDepart;
	}
	public long getIdChambre() {
		return idChambre;
	}
	public void setIdChambre(long idChambre) {
		this.idChambre = idChambre;
	}
	@Override
	public int hashCode() {
		return Objects.hash(dateArrivee, dateDepart, idChambre, idReservation);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		return dateArrivee == other.dateArrivee && dateDepart == other.dateDepart && idChambre == other.idChambre
				&& idReservation == other.idReservation;
	}
	@Override
	public String toString() {
		return "Reservation [idReservation=" + idReservation + ", dateArrivee=" + dateArrivee + ", dateDepart="
				+ dateDepart + ", idChambre=" + idChambre + "]";
	}
	

}
