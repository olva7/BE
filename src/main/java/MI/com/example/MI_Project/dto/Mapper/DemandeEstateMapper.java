package MI.com.example.MI_Project.dto.Mapper;


import MI.com.example.MI_Project.dto.Model.DemandeEstateDto;

import MI.com.example.MI_Project.dto.Model.EtatEstateMiDto;
import MI.com.example.MI_Project.entities.DemandeEstate;
import MI.com.example.MI_Project.security.dtoMapper.MapperModel;

import java.util.List;
import java.util.stream.Collectors;

public class DemandeEstateMapper {
    public static DemandeEstateDto mapToDTO(DemandeEstate demandeEstate) {

        if (demandeEstate != null) {


            return new DemandeEstateDto()
                    .setPrixDemande(demandeEstate.getPrixDemande())
                    .setReference(demandeEstate.getReference())
                    //.setDateCreation(demandeEstate.getDateCreation())
                    .setPrixTotale(demandeEstate.getPrixTotale())
                   // .setEtatDemande(EtatDemandeMapper.mapToDTO(demandeEstate.getEtatDemande()))

                    .setIdUser(MapperModel.mapEntityToDto(demandeEstate.getAppUser()));


        } else
            return null;
    }

    public static DemandeEstate mapToEntity(DemandeEstateDto demandeEstateDto) {
        if (demandeEstateDto != null) {
            DemandeEstate demandeEstate = new DemandeEstate();

            demandeEstate.setPrixDemande(demandeEstateDto.getPrixDemande());
            demandeEstate.setReference(demandeEstateDto.getReference());
            //demandeEstate.setDateCreation(demandeEstateDto.getDateCreation());
            demandeEstate.setAppUser(MapperModel.mapDtoToEntity(demandeEstateDto.getIdUser()));
            demandeEstate.setPrixTotale(demandeEstateDto.getPrixTotale());
            //demandeEstate.setEtatDemande(EtatDemandeMapper.mapToEntity(demandeEstateDto.getEtatDemande()));




            return demandeEstate;
        }
        return null;

    }

    public static List<DemandeEstateDto> mapToDTOList(List<DemandeEstate> demandeEstates) {
        return demandeEstates.stream()
                .map(DemandeEstateMapper::mapToDTO)
                .collect(Collectors.toList());
    }
    public static List<DemandeEstate> mapToEntityList(List<DemandeEstateDto> demandeEstateDtos) {
        return demandeEstateDtos.stream()
                .map(DemandeEstateMapper::mapToEntity)
                .collect(Collectors.toList());
    }


}
