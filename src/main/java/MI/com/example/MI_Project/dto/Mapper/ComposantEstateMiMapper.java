package MI.com.example.MI_Project.dto.Mapper;

import MI.com.example.MI_Project.dto.Model.ComposantEstateMiDto;
import MI.com.example.MI_Project.entities.ComposantEstateMi;

public class ComposantEstateMiMapper {
    public static ComposantEstateMiDto mapToDTO(ComposantEstateMi composantEstateMi) {

        if (composantEstateMi != null) {


            return new ComposantEstateMiDto()
                    .setIdTypeComposant(composantEstateMi.getIdTypeComposant())
                    .setIdEstate(composantEstateMi.getIdEstate())

                    .setNbrComposant(composantEstateMi.getNbrComposant());
        } else
            return null;
    }

    public static ComposantEstateMi mapToEntity(ComposantEstateMiDto composantEstateMiDto) {
        if (composantEstateMiDto != null) {
            ComposantEstateMi composantEstateMi = new ComposantEstateMi();

            composantEstateMi.setIdTypeComposant(composantEstateMiDto.getIdTypeComposant());


            composantEstateMi.setIdEstate(composantEstateMiDto.getIdEstate());
            composantEstateMi.setNbrComposant(composantEstateMiDto.getNbrComposant());

            return composantEstateMi;
        }
        return null;

    }
}
