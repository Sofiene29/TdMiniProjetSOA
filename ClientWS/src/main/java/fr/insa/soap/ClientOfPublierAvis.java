package fr.insa.soap;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import fr.insa.soap.wsdltojava.PublicationAvisWS; 
import fr.insa.soap.wsdltojava.AvisPublisher;

public class ClientOfPublierAvis { 
	
	public static void main( String [] args) throws MalformedURLException { 
		final String adresse="http://localhost:8089/analyzer?wsdl"; 
		final URL url=URI.create(adresse).toURL(); 
		final AvisPublisher service = new AvisPublisher(url); 
		final PublicationAvisWS port= service.getPort(PublicationAvisWS.class); 
		String nom="Sofiene"; 
		String avis="Cest mon avis"; 
		System.out.println(port.publierAvis(nom,avis));
	} 

}
