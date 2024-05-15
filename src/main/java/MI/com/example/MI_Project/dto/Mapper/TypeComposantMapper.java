package MI.com.example.MI_Project.dto.Mapper;

import MI.com.example.MI_Project.dto.Model.TypeComposantDto;
import MI.com.example.MI_Project.entities.TypeComposant;

public class TypeComposantMapper {
    public static TypeComposantDto maptoDto(TypeComposant typeComposant) {
        if (typeComposant != null) {
            TypeComposantDto typeComposantDto = new TypeComposantDto();
            typeComposantDto.setIdTypeComposant(typeComposant.getIdTypeComposant());
            typeComposantDto.setTypeComposant(typeComposant.getTypeComposantEstate());

            return typeComposantDto;
        } else return null;
    }


    public static TypeComposant maptoEntity(TypeComposantDto typeComposantDto) {
        if (typeComposantDto != null) {

            TypeComposant typeComposant= new TypeComposant();
            typeComposant.setIdTypeComposant(typeComposantDto.getIdTypeComposant());
            typeComposant.setTypeComposantEstate(typeComposantDto.getTypeComposant());
            return typeComposant;
        } else return null;
    }
}
