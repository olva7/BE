package MI.com.example.MI_Project.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "etat_mi")
public class EtatMi implements Serializable {
    @Serial
    private static final long serialVersionUID = 2405172041950251807L;
    @EmbeddedId
    private EtatMiId idEtatEstatMI;

    @MapsId("idEstate")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "id_estate", nullable = false)
    private EstateMi idEstate;

    @MapsId("idEtatEstate")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "id_etat_estate", nullable = false)
    private EtatEstateMi idEtatEstate;

    @Column(name = "date_disponibilite")
    private LocalDate dateDisponibilite;

}