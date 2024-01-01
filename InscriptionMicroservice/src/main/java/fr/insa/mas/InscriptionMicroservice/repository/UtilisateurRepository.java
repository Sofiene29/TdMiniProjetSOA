package fr.insa.mas.InscriptionMicroservice.repository;


import fr.insa.mas.InscriptionMicroservice.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
 
}
