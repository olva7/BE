package MI.com.example.MI_Project.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "caracteristique_estate_mi")
public class CaracteristiqueEstateMi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_caracteristique_estate", nullable = false)
    private Integer idCaracteristiqueEstate;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "id_estate", nullable = false)
    private EstateMi idEstate;

    @Size(max = 30)
    @Column(name = "service_associe", length = 30)
    private String serviceAssocie;

    @Size(max = 20)
    @Column(name = "caracteristique_tag", length = 20)
    private String caracteristiqueTag;

    @Size(max = 40)
    @Column(name = "valeur_caracteristique", length = 40)
    private String valeurCaracteristique;

    @Column(name = "prix_supplementaire")
    private BigDecimal prixSupplementaire;

    @Column(name = "surface_caracteristique")
    private Double surfaceCaracteristique;

}