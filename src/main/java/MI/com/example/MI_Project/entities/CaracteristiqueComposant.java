package MI.com.example.MI_Project.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "caracteristique_composant")
public class CaracteristiqueComposant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_caracteristique_composant", nullable = false)
    private Integer idCaracteristiqueComposant;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "id_estate", nullable = false)
    private EstateMi idEstate;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "id_forme", nullable = false)
    private FormeComposantMi idForme;

   /* @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "id_type_composant", nullable = false)
    private TypeComposant idTypeComposant;*/
    @Transient
    private TypeComposant typeComposantEstate;

    @Column(name = "composant")
    private Integer composant;

    @Column(name = "longueur_composant")
    private Double longueurComposant;

    @Column(name = "largeur_composant")
    private Double largeurComposant;

    @Column(name = "surfacee")
    private Double surfacee;

}