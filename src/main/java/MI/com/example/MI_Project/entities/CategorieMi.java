package MI.com.example.MI_Project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.*;

@Getter
@Setter
@Entity
@Table(name = "categorie_mi")
public class CategorieMi implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categorie", nullable = false)
    private Integer idCategorieEstate;

    @Size(max = 30)
    @Column(name = "categorie_mi", length = 30)
    private String categorieMi;

    @OneToMany(mappedBy = "idCategorie")
    @JsonIgnore
    private Set<CategorieType> categorieTypeUnType = new HashSet<>();


}