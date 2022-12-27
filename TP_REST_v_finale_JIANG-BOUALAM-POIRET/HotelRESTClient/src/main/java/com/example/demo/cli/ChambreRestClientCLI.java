package com.example.demo.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.models.Chambre;



@Component
public class ChambreRestClientCLI extends AbstractMain implements CommandLineRunner {

	/*ATTRIBUTS*/
	@Autowired
	private RestTemplate proxy;
	private IntegerInputProcessor inputProcessor;
	private static String URI_CHAMBRES;
	private static String URI_CHAMBRES_ID;
	private static String URI_CHAMBRES_RECHERCHE;
	private static String URI_CHAMBRES_RESERVER;
	
	/*METHODS */
	@Override
	public void run(String... args) throws Exception {
		BufferedReader inputReader;
		String userInput = "";
		
		try {
			inputReader = new BufferedReader(
					new InputStreamReader(System.in));
			setTestServiceUrl(inputReader); 
			URI_CHAMBRES = SERVICE_URL + "/chambres";
			URI_CHAMBRES_ID = URI_CHAMBRES + "/{id}";
			URI_CHAMBRES_RECHERCHE = SERVICE_URL + "/recherche";
			URI_CHAMBRES_RESERVER = SERVICE_URL + "/reserver";
			
			
			do { 
				menu();
			    userInput = inputReader.readLine();
			    processUserInput(inputReader, userInput, proxy);
			    Thread.sleep(3000);
			} while(!userInput.equals(QUIT)); 
			
		}
		
		catch (IOException e) { e.printStackTrace();
		}
		
		catch (InterruptedException e) { e.printStackTrace();
		} 
	}

	

	@Override
	protected boolean validServiceUrl() {
		return SERVICE_URL.equals(
	            "http://localhost:8080/hotelservice/api");
	}

	@Override
	protected void menu() {
		StringBuilder builder = new StringBuilder();
		builder.append(QUIT+". Quit.");
		builder.append("\n1. Chambres"); 
		builder.append("\n2. Chambre ID"); 
		builder.append("\n3. Rechercher"); 
		builder.append("\n4. Reserver"); 
		System.out.println(builder);	
	}
	
	private void processUserInput(BufferedReader reader, String userInput, RestTemplate proxy) {
	
			Map<String, String> params = new HashMap<>();
			inputProcessor = new IntegerInputProcessor(reader);
		try {
			switch(userInput) {
		
				case "1":
					String uri = URI_CHAMBRES;
					Chambre[] chambres = proxy.getForObject(uri, Chambre[].class);
					System.out.println("chambres:");
					Arrays.asList(chambres)
					.forEach(System.out::println);
					System.out.println();
					break;
				
				case "2":
					uri = URI_CHAMBRES_ID;
					System.out.println("Chambre ID:");
					int id = inputProcessor.process();
					params.put("id", String.valueOf(id));
					Chambre chambre = proxy.getForObject(uri, Chambre.class, params);
					System.out.println(String.format("Chambre with ID %s: %s", id, chambre));
					System.out.println();
					break;
				case "3":
					uri = URI_CHAMBRES_RECHERCHE;
					System.out.println("DateArivée:");
					int dateArivee = inputProcessor.process();
					params.put("dateArivee", String.valueOf(dateArivee));
					System.out.println("DateDepart:");
					int dateDepart = inputProcessor.process();
					params.put("dateDepart", String.valueOf(dateDepart));
					System.out.println("Nombre de personnes:");
					int nbPers = inputProcessor.process();
					params.put("nbPers", String.valueOf(nbPers));
					//proxy.recherche(uri, params);
					System.out.println();
					break;

				case "4":
					uri = URI_CHAMBRES_RESERVER;
					
					System.out.println();
					break;

							
				case QUIT: 
					System.out.println("Bye...");
					return;
				default:
					System.err.println("Sorry, wrong input. Please try again.");
					return;
			}
		}
			catch (IOException e) {
		        e.printStackTrace();
		    }
		
	}
		

}
