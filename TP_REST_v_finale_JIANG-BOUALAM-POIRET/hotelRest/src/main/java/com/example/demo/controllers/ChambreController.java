package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Chambre;
import com.example.demo.models.Reservation;
import com.example.demo.repositories.ChambreRepository;
import com.example.demo.repositories.ReservationRepository;

@RestController
public class ChambreController {
	@Autowired
	private ChambreRepository c;
	@Autowired
	private ReservationRepository r; 
	private static final String uri = "hotelservice/api";
	
	/*METHODE*/ /*
	@GetMapping(uri+"/recherche")
	public long recherche(int dateArrivee, int dateDepart, int nbPers) {
		long id = 0;
		// chercher si j'ai le nombre de lits dans une seule chambre
	if ( ((Chambre) c).getId()!= ((Reservation) r).getIdChambre() ) {
		 id = ((Chambre) c).getId();
	}
	else if(nbPers <= ((Chambre) c).getNbLits() && 
				dateArrivee >= ((Reservation) r).getDateDepart()
				){
			//  vérifier si la chambre est déjà réservée pour les dates données	
			id =  ((Chambre) c).getId();
		}
		return id;
	} */
	
		
	/* METHODS */ 
    @GetMapping(uri+"/chambres")
    public List<Chambre> getAllChambres(){
    return c.findAll(); } 

    @GetMapping(uri+"/chambres/{id}")
    public Optional<Chambre> getChambreById(@PathVariable long id) {
    return c.findById(id); }  

    
}
