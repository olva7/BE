package MI.com.example.MI_Project.dto.Mapper;

import MI.com.example.MI_Project.dto.Model.EtatMiDto;
import MI.com.example.MI_Project.entities.EtatMi;

public class EtatMiMapper {
    public static EtatMiDto maptoDto(EtatMi etatMi) {
        if (etatMi != null) {
            EtatMiDto etatMiDto = new EtatMiDto();
            etatMiDto.setIdEstate(etatMi.getIdEstate());
            etatMiDto.setIdEtatEstateMI(etatMi.getIdEtatEstate());

            return etatMiDto;
        } else return null;
    }


    public static EtatMi maptoEntity(EtatMiDto etatMiDto) {
        if (etatMiDto != null) {

            EtatMi etatMi= new EtatMi();
            etatMi.setIdEtatEstate(etatMiDto.getIdEtatEstateMI());
            etatMi.setIdEtatEstate(etatMiDto.getIdEtatEstateMI());
            return etatMi;
        } else return null;
    }
}
