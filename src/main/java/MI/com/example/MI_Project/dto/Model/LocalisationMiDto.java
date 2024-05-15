package MI.com.example.MI_Project.dto.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Size;
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

public class LocalisationMiDto implements Serializable {
    private  Integer idLocalisation;
    private LocalisationMiDto locIdLocalisation;
    @Size(max = 245)
    private  String nomLocalisation;
    @Size(max = 250)
    private String logoLocalisation;
    private Integer codePostalLocalisation;
    private Double latitudeLocalisation;
    private Double longitudeLocalisation;

    @Size(max = 250)
    private String descriptionLocalisation;
    @Size(max = 3)
    private String abreviationLocalisation;
}