package fr.insa.gb.GestionBenevolatsMS.model;


import javax.persistence.*;

@Entity
@Table(name = "reponses_aide")
public class ReponseAide {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "benevole_id")
    private Long benevoleId;

    @Column(name = "demande_aide_id")
    private Long demandeAideId;

    @Column(name = "status")
    private PRStatus status;

    // Getters et Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBenevoleId() {
        return benevoleId;
    }

    public void setBenevoleId(Long benevoleId) {
        this.benevoleId = benevoleId;
    }

    public Long getDemandeAideId() {
        return demandeAideId;
    }

    public void setDemandeAideId(Long demandeAideId) {
        this.demandeAideId = demandeAideId;
    }

    public PRStatus getStatus() {
        return status;
    }

    public void setStatus(PRStatus status) {
        this.status = status;
    }
}

