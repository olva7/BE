package MI.com.example.MI_Project.dto.Mapper;

import MI.com.example.MI_Project.dto.Model.FormeComposantMiDto;
import MI.com.example.MI_Project.entities.FormeComposantMi;

public class FormeComposantMiMapper {
    public static FormeComposantMiDto mapToDTO(FormeComposantMi formeComposantMi) {

        if (formeComposantMi != null) {
            return new FormeComposantMiDto()
                    .setIdFormeComposant(formeComposantMi.getIdFormeComposant())
                    .setForme(formeComposantMi.getForme());
        } else
            return null;
    }

    public static FormeComposantMi mapToEntity(FormeComposantMiDto formeComposantMiDto) {
        if (formeComposantMiDto != null) {
            FormeComposantMi formeComposantMi=new FormeComposantMi();
            formeComposantMi.setIdFormeComposant(formeComposantMiDto.getIdFormeComposant());
            formeComposantMi.setForme(formeComposantMiDto.getForme());

            return formeComposantMi;
        }
        return null;

    }
}
