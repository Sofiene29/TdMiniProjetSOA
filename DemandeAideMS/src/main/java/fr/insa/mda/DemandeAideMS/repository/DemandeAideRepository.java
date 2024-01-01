package fr.insa.mda.DemandeAideMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.insa.mda.DemandeAideMS.model.DemandeAide;

public interface DemandeAideRepository extends JpaRepository<DemandeAide, Long> {
    
}


