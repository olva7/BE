package MI.com.example.MI_Project.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class DocumentDemandeId implements Serializable {
    @Serial
    private static final long serialVersionUID = -960148859485292283L;
    @NotNull
    @Column(name = "id_document", nullable = false)
    private Integer idDocument;

    @NotNull
    @Column(name = "reference", nullable = false)
    private Integer ref;

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DocumentDemandeId entity = (DocumentDemandeId ) o;
        return Objects.equals(this.idDocument, entity.idDocument) &&
                Objects.equals(this.ref, entity.ref);
    }*/
    public DocumentDemandeId(@NonNull int referenceDemande, @NonNull int idDoc) {
        this.ref = referenceDemande;
        this.idDocument = idDoc;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDocument, ref);
    }

}
