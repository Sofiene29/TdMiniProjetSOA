package fr.insa.soap; 

import java.net.MalformedURLException;

import javax.xml.ws.Endpoint;

public class PublierAvisApplication {
	public static String host="localhost";
	public static short port=8089; 
	
	public void demarrerService() {
		String url="http://"+host+":"+port+"/"; 
		Endpoint.publish(url, new PublicationAvisWS());
	}
 public static void main(String [] args) throws MalformedURLException {
	 new PublierAvisApplication().demarrerService();
	 System.out.println("Service a démarré");
 }
}
