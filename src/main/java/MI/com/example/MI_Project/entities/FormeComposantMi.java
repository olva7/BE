package MI.com.example.MI_Project.entities;

//import MI.com.example.MI_Project.entities.ComposantEstateMi;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "forme_composant_mi")
public class FormeComposantMi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_forme", nullable = false)
    private Integer idFormeComposant;

    @Size(max = 20)
    @Column(name = "forme", length = 20)
    private String forme;

    @OneToMany(mappedBy = "idForme")

    private Set<CaracteristiqueComposant> caracteristiqueComposants = new HashSet<>();

}