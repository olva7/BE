package MI.com.example.MI_Project.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "etat_estate_mi")
public class EtatEstateMi implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_etat_estate", nullable = false)
    private Integer idEtatEstateMI;

    @Size(max = 30)
    @Column(name = "etat_estate", length = 30)
    private String etatEstate;

    @Size(max = 20)
    @Column(name = "details_contrat", length = 20)
    private String detailsContrat;

    @OneToMany(mappedBy = "idEtatEstate")
    private Set<EtatMi> etatMis = new LinkedHashSet<>();

}