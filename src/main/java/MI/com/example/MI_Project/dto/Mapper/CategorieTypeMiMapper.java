package MI.com.example.MI_Project.dto.Mapper;

import MI.com.example.MI_Project.dto.Model.CategorieTypeMiDto;
import MI.com.example.MI_Project.entities.CategorieType;

public class CategorieTypeMiMapper {
    public static CategorieTypeMiDto maptoDto(CategorieType categorieTypeMi) {
        if (categorieTypeMi != null) {
            CategorieTypeMiDto categorieTypeMiDto = new CategorieTypeMiDto();
            categorieTypeMiDto.setIdCategorieMi(categorieTypeMi.getIdCategorie());
            categorieTypeMiDto.setIdTypeEstate(categorieTypeMi.getIdTypeEstate());

            return categorieTypeMiDto;
        } else return null;
    }


    public static CategorieType maptoEntity(CategorieTypeMiDto categorieTypeMiDto) {
        if (categorieTypeMiDto != null) {

            CategorieType categorieTypeMi= new CategorieType();
            categorieTypeMi.setIdCategorie(categorieTypeMiDto.getIdCategorieMi());
            categorieTypeMi.setIdTypeEstate(categorieTypeMiDto.getIdTypeEstate());
            return categorieTypeMi;
        } else return null;
    }
}
