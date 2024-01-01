package fr.insa.mda.DemandeAideMS.controller;




import fr.insa.mda.DemandeAideMS.model.*;
import fr.insa.mda.DemandeAideMS.repository.DemandeAideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/demandesAide")
public class DemandeAideController {

    @Autowired
    private DemandeAideRepository demandeAideRepository;
    
    @Autowired
    private RestTemplate restTemplate;
    
    // Créer une nouvelle demande d'aide il suffit de donner la description
    @PostMapping()
    public DemandeAide createDemandeAide(@RequestBody DemandeAide demandeAide) {
    	demandeAide.setStatus(MissionStatus.EN_ATTENTE);
        return demandeAideRepository.save(demandeAide);
    }

    // Récupérer toutes les demandes d'aide
    @GetMapping("/")
    public List<DemandeAide> getAllDemandesAide() {
        return demandeAideRepository.findAll();
    }

    // Récupérer une demande d'aide par son ID
    @GetMapping("/{id}")
    public ResponseEntity<DemandeAide> getDemandeAideById(@PathVariable(value = "id") Long id) {
        DemandeAide demandeAide = demandeAideRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DemandeAide not found for this id :: " + id));
        return ResponseEntity.ok().body(demandeAide);
    }

    // Mettre à jour une demande d'aide
    @PutMapping("/{id}")
    public ResponseEntity<DemandeAide> updateDemandeAide(@PathVariable(value = "id") Long id,
                                                         @RequestBody DemandeAide demandeDetails) {
        DemandeAide demandeAide = demandeAideRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DemandeAide not found for this id :: " + id));

        demandeAide.setDescription(demandeDetails.getDescription());
        demandeAide.setStatus(demandeDetails.getStatus());

        final DemandeAide updatedDemandeAide = demandeAideRepository.save(demandeAide);
        return ResponseEntity.ok(updatedDemandeAide);
    }

    // Supprimer une demande d'aide
    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteDemandeAide(@PathVariable(value = "id") Long id) {
        DemandeAide demandeAide = demandeAideRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DemandeAide not found for this id :: " + id));

        demandeAideRepository.delete(demandeAide);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
 // GERER LE STATUT DE LA MISSION
    @PostMapping("/statut/{id}")
    public ResponseEntity<?> stateMission(
            @PathVariable(value = "id") Long id, 
            @RequestParam("status") MissionStatus status, 
            @RequestParam(value = "description", required = false) String description) {

        Optional<DemandeAide> missionOptional = demandeAideRepository.findById(id);
        if (!missionOptional.isPresent()) {
            return ResponseEntity.badRequest().body("Mission not found for this id :: " + id);
        }

        DemandeAide mission = missionOptional.get();
        
        // Mettre à jour le statut et la description si elle est fournie
        mission.setStatus(status);
        if (status == MissionStatus.NON_VALIDEE && (description == null || description.isEmpty())) {
            return ResponseEntity.badRequest().body("Un motif doit être fourni pour une mission non validée.");
        }
        if (description != null && !description.isEmpty()) {
            mission.setDescription(description);
        }

        final DemandeAide updatedMission = demandeAideRepository.save(mission);
        return ResponseEntity.ok(updatedMission);
    }
}


