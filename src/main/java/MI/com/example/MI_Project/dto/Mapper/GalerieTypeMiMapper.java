package MI.com.example.MI_Project.dto.Mapper;

import MI.com.example.MI_Project.dto.Model.GalerieTypeMiDto;
import MI.com.example.MI_Project.entities.GalerieTypeMi;

public class GalerieTypeMiMapper {
    public static GalerieTypeMiDto mapToDTO(GalerieTypeMi galerieTypeMi) {

        if (galerieTypeMi != null) {


            return new GalerieTypeMiDto()
                    .setIdGalerieTypeMI(galerieTypeMi.getIdGalerieTypeMI())
                    .setTypeGalerie(galerieTypeMi.getTypeGalerie());

        } else
            return null;
    }

    public static GalerieTypeMi mapToEntity(GalerieTypeMi galerieTypeMiDto) {
        if (galerieTypeMiDto != null) {
            GalerieTypeMi galerieTypeMi=new GalerieTypeMi();

            galerieTypeMi.setIdGalerieTypeMI(galerieTypeMiDto.getIdGalerieTypeMI());
            galerieTypeMi.setTypeGalerie(galerieTypeMi.getTypeGalerie());


            return galerieTypeMi;
        }
        return null;

    }
}
