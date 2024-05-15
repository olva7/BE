package MI.com.example.MI_Project.dto.Model;


import MI.com.example.MI_Project.entities.EstateMi;
import MI.com.example.MI_Project.entities.TypeComposant;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.Accessors;


import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
@Accessors(chain = true)
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class ComposantEstateMiDto implements Serializable {

    private  TypeComposant idTypeComposant;
    private  EstateMi idEstate;
    private Integer nbrComposant;


}