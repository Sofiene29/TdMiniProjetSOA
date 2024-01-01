package fr.insa.soa.RestProject;


import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("avisPublisher")
public class AvisPublisher {

	private List<String> avisList = new ArrayList<>();

    @POST
    @Path("publierAvis")
    @Produces(MediaType.TEXT_PLAIN)
    public Response publierAvis(@FormParam("nom") String nom, @FormParam("avisTexte") String avisTexte) {
        if (nom == null || nom.trim().isEmpty() || avisTexte == null || avisTexte.trim().isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST)
                           .entity("Erreur : Le nom et l'avis ne peuvent pas être vides.")
                           .build();
        }

        // Limiter la longueur de l'avis à, par exemple, 200 caractères
        if (avisTexte.length() > 200) {
            return Response.status(Response.Status.BAD_REQUEST)
                           .entity("Erreur : L'avis est trop long. Limitez à 200 caractères.")
                           .build();
        }

        // Enregistrement de l'avis
        avisList.add(nom + ": " + avisTexte);

        return Response.ok("Avis publié : " + avisTexte).build();
    }
    
    @GET
    @Path("sayHello")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello from the RESTful service!";
    }

}

