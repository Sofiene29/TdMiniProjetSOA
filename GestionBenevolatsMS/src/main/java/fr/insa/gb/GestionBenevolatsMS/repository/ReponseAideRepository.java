package fr.insa.gb.GestionBenevolatsMS.repository;


import fr.insa.gb.GestionBenevolatsMS.model.ReponseAide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReponseAideRepository extends JpaRepository<ReponseAide, Long> {
}
