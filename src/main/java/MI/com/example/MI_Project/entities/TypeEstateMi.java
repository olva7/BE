package MI.com.example.MI_Project.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "type_estate_mi")
public class TypeEstateMi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_estate", nullable = false)
    private Integer idTypeEstateMI;


    @Column(name = "type_estate")
    private String typeEstate;

    @OneToMany(mappedBy = "idTypeEstate")
    @JsonIgnore

    private Set<CategorieType> categorieTypeUneCategorie = new HashSet<>();

    @OneToMany(mappedBy = "idTypeEstate")
    @JsonIgnore

    private Set<EstateMi> estateMis = new HashSet<>();


    @OneToMany(mappedBy ="idType")
    @JsonIgnore

    private Set<TypeCaracteristiqueMi> typeCaracteristiqueDesCaracteristiqueMI = new HashSet<>();


}