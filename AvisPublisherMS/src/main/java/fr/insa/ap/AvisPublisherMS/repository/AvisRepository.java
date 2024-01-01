package fr.insa.ap.AvisPublisherMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.insa.ap.AvisPublisherMS.model.Avis;

public interface AvisRepository extends JpaRepository<Avis, Long> {
}
