package MI.com.example.MI_Project.dto.Mapper;

import MI.com.example.MI_Project.dto.Model.TypeCaracteristiqueMiDto;
import MI.com.example.MI_Project.entities.TypeCaracteristiqueMi;

public class TypeCaracteristiqueMiMapper {
    public static TypeCaracteristiqueMiDto maptoDto(TypeCaracteristiqueMi typeCaracteristiqueMi) {
        if (typeCaracteristiqueMi != null) {
            TypeCaracteristiqueMiDto typeCaracteristiqueMiDto = new TypeCaracteristiqueMiDto();
            typeCaracteristiqueMiDto.setIdCaracteristiqueMi(typeCaracteristiqueMi.getIdCaracteristique());
            typeCaracteristiqueMiDto.setIdTypeEstate(typeCaracteristiqueMi.getIdType());

            return typeCaracteristiqueMiDto;
        } else return null;
    }


    public static TypeCaracteristiqueMi maptoEntity(TypeCaracteristiqueMiDto typeCaracteristiqueMiDto) {
        if (typeCaracteristiqueMiDto != null) {

            TypeCaracteristiqueMi typeCaracteristiqueMi= new TypeCaracteristiqueMi();
            typeCaracteristiqueMi.setIdCaracteristique(typeCaracteristiqueMiDto.getIdCaracteristiqueMi());
            typeCaracteristiqueMi.setIdType(typeCaracteristiqueMiDto.getIdTypeEstate());
            return typeCaracteristiqueMi;
        } else return null;
    }
}
