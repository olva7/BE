package MI.com.example.MI_Project.entities;
import MI.com.example.MI_Project.security.dto.AppUserDTO;
import MI.com.example.MI_Project.security.entities.AppUser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "demande_estate")
public class DemandeEstate implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reference;
    private Integer prixDemande;
    private Integer prixTotale;
    private Date dateCreation;
    @ManyToOne
    @JoinColumn(name = "id_etat_demande")
    private EtatDemande etatDemande;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private AppUser appUser;
    @OneToMany(mappedBy = "reference")
    @JsonIgnore
    private Set<DocumentDemande> documentDemandesListe ;


}
