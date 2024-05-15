package MI.com.example.MI_Project.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class ComposantEstateMi implements Serializable {
    @Serial
    private static final long serialVersionUID = 2405172041950251807L;
    @EmbeddedId
    private ComposantEstateMiId id;

    @ManyToOne
    @JsonBackReference

    @JoinColumn(name = "id_estate",referencedColumnName = "id_estate", insertable = false, updatable = false)
    private EstateMi idEstate;

    @ManyToOne
    @JsonBackReference

    @JoinColumn(name = "id_type_composant",referencedColumnName = "id_type_composant", insertable = false, updatable = false)
    private TypeComposant idTypeComposant;
    @Column(name = "nbr_composant")
    private Integer nbrComposant;


}
