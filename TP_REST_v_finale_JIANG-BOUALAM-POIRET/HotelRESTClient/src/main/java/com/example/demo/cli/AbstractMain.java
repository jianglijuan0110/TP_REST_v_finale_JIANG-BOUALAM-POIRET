package com.example.demo.cli;

import java.io.BufferedReader;
import java.io.IOException;
 
public abstract class AbstractMain {
	public static String SERVICE_URL;
	public static final String QUIT = "0";
	
	protected void setTestServiceUrl(BufferedReader inputReader)
	throws IOException {
		
		System.out.println("Please provide the URL to the web service to consume: ");
		SERVICE_URL = inputReader.readLine();
		
		while(!validServiceUrl()) {
			System.err.println("Error: " + SERVICE_URL + " isn't a valide web service URL."
					+ "Please try again");
			SERVICE_URL = inputReader.readLine();
		}
	}
	
	protected abstract boolean validServiceUrl();
	
	protected abstract void menu();

}
