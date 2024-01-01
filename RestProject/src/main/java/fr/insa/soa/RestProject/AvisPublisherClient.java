package fr.insa.soa.RestProject;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.Form;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class AvisPublisherClient {

    private static final String BASE_URL = "http://localhost:8080/RestProject/webapi";

    public static void main(String[] args) {
        AvisPublisherClient client = new AvisPublisherClient();
        client.testSayHello();
        client.testPublierAvis("Sofiene", "Cestmonavis");
    }

    public void testSayHello() {
        Client client = ClientBuilder.newClient();
        String response = client.target(BASE_URL)
                                .path("avisPublisher/sayHello")
                                .request(MediaType.TEXT_PLAIN)
                                .get(String.class);
        System.out.println(response);
    }

    public void testPublierAvis(String nom, String avisTexte) {
        Client client = ClientBuilder.newClient();
        Response response = client.target(BASE_URL)
                                  .path("avisPublisher/publierAvis")
                                  .request(MediaType.TEXT_PLAIN)
                                  .post(Entity.form(new Form()
                                    .param("nom", nom)
                                    .param("avisTexte", avisTexte)));
        System.out.println(response.readEntity(String.class));
    }
}
