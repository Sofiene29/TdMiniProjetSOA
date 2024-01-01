package fr.insa.mas.InscriptionMicroservice.controller;

import fr.insa.mas.InscriptionMicroservice.model.Utilisateur;
import fr.insa.mas.InscriptionMicroservice.repository.UtilisateurRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;



@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurRepository utilisateurRepository;
    
    @Autowired
    private RestTemplate restTemplate;

    // Méthode pour récupérer un utilisateur par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Utilisateur> getUtilisateurById(@PathVariable Long id) {
        Utilisateur utilisateur = utilisateurRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé avec l'id : " + id));
        return ResponseEntity.ok().body(utilisateur);
    }

    // Méthode pour créer un nouvel utilisateur
    @PostMapping("/")
    public ResponseEntity<Utilisateur> createUtilisateur(@RequestBody Utilisateur utilisateur) {
        Utilisateur savedUser = utilisateurRepository.save(utilisateur);
        return ResponseEntity.ok(savedUser);
    } 

    // Méthode pour update un utilisateur
    @PutMapping("/{id}")
    public Utilisateur updateUtilisateur(@PathVariable(value = "id") Long utilisateurId, @RequestBody Utilisateur userDetails) {
        Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId)
        		.orElseThrow(() -> new IllegalArgumentException("Utilisateur not found for this id :: " + utilisateurId));

        utilisateur.setNom(userDetails.getNom());
        utilisateur.setEmail(userDetails.getEmail());
        utilisateur.setMotDePasse(userDetails.getMotDePasse());
        utilisateur.setRole(userDetails.getRole());
        

        final Utilisateur updatedUtilisateur = utilisateurRepository.save(utilisateur);
        return updatedUtilisateur;
    }
    
 // Méthode pour récupérer tous les utilisateurs
    @GetMapping("/")
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }
    
 	// Méthode pour supprimer utilisateur
    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteUtilisateur(@PathVariable(value = "id") Long utilisateurId) {
        Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId).orElseThrow(() -> new IllegalArgumentException("Utilisateur not found for this id :: " + utilisateurId));

        utilisateurRepository.delete(utilisateur);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


}


