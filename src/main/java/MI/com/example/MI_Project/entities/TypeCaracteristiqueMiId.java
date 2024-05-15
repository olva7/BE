package MI.com.example.MI_Project.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
//import jakarta.persistence.Entity;
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
public class TypeCaracteristiqueMiId implements Serializable {
    @Serial
    private static final long serialVersionUID = 2246124240485738138L;
    @NotNull
    @Column(name = "id_type", nullable = false)
    private Integer idType;

    @NotNull
    @Column(name = "id_caracteristique", nullable = false)
    private Integer idCaracteristique;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TypeCaracteristiqueMiId entity = (TypeCaracteristiqueMiId) o;
        return Objects.equals(this.idType, entity.idType) &&
                Objects.equals(this.idCaracteristique, entity.idCaracteristique);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idType, idCaracteristique);
    }

}