package MI.com.example.MI_Project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "caracteristique_type_estate")
public class CaracteristiqueTypeEstate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_caracteristique", nullable = false)
    private Integer idCaracteristiqueEstate;


    @Column(name = "caracteristique", length = 40)
    private String caracteristique;

    //@ManyToMany
    //@JoinTable(name = "posseder",
            //joinColumns = @JoinColumn(name = "id_caracteristique"),
            //inverseJoinColumns = @JoinColumn(name = "id_type"))
    //private Set<TypeEstateMi> typeEstateMis = new LinkedHashSet<>();
    @OneToMany(mappedBy = "idCaracteristique")
    @JsonIgnore
    private Set<TypeCaracteristiqueMi> typeCaracteristiqueDesTypeMIS = new HashSet<>();

}