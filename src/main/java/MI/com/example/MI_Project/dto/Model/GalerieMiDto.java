package MI.com.example.MI_Project.dto.Model;

import MI.com.example.MI_Project.entities.GalerieTypeMi;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;


@Accessors(chain = true)
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
public class GalerieMiDto implements Serializable {
    private Integer idGalerieMI;
    private String urlGalerie;
    private String tag;
    private EstateMiDto idEstate;
    private GalerieTypeMi idTypeGalerie;

}