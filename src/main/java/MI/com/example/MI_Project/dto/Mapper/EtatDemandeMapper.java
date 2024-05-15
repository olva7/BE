package MI.com.example.MI_Project.dto.Mapper;

import MI.com.example.MI_Project.dto.Model.DemandeEstateDto;
import MI.com.example.MI_Project.dto.Model.EtatDemandeDto;
import MI.com.example.MI_Project.entities.DemandeEstate;
import MI.com.example.MI_Project.entities.EtatDemande;
import MI.com.example.MI_Project.entities.EtatEstateMi;
import MI.com.example.MI_Project.security.dtoMapper.MapperModel;

public class EtatDemandeMapper {
    public static EtatDemandeDto mapToDTO(EtatDemande etatDemande) {

        if (etatDemande != null) {


            return new EtatDemandeDto()
                    .setIdEtatDemande(etatDemande.getIdEtatDemande())
                    .setLibEtatDemande(etatDemande.getLibEtatDemande());




        } else
            return null;
    }

    public static EtatDemande mapToEntity(EtatDemandeDto etatDemandeDto) {
        if (etatDemandeDto != null) {

            EtatDemande etatDemande = new EtatDemande();
            etatDemande.setIdEtatDemande(etatDemandeDto.getIdEtatDemande());
            etatDemande.setLibEtatDemande(etatDemandeDto.getLibEtatDemande());
            return etatDemande;
        }
        return null;

    }
}
