package MI.com.example.MI_Project.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Type_composant")
public class TypeComposant implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_composant", nullable = false)
    private Integer idTypeComposant;
    @Column(name = "type_composant")
    private String typeComposantEstate;
    @OneToMany(mappedBy = "idTypeComposant")
    private Set<ComposantEstateMi> Composants = new HashSet<>();



}
