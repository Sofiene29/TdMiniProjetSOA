package fr.insa.gb.GestionBenevolatsMS.model;


import javax.persistence.*;

@Entity
@Table(name = "propositions_aide")
public class PropositionAide {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "benevole_id")
    private Long benevoleId;

    private String description;

    private String date;

    private PRStatus statut; 

    // Getters
    public Long getId() {
        return id;
    }

    public Long getBenevoleId() {
        return benevoleId;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public PRStatus getStatut() {
        return statut;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setBenevoleId(Long benevoleId) {
        this.benevoleId = benevoleId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setStatut(PRStatus statut) {
        this.statut = statut;
    }
    
}

