package MI.com.example.MI_Project.dto.Model;

import MI.com.example.MI_Project.security.dto.AppUserDTO;
import MI.com.example.MI_Project.security.entities.AppUser;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Accessors(chain = true)
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor

public class EstateMiDto implements Serializable {
    private Integer idEstateMI;
    private Double surfacieEnM;
    @Size(max = 20)
    private String addressEstate;
    //private LocalDate disponibilite;
    //private LocalDate dateAjout;
    //private LocalDate dateConstruction;
    private Integer nbreComposants;
    @JsonBackReference
    private AppUserDTO idUser;
    private TypeEstateMiDto idTypeEstate;
    private LocalisationMiDto idLocalisation;
    private BigDecimal prixEnM;
    @Size(max = 23)
    private String latitude;
    @Size(max = 25)
    private String longitude;
    private BigDecimal prixTotale;
    private Integer etatEstate;
    private Integer apportPropre;
    private Integer apportPropreMinimal;
    private Integer loyer;
    private String urlEstate;
    private String libEstate;

    private String categorieMiTag;
    private List<CaracteristiqueEstateMiDto> caracteristiqueEstateList;
    private List<CaracteristiqueComposantDto> caracteristiqueComposantList;
}