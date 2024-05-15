package MI.com.example.MI_Project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "localisation_mi")
public class LocalisationMi {
    @Id
    @Size(max = 12)
    @Column(name = "id_localisation", length = 12)
    private Integer idLocalisationMI;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "loc_id_localisation")
    private LocalisationMi locIdLocalisation;

    @Size(max = 245)
    @Column(name = "nom_localisation", length = 245)
    private String nomLocalisation;

    @Size(max = 250)
    @Column(name = "logo_localisation", length = 250)
    private String logoLocalisation;

    @Column(name = "code_postal_localisation")
    private Integer codePostalLocalisation;

    @Column(name = "atitude_localisation")
    private Double atitudeLocalisation;

    @Column(name = "longitude__")
    private Double longitude;

    @Size(max = 250)
    @Column(name = "description_localisation", length = 250)
    private String descriptionLocalisation;

    @Size(max = 3)
    @Column(name = "abreviation_localisation", length = 3)
    private String abreviationLocalisation;

    @OneToMany(mappedBy = "idLocalisation")
    //@JsonIgnore
    private Set<EstateMi> estateMis = new LinkedHashSet<>();

    @OneToMany(mappedBy = "locIdLocalisation")
   // @JsonIgnore
    private Set<LocalisationMi> localisationMis = new LinkedHashSet<>();

}