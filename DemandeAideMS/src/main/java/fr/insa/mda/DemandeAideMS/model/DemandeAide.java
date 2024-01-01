package fr.insa.mda.DemandeAideMS.model;

import javax.persistence.*;


@Entity
@Table(name = "demandes_aide")
public class DemandeAide {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "description", nullable = false)
	    private String description;

	    @Column(name = "status")
	    private MissionStatus status;
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public MissionStatus getStatus() {
	        return status;
	    }

	    public void setStatus(MissionStatus status) {
	        this.status = status;
	    }


	    
}



