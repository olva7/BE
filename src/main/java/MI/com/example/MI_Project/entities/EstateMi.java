package MI.com.example.MI_Project.entities;

import MI.com.example.MI_Project.security.entities.AppUser;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "estate_mi")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idEstateMI")

public class EstateMi implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estate", nullable = false)
    private Integer idEstateMI;

    //@NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "id_user", nullable = false)
   // @JsonBackReference
    @JsonBackReference
    private AppUser idUser;

    //@NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "id_type", nullable = false)
    private TypeEstateMi idTypeEstate;

    //@NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    //@OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "id_localisation")
    private LocalisationMi idLocalisation;

    @Column(name = "surfacie_en_m_")
    private Double surfacieEnM;

    @Size(max = 20)
    @Column(name = "address_estate", length = 20)
    private String addressEstate;

    @Column(name = "disponibilite")
    private LocalDate disponibilite;
    private String categorieMiTag;

    @Column(name = "date_ajout")
    private LocalDate dateAjout;

    @Column(name = "date_construction")
    private LocalDate dateConstruction;

    @Column(name = "nbre_composants")
    private Integer nbreComposants;

    @Column(name = "prix_totale")
    private BigDecimal prixTotale;

    @Column(name = "prix_en_m_")
    private BigDecimal prixEnM;

    @Size(max = 23)
    @Column(name = "latitude", length = 23)
    private String latitude;

    @Size(max = 25)
    @Column(name = "longitude", length = 25)
    private String longitude;
    @Column(name = "apport_propre")
    private Integer apportPropre;
    @Column(name = "etat_estate")
    private Integer etatEstate;
    @Column(name = "apport_propre_minimal")
    private Integer apportPropreMinimal;
    @Column(name = "loyer")
    private Integer loyer;
    @Column(name = "lib_estate")
    private String libEstate;

    @OneToMany(mappedBy = "idEstate", fetch = FetchType.EAGER)
    private Set<EtatMi> etatMis = new HashSet<>();

    @OneToMany(mappedBy = "idEstate", fetch = FetchType.EAGER)
    private Set<CaracteristiqueEstateMi> caracteristiqueEstateMis = new HashSet<>();

    @OneToMany(mappedBy = "idEstate", fetch = FetchType.EAGER)
    private Set<CaracteristiqueComposant> caracteristiqueComposants = new HashSet<>();

    @OneToMany(mappedBy = "idEstate", fetch = FetchType.EAGER)
    private Set<GalerieMi> galerieMis = new HashSet<>();
    @OneToMany(mappedBy = "idEstate", fetch = FetchType.EAGER)

    private Set<ComposantEstateMi> composantEstateMiList = new HashSet<>();



}