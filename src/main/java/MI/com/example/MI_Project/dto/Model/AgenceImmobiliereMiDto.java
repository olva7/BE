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
public class AgenceImmobiliereMiDto implements Serializable {
    private Integer idAgenceImmobiliere;
    @Size(max = 20)
    private String nomAgenceImmobiliere;
    private Integer numTelMobile;
    private String addressAgenceImmobiliere;
    @Size(max = 30)
    private String addressMail;
    @Size(max = 40)
    private String siteWeb;
    @Size(max = 45)
    private String reseauSociaux;
    private Integer numTelFixe;
    private Integer numFax;
    @Size(max = 254)
    private String logoAgence;
    @Size(max = 254)
    private String descriptionAgenceImmobiliere;
    private Double latitudeAgence;
    private Double longitudeAgence;
    private Integer userId;
}