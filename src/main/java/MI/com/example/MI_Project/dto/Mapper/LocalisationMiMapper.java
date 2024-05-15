package MI.com.example.MI_Project.dto.Mapper;

import MI.com.example.MI_Project.dto.Model.LocalisationMiDto;
import MI.com.example.MI_Project.entities.LocalisationMi;

public class LocalisationMiMapper {
    public static LocalisationMiDto mapToDTO(LocalisationMi localisationMi) {

        if (localisationMi != null) {


            return new LocalisationMiDto()
                    .setIdLocalisation(localisationMi.getIdLocalisationMI())
                    .setDescriptionLocalisation(localisationMi.getDescriptionLocalisation())
                    .setLatitudeLocalisation(localisationMi.getAtitudeLocalisation())
                    .setLongitudeLocalisation(localisationMi.getLongitude())
                    .setLogoLocalisation(localisationMi.getLogoLocalisation())
                    .setNomLocalisation(localisationMi.getNomLocalisation())
                    .setCodePostalLocalisation(localisationMi.getCodePostalLocalisation())
                    .setLocIdLocalisation(LocalisationMiMapper.mapToTrivialDto(localisationMi.getLocIdLocalisation()))
                    .setAbreviationLocalisation(localisationMi.getAbreviationLocalisation());

        } else
            return null;
    }

    public static LocalisationMiDto mapToTrivialDto(LocalisationMi localisationMi) {
        if (localisationMi != null) {

            return new LocalisationMiDto()
                    .setIdLocalisation(localisationMi.getIdLocalisationMI())
                    .setDescriptionLocalisation(localisationMi.getDescriptionLocalisation());

        } else
            return null;
    }

    public static LocalisationMi mapToTrivialEntity(LocalisationMiDto localisationMiDTO) {
        if (localisationMiDTO != null) {
            LocalisationMi localisationMi = new LocalisationMi();
            localisationMi.setIdLocalisationMI(localisationMiDTO.getIdLocalisation());
            return localisationMi;
        } else
            return null;
    }

    public static LocalisationMi mapToEntity(LocalisationMiDto localisationMiDto) {
        if (localisationMiDto != null) {
            LocalisationMi localisationMi = new LocalisationMi();

            localisationMi.setIdLocalisationMI(localisationMiDto.getIdLocalisation());
            localisationMi.setAbreviationLocalisation(localisationMiDto.getAbreviationLocalisation());
            localisationMi.setNomLocalisation(localisationMiDto.getNomLocalisation());
            localisationMi.setAtitudeLocalisation(localisationMiDto.getLatitudeLocalisation());
            localisationMi.setLongitude(localisationMiDto.getLongitudeLocalisation());
            localisationMi.setDescriptionLocalisation(localisationMiDto.getDescriptionLocalisation());
            localisationMi.setLogoLocalisation(localisationMiDto.getLogoLocalisation());
            localisationMi.setCodePostalLocalisation(localisationMiDto.getCodePostalLocalisation());
            localisationMi.setLocIdLocalisation(LocalisationMiMapper.mapToTrivialEntity(localisationMiDto.getLocIdLocalisation()));

            return localisationMi;
        }
        return null;
    }
}
