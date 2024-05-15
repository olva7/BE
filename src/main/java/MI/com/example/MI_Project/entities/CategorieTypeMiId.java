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
public class CategorieTypeMiId implements Serializable {
    @Serial
    private static final long serialVersionUID = -960148859485292283L;
    @NotNull
    @Column(name = "id_categorie", nullable = false)
    private Integer idCategorie;

    @NotNull
    @Column(name = "id_type", nullable = false)
    private Integer idType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CategorieTypeMiId entity = (CategorieTypeMiId) o;
        return Objects.equals(this.idType, entity.idType) &&
                Objects.equals(this.idCategorie, entity.idCategorie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idType, idCategorie);
    }

}