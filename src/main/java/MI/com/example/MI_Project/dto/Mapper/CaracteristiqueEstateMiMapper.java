package MI.com.example.MI_Project.dto.Mapper;

import MI.com.example.MI_Project.dto.Model.CaracteristiqueTypeEstateDto;
import MI.com.example.MI_Project.entities.CaracteristiqueTypeEstate;

public class CaracteristiqueEstateMiMapper {
    public static CaracteristiqueTypeEstate dtoToEntity(CaracteristiqueTypeEstateDto dto) {
        if (dto == null) {
            return null;
        }
        CaracteristiqueTypeEstate entity = new CaracteristiqueTypeEstate();
        entity.setIdCaracteristiqueEstate(dto.getIdCaracteristiqueEstate());
        entity.setCaracteristique(dto.getCaracteristique());
        return entity;
    }

    public static CaracteristiqueTypeEstateDto entityToDto(CaracteristiqueTypeEstate entity) {
        if (entity == null) {
            return null;
        }
        CaracteristiqueTypeEstateDto dto = new CaracteristiqueTypeEstateDto();
        dto.setIdCaracteristiqueEstate(entity.getIdCaracteristiqueEstate())
                .setCaracteristique(entity.getCaracteristique());
        return dto;
    }
}
