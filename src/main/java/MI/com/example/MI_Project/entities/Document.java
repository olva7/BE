package MI.com.example.MI_Project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "document")
public class Document implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_document", nullable = false)
    private Integer idDocument;

    @Size(max = 30)
    @Column(name = "document_lib", length = 30)
    private String documentLib;



    @OneToMany(mappedBy = "idDocument")
    @JsonIgnore
    private Set<DocumentDemande> documentDemandes  ;
}
