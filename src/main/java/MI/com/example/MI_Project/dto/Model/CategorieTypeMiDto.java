package MI.com.example.MI_Project.dto.Model;

import MI.com.example.MI_Project.entities.CategorieMi;
import MI.com.example.MI_Project.entities.TypeEstateMi;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
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

public class CategorieTypeMiDto implements Serializable {
    @NotNull
    private CategorieMi idCategorieMi;
    @NotNull
    private TypeEstateMi idTypeEstate;



}