package MI.com.example.MI_Project.dto.Mapper;

import MI.com.example.MI_Project.dto.Model.AgenceImmobiliereMiDto;
import MI.com.example.MI_Project.entities.AgenceImmobiliereMi;

public class AgenceImmobilierMapper {
    public static AgenceImmobiliereMi dtoToEntity(AgenceImmobiliereMiDto dto) {
        if (dto == null) {
            return null;
        }

        AgenceImmobiliereMi entity = new AgenceImmobiliereMi();
        entity.setIdAgenceImmobilierMI(dto.getIdAgenceImmobiliere());
        entity.setNomAgence(dto.getNomAgenceImmobiliere());
        entity.setNumTelMobile(dto.getNumTelMobile());
        entity.setAddressAgence(dto.getAddressAgenceImmobiliere());
        entity.setAddressMail(dto.getAddressMail());
        entity.setSiteWeb(dto.getSiteWeb());
        entity.setReseauSociaux(dto.getReseauSociaux());
        entity.setNumTelFixe(dto.getNumTelFixe());
        entity.setNumFax(dto.getNumFax());
        entity.setLogoAgence(dto.getLogoAgence());
        entity.setDescription(dto.getDescriptionAgenceImmobiliere());
        entity.setLatitudeAgence(dto.getLatitudeAgence());
        entity.setLongitudeAgence(dto.getLongitudeAgence());


        return entity;
    }

    public static AgenceImmobiliereMiDto entityToDto(AgenceImmobiliereMi entity) {
        if (entity == null) {
            return null;
        }

        AgenceImmobiliereMiDto dto = new AgenceImmobiliereMiDto();
        dto.setIdAgenceImmobiliere(entity.getIdAgenceImmobilierMI());
        dto.setNomAgenceImmobiliere(entity.getNomAgence());
        dto.setNumTelMobile(entity.getNumTelMobile());
        dto.setAddressAgenceImmobiliere(entity.getAddressAgence());
        dto.setAddressMail(entity.getAddressMail());
        dto.setSiteWeb(entity.getSiteWeb());
        dto.setReseauSociaux(entity.getReseauSociaux());
        dto.setNumTelFixe(entity.getNumTelFixe());
        dto.setNumFax(entity.getNumFax());
        dto.setLogoAgence(entity.getLogoAgence());
        dto.setDescriptionAgenceImmobiliere(entity.getDescription());
        dto.setLatitudeAgence(entity.getLatitudeAgence());
        dto.setLongitudeAgence(entity.getLongitudeAgence());

        return dto;
    }
}
