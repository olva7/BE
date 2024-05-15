package MI.com.example.MI_Project.dto.Model;

import MI.com.example.MI_Project.entities.CaracteristiqueTypeEstate;
import MI.com.example.MI_Project.entities.TypeEstateMi;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
@Accessors(chain = true)
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties( {"hibernateLazyInitializer", "handler"})
@Getter
@Setter
@NoArgsConstructor

public class TypeCaracteristiqueMiDto implements Serializable {
    private TypeEstateMi idTypeEstate;
    private CaracteristiqueTypeEstate idCaracteristiqueMi;
}
