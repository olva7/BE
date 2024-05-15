package MI.com.example.MI_Project.dto.Model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
@Accessors(chain = true)

@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data


public class CaracteristiqueComposantDto implements Serializable {
    private Integer idCaracteristiqueComposant;
    private Integer idTypeComposant;
    private String typeComposantTag;
    private EstateMiDto idEstate;
    private FormeComposantMiDto idFormeComposant;
    private Double longueurComposant;
    private Double largeurComposant;
    private Double surface;
}