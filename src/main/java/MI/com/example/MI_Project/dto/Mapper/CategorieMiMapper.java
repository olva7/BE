package MI.com.example.MI_Project.dto.Mapper;

import MI.com.example.MI_Project.dto.Model.CategorieMiDto;
import MI.com.example.MI_Project.entities.CategorieMi;

public class CategorieMiMapper {
    public static CategorieMiDto mapToDTO(CategorieMi categorieMi) {

        if (categorieMi != null) {


            return new CategorieMiDto()
                    .setIdCategorieMi(categorieMi.getIdCategorieEstate())
                    .setCategorieMi(categorieMi.getCategorieMi());


        } else
            return null;
    }

    public static CategorieMi mapToEntity(CategorieMiDto categorieMiDto) {
        if (categorieMiDto != null) {
            CategorieMi categorieMi=new CategorieMi();

            categorieMi.setIdCategorieEstate(categorieMi.getIdCategorieEstate());
            categorieMi.setCategorieMi(categorieMiDto.getCategorieMi());


            return categorieMi;
        }
        return null;

    }
}
