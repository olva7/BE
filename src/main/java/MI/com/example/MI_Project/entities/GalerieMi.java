package MI.com.example.MI_Project.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "galerie_mi")
public class GalerieMi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_galerie", nullable = false)
    private Integer idGalerieMI;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "id_estate", nullable = false)
    private EstateMi idEstate;


    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "id_type_galerie")
    private GalerieTypeMi idTypeGalerie;

    @Size(max = 50)
    @Column(name = "url_galerie", length = 50)
    private String urlGalerie;

    @Column(name = "tag")
    private String tag;


}