package fr.insa.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService(serviceName="AvisPublisher")
public class PublicationAvisWS {

	private List<String> avisList = new ArrayList<String>();

    @WebMethod(operationName="publierAvis")
    public String publierAvis(@WebParam(name="nom") String nom, @WebParam(name="avisTexte") String avisTexte) {
        if (nom == null || nom.trim().isEmpty() || avisTexte == null || avisTexte.trim().isEmpty()) {
            return "Erreur : Le nom et l'avis ne peuvent pas être vides.";
        }

        // Limiter la longueur de l'avis à, par exemple, 200 caractères
        if (avisTexte.length() > 200) {
            return "Erreur : L'avis est trop long. Limitez à 200 caractères.";
        }

        // Enregistrement de l'avis
        avisList.add(nom + ": " + avisTexte);

        return "Avis publié : " + avisTexte;
    }

}
