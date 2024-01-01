package fr.insa.gb.GestionBenevolatsMS.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import fr.insa.gb.GestionBenevolatsMS.model.PropositionAide;
import fr.insa.gb.GestionBenevolatsMS.repository.PropositionAideRepository;
import fr.insa.gb.GestionBenevolatsMS.model.*;
import fr.insa.gb.GestionBenevolatsMS.repository.ReponseAideRepository;


import java.util.List;

@RestController
@RequestMapping("/propositions")
public class BenevolatController {

    @Autowired
    private PropositionAideRepository propositionAideRepository;
    @Autowired
    private ReponseAideRepository reponseAideRepository; 
    
    @Autowired
    private RestTemplate restTemplate;

    // Ajouter une proposition d'aide
    @PostMapping
    public PropositionAide createProposition(@RequestBody PropositionAide proposition) {
    	proposition.setStatut(PRStatus.EN_ATTENTE);
        return propositionAideRepository.save(proposition);
    }
    public BenevolatController() {
        System.out.println("BenevolatController loaded");
    }
    // Liste des propositions d'aide
    @GetMapping
    public List<PropositionAide> getAllPropositions() {
        return propositionAideRepository.findAll();
    }

    // Mettre à jour une proposition d'aide
    @PutMapping("/{id}")
    public ResponseEntity<PropositionAide> updateProposition(@PathVariable(value = "id") Long propositionId,
                                                             @RequestBody PropositionAide propositionDetails) {
        PropositionAide proposition = propositionAideRepository.findById(propositionId)
                .orElseThrow(() -> new RuntimeException("Proposition not found for this id :: " + propositionId));

        proposition.setDescription(propositionDetails.getDescription());
        proposition.setDate(propositionDetails.getDate());
        proposition.setStatut(propositionDetails.getStatut());

        final PropositionAide updatedProposition = propositionAideRepository.save(proposition);
        return ResponseEntity.ok(updatedProposition);
    }
    
    // Récupérer une proposition d'aide par ID
    @GetMapping("/{id}")
    public ResponseEntity<PropositionAide> getPropositionById(@PathVariable(value = "id") Long propositionId) {
        PropositionAide proposition = propositionAideRepository.findById(propositionId)
                .orElseThrow(() -> new RuntimeException("Proposition not found for this id :: " + propositionId));
        return ResponseEntity.ok().body(proposition);
    }

    // Supprimer une proposition d'aide
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProposition(@PathVariable(value = "id") Long propositionId) {
        PropositionAide proposition = propositionAideRepository.findById(propositionId)
                .orElseThrow(() -> new RuntimeException("Proposition not found for this id :: " + propositionId));
        
        propositionAideRepository.delete(proposition);
        return ResponseEntity.ok().build();
    }
    
    
    
    //REPONSE AUX AIDES 
    // Ajouter une réponse à une demande d'aide
    @PostMapping("/reponses")
    public ReponseAide createReponseAide(@RequestBody ReponseAide reponse) {
    	reponse.setStatus(PRStatus.EN_ATTENTE);
        return reponseAideRepository.save(reponse);
    }

    // Récupérer toutes les réponses d'aide
    @GetMapping("/reponses")
    public List<ReponseAide> getAllReponses() {
        return reponseAideRepository.findAll();
    }

    // Récupérer une réponse d'aide par ID
    @GetMapping("/reponses/{id}")
    public ResponseEntity<ReponseAide> getReponseById(@PathVariable(value = "id") Long id) {
        ReponseAide reponse = reponseAideRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reponse not found for this id :: " + id));
        return ResponseEntity.ok().body(reponse);
    }

    // Mettre à jour une réponse d'aide
    @PutMapping("/reponses/{id}")
    public ResponseEntity<ReponseAide> updateReponse(@PathVariable(value = "id") Long id,
                                                     @RequestBody ReponseAide reponseDetails) {
        ReponseAide reponse = reponseAideRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reponse not found for this id :: " + id));

        reponse.setBenevoleId(reponseDetails.getBenevoleId()); 
        reponse.setDemandeAideId(reponseDetails.getDemandeAideId()); 
        reponse.setStatus(reponseDetails.getStatus()); 

        final ReponseAide updatedReponse = reponseAideRepository.save(reponse);
        return ResponseEntity.ok(updatedReponse);
    }

    // Supprimer une réponse d'aide
    @DeleteMapping("/reponses/{id}")
    public ResponseEntity<?> deleteReponse(@PathVariable(value = "id") Long id) {
        ReponseAide reponse = reponseAideRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reponse not found for this id :: " + id));

        reponseAideRepository.delete(reponse);
        return ResponseEntity.ok().build();
    }
 // Gérer statut d'une proposition d'aide
    @PutMapping("/propositions/statut/{id}")
    public ResponseEntity<?> updateStatutProposition(
            @PathVariable(value = "id") Long id,
            @RequestParam("statut") PRStatus statut) {

        PropositionAide proposition = propositionAideRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proposition not found for this id :: " + id));

        proposition.setStatut(statut);
        final PropositionAide updatedProposition = propositionAideRepository.save(proposition);
        return ResponseEntity.ok(updatedProposition);
    }




    // gérér Statut reponse d'aide
    @PutMapping("/reponses/statut/{id}")
    public ResponseEntity<?> updateStatutReponse(
            @PathVariable(value = "id") Long id,
            @RequestParam("statut") PRStatus statut) {

        ReponseAide reponse = reponseAideRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reponse not found for this id :: " + id));

        reponse.setStatus(statut);
        final ReponseAide updatedReponse = reponseAideRepository.save(reponse);
        return ResponseEntity.ok(updatedReponse);
    }




}
