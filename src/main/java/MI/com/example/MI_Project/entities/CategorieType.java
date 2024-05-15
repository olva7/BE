package MI.com.example.MI_Project.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "categorie_type")
public class CategorieType implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private CategorieTypeMiId idCategorieTypeEstate;

    @MapsId("idCategorie")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "id_categorie", nullable = false)

    private CategorieMi idCategorie;

    @MapsId("idType")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "id_type_estate", nullable = false)
    private TypeEstateMi idTypeEstate;

}