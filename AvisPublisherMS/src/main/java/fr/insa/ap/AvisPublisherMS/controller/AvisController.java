package fr.insa.ap.AvisPublisherMS.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import fr.insa.ap.AvisPublisherMS.model.*;
import fr.insa.ap.AvisPublisherMS.repository.*;

@RestController
@RequestMapping("/avis")
public class AvisController {

    @Autowired
    private AvisRepository avisRepository;
    
    @Autowired
    private RestTemplate restTemplate;

    // Publier un avis
    @PostMapping()
    public Avis createAvis(@RequestBody Avis avis) {
        return avisRepository.save(avis);
    }

    // Consulter tous les avis
    @GetMapping("/")
    public List<Avis> getAllAvis() {
        return avisRepository.findAll();
    }

    // Consulter un avis spécifique
    @GetMapping("/{id}")
    public ResponseEntity<Avis> getAvisById(@PathVariable(value = "id") Long id) {
        Avis avis = avisRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Avis not found for this id :: " + id));
        return ResponseEntity.ok().body(avis);
    }

    // Supprimer un avis
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAvis(@PathVariable(value = "id") Long id) {
        Avis avis = avisRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Avis not found for this id :: " + id));

        avisRepository.delete(avis);
        return ResponseEntity.ok().build();
    }
}