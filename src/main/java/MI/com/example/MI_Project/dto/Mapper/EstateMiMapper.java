package MI.com.example.MI_Project.dto.Mapper;

import MI.com.example.MI_Project.dto.Model.EstateMiDto;
import MI.com.example.MI_Project.entities.EstateMi;
import MI.com.example.MI_Project.security.dtoMapper.MapperModel;
import MI.com.example.MI_Project.security.entities.AppUser;

public class EstateMiMapper {
    public static EstateMiDto mapToDTO(EstateMi estateMi) {

        if (estateMi != null) {


            return new EstateMiDto()
                    .setIdEstateMI(estateMi.getIdEstateMI())
                    .setAddressEstate(estateMi.getAddressEstate())
                    //.setDateAjout(estateMi.getDateAjout())
                    //.setDisponibilite(estateMi.getDisponibilite())
                    .setLatitude(estateMi.getLatitude())
                    .setLongitude(estateMi.getLongitude())
                    .setNbreComposants(estateMi.getNbreComposants())
                    .setEtatEstate(estateMi.getEtatEstate())
                    .setPrixEnM(estateMi.getPrixEnM())
                    .setSurfacieEnM(estateMi.getSurfacieEnM())
                    .setPrixTotale(estateMi.getPrixTotale())
                    .setLibEstate(estateMi.getLibEstate())
                    .setLoyer(estateMi.getLoyer())
                    .setApportPropre(estateMi.getApportPropre())
                    .setApportPropreMinimal(estateMi.getApportPropreMinimal())
                    //.setIdAgenceImmobiliere(AgenceImmobilierMapper.entityToDto(estateMi.getIdAgence()))
                    .setIdUser(MapperModel.mapEntityToDto(estateMi.getIdUser()))


                    .setIdTypeEstate(TypeEstateMiMapper.mapToDTO(estateMi.getIdTypeEstate()))
                    .setIdLocalisation(LocalisationMiMapper.mapToDTO(estateMi.getIdLocalisation()))


                    ;

        } else
            return null;
    }

    public static EstateMi mapToEntity(EstateMiDto estateMiDto) {
        if (estateMiDto != null) {
            EstateMi estateMi = new EstateMi();

            estateMi.setIdEstateMI(estateMiDto.getIdEstateMI());
            estateMi.setAddressEstate(estateMiDto.getAddressEstate());
            //estateMi.setDateAjout(estateMiDto.getDateAjout());
            //estateMi.setDisponibilite(estateMiDto.getDisponibilite());
            estateMi.setLatitude(estateMiDto.getLatitude());
            estateMi.setLongitude(estateMiDto.getLongitude());
            estateMi.setNbreComposants(estateMiDto.getNbreComposants());
            estateMi.setPrixEnM(estateMiDto.getPrixEnM());
            estateMi.setPrixTotale(estateMiDto.getPrixTotale());
            estateMi.setCategorieMiTag(estateMiDto.getCategorieMiTag());

            estateMi.setSurfacieEnM(estateMiDto.getSurfacieEnM());
            estateMi.setLibEstate(estateMiDto.getLibEstate());
            estateMi.setApportPropre(estateMiDto.getApportPropre());
            estateMi.setApportPropreMinimal(estateMiDto.getApportPropreMinimal());
            estateMi.setLoyer(estateMiDto.getLoyer());
            estateMi.setEtatEstate(estateMiDto.getEtatEstate());
            estateMi.setIdUser(MapperModel.mapDtoToEntity(estateMiDto.getIdUser()));



            //estateMi.setIdAgence(AgenceImmobilierMapper.dtoToEntity(estateMiDto.getIdAgenceImmobiliere()));
            estateMi.setIdTypeEstate(TypeEstateMiMapper.mapToEntity(estateMiDto.getIdTypeEstate()));
            estateMi.setIdLocalisation(LocalisationMiMapper.mapToEntity(estateMiDto.getIdLocalisation()));
            return estateMi;
        }
        return null;

    }
}
