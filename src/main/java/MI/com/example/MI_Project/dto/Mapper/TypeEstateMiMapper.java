package MI.com.example.MI_Project.dto.Mapper;

import MI.com.example.MI_Project.dto.Model.TypeEstateMiDto;
import MI.com.example.MI_Project.entities.TypeEstateMi;

public class TypeEstateMiMapper {
    public static TypeEstateMiDto mapToDTO(TypeEstateMi typeEstateMi) {

        if (typeEstateMi != null) {


            return new TypeEstateMiDto()
                    .setIdTypeEstateMI(typeEstateMi.getIdTypeEstateMI())
                    .setTypeEstate(typeEstateMi.getTypeEstate());

        } else
            return null;
    }

    public static TypeEstateMi mapToEntity(TypeEstateMiDto typeEstateMiDto) {
        if (typeEstateMiDto != null) {
            TypeEstateMi typeEstateMi=new TypeEstateMi();

            typeEstateMi.setIdTypeEstateMI(typeEstateMiDto.getIdTypeEstateMI());
            typeEstateMi.setTypeEstate(typeEstateMiDto.getTypeEstate());


            return typeEstateMi;
        }
        return null;

    }
}
