package MI.com.example.MI_Project.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class ComposantEstateMiId implements Serializable {
    private static final long serialVersionUID = 320829644298474005L;

    @Basic(optional = false)
    @NonNull
    @Column(name = "id_estate")
    private int idEstate;

    @Basic(optional = false)
    @NonNull
    @Column(name = "id_type_composant")
    private int idTypeComposant;
    public ComposantEstateMiId() {
    }

    public ComposantEstateMiId(@NonNull int idEstate, @NonNull int idTypeComposant) {
        this.idEstate = idEstate;
        this.idTypeComposant = idTypeComposant;
    }

    public int getIdEstate() {
        return idEstate;
    }

    public void setIdEstate(int idEstate) {
        this.idEstate = idEstate;
    }

    public int getIdTypeComposant() {
        return idTypeComposant;
    }

    public void setIdTypeComposant(int idTypeComposant) {
        this.idTypeComposant = idTypeComposant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ComposantEstateMiId entity = (ComposantEstateMiId) o;
        return Objects.equals(this.idEstate, entity.idEstate) &&
                Objects.equals(this.idTypeComposant, entity.idTypeComposant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEstate, idTypeComposant);
    }

}