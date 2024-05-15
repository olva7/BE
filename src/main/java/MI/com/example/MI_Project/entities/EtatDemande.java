package MI.com.example.MI_Project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "etat_demande")
public class EtatDemande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_etat_demande")
    private Integer idEtatDemande;
    private String libEtatDemande;
    @OneToMany(mappedBy = "etatDemande")
    @JsonIgnore
    private List<DemandeEstate> demandeEstateList;
}
