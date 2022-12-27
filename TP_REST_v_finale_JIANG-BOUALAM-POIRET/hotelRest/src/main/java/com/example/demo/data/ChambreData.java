package com.example.demo.data;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.models.Chambre;
import com.example.demo.models.Reservation;
import com.example.demo.repositories.ChambreRepository;
import com.example.demo.repositories.ReservationRepository;


@Configuration
public class ChambreData {
	/*ATTRIBUTES*/
	private Logger logger = LoggerFactory.getLogger(ChambreData.class);
	//private Logger logger1 = LoggerFactory.getLogger(ChambreData.class);
	
	
	@Bean
	public CommandLineRunner initDatabase(ChambreRepository repository,ReservationRepository repositoryR) {
		return args -> {
		logger.info("Preloading database with " + repository.save(
		new Chambre(2,10)));
		logger.info("Preloading database with " + repository.save(
		new Chambre(4,25)));
	//	};
		logger.info("Preloading database with " + repositoryR.save(
				new Reservation(221222,221224,1)));
				};
	}
}
