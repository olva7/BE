package MI.com.example.MI_Project.entities;

import MI.com.example.MI_Project.security.entities.AppUser;
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
@Table(name = "agence_immobiliere_mi")
public class AgenceImmobiliereMi implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_agence", nullable = false)
    private Integer idAgenceImmobilierMI;

    @Size(max = 20)
    @Column(name = "nom_agence", length = 20)
    private String nomAgence;

    @Column(name = "num_tel_mobile")
    private Integer numTelMobile;

    @Size(max = 25)
    @Column(name = "address_agence", length = 25)
    private String addressAgence;

    @Size(max = 30)
    @Column(name = "address_mail", length = 30)
    private String addressMail;

    @Size(max = 40)
    @Column(name = "site_web", length = 40)
    private String siteWeb;

    @Size(max = 45)
    @Column(name = "reseau_sociaux", length = 45)
    private String reseauSociaux;

    @Column(name = "num_tel_fixe")
    private Integer numTelFixe;

    @Column(name = "num_fax")
    private Integer numFax;

    @Size(max = 254)
    @Column(name = "logo_agence", length = 254)
    private String logoAgence;

    @Size(max = 254)
    @Column(name = "description", length = 254)
    private String description;

    @Column(name = "latitude_agence")
    private Double latitudeAgence;

    @Column(name = "longitude_agence")
    private Double longitudeAgence;

    //@OneToMany(mappedBy = "idAgence")
    //private Set<EstateMi> estateMis = new LinkedHashSet<>();
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user")
    private AppUser appUser;



}