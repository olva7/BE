package MI.com.example.MI_Project.dto.Model;

import MI.com.example.MI_Project.entities.EstateMi;
import MI.com.example.MI_Project.entities.EtatEstateMi;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;

@Accessors(chain = true)
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
public class EtatMiDto implements Serializable {
    private EtatEstateMi idEtatEstateMI;

    private EstateMi idEstate;

    private LocalDate dateDisponibilite;

}