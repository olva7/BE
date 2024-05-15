package MI.com.example.MI_Project.dto.Mapper;

import MI.com.example.MI_Project.dto.Model.EtatEstateMiDto;
import MI.com.example.MI_Project.entities.EtatEstateMi;

public class EtatEstateMiMapper {
    public static EtatEstateMiDto mapToDTO(EtatEstateMi etatEstateMi) {

        if (etatEstateMi != null) {


            return new EtatEstateMiDto()
                    .setIdEtatEstate(etatEstateMi.getIdEtatEstateMI())

                    .setEtatEstate(etatEstateMi.getEtatEstate())
                    .setDetailsContrat(etatEstateMi.getDetailsContrat())

                    ;

        } else
            return null;
    }

    public static EtatEstateMi mapToEntity(EtatEstateMiDto etatEstateMiDto) {
        if (etatEstateMiDto != null) {
            EtatEstateMi etatEstateMi=new EtatEstateMi();

            etatEstateMi.setIdEtatEstateMI(etatEstateMiDto.getIdEtatEstate());
            etatEstateMi.setEtatEstate(etatEstateMiDto.getEtatEstate());
            etatEstateMi.setDetailsContrat(etatEstateMiDto.getDetailsContrat());


            return etatEstateMi;
        }
        return null;

    }
}
