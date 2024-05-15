package MI.com.example.MI_Project.dto.Mapper;

import MI.com.example.MI_Project.dto.Model.GalerieMiDto;

import MI.com.example.MI_Project.entities.GalerieMi;
import MI.com.example.MI_Project.entities.GalerieTypeMi;


public class GalerieMiMapper {
    public static GalerieMiDto mapToDTO(GalerieMi galerieMi) {

        if (galerieMi != null) {
            return new GalerieMiDto()
                    .setIdGalerieMI(galerieMi.getIdGalerieMI())
                    .setTag(galerieMi.getTag())
                    .setUrlGalerie(galerieMi.getUrlGalerie())
                    .setIdEstate(EstateMiMapper.mapToDTO(galerieMi.getIdEstate()))
                    .setIdTypeGalerie(GalerieTypeMiMapper.mapToEntity(galerieMi.getIdTypeGalerie()));


        } else
            return null;
    }



    public static GalerieMi mapToEntity(GalerieMiDto galerieMiDto) {
        if (galerieMiDto != null) {
            GalerieMi galerieMi = new GalerieMi();
            galerieMi.setIdGalerieMI(galerieMiDto.getIdGalerieMI());
            galerieMi.setTag(galerieMiDto.getTag());
            galerieMi.setUrlGalerie(galerieMiDto.getUrlGalerie());
            galerieMi.setIdEstate(EstateMiMapper.mapToEntity(galerieMiDto.getIdEstate()));
            galerieMi.setIdTypeGalerie(GalerieTypeMiMapper.mapToEntity(galerieMiDto.getIdTypeGalerie()));

            return galerieMi;
        }
        return null;
    }


}
