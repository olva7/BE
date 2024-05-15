package MI.com.example.MI_Project.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class EtatMiId implements Serializable {
    @Serial
    private static final long serialVersionUID = -7517429954921153419L;
    @NotNull
    @Column(name = "id_estate", nullable = false)
    private Integer idEstate;

    @NotNull
    @Column(name = "id_etat_estate", nullable = false)
    private Integer idEtatEstate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EtatMiId entity = (EtatMiId) o;
        return Objects.equals(this.idEstate, entity.idEstate) &&
                Objects.equals(this.idEtatEstate, entity.idEtatEstate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEstate, idEtatEstate);
    }

}