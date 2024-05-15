package MI.com.example.MI_Project.dto.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
@Accessors(chain = true)
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
public class CaracteristiqueEstateMiDto implements Serializable {
    private Integer idCaracteristiqueEstate;
    @Size(max = 30)
    private String serviceAssocie;
    @NotNull
    private EstateMiDto idEstate;
    @Size(max = 20)
    private String categorieTag;
    @Size(max = 40)
    private String valeurCaracteristique;
    private Boolean disponibiliteCaracteristiqueMi;
    private BigDecimal prixSupplementaire;
    private Double surfaceCaracteristique;
}