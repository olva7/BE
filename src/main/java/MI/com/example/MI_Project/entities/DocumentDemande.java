package MI.com.example.MI_Project.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "document_demande")
public class DocumentDemande implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private DocumentDemandeId idDocumentDemande;

    @MapsId("idDocument")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "id_document", nullable = false)

    private Document idDocument;

    @MapsId("ref")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "reference", nullable = false)
    private DemandeEstate reference;
    @Column(name = "id_image")
    private UUID idImage;




}
