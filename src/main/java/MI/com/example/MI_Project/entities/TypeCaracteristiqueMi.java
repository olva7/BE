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
@Table(name = "type_caracteristique_mi")
public class TypeCaracteristiqueMi implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private TypeCaracteristiqueMiId idCaracteristiqueTypeEstate;

    @MapsId("idType")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "id_type", nullable = false)
    private TypeEstateMi idType;

    @MapsId("idCaracteristique")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "id_caracteristique", nullable = false)
    private CaracteristiqueTypeEstate idCaracteristique;

}