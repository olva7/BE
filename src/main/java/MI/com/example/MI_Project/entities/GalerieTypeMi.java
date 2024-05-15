package MI.com.example.MI_Project.entities;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "galerie_type_mi")
public class GalerieTypeMi implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_galerie", nullable = false)
    private Integer idGalerieTypeMI;

    @Column(name = "type_galerie")
    private String typeGalerie;

    @OneToMany(mappedBy = "idTypeGalerie")
    private Set<GalerieMi> galerieMis = new LinkedHashSet<>();

}