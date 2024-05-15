package MI.com.example.MI_Project.dto.Model;

import MI.com.example.MI_Project.entities.EtatDemande;
import MI.com.example.MI_Project.security.dto.AppUserDTO;
import MI.com.example.MI_Project.security.entities.AppUser;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Accessors(chain = true)
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class DemandeEstateDto {
    private Integer reference;
    @NotNull
    private Integer prixDemande;
    private Integer prixTotale;
    private Date dateCreation;
    private EtatDemandeDto etatDemande;
    //@JsonBackReference
    private AppUserDTO idUser;
}
