package MI.com.example.MI_Project.security.dtoMapper;

import MI.com.example.MI_Project.dto.Mapper.DemandeEstateMapper;
import MI.com.example.MI_Project.dto.Model.DemandeEstateDto;
import MI.com.example.MI_Project.entities.DemandeEstate;
import MI.com.example.MI_Project.security.dto.AppRoleDTO;
import MI.com.example.MI_Project.security.dto.AppUserDTO;
import MI.com.example.MI_Project.security.entities.AppUser;

import java.util.List;
import java.util.stream.Collectors;

public class MapperModel {
    private MapperModel() {
        throw new IllegalStateException("Utility class");
    }


    public static AppUserDTO mapEntityToDto(AppUser user) {
        if (user == null) {
            throw new IllegalArgumentException("Cannot map null AppUser to DTO");
        }
        AppUserDTO dto = new AppUserDTO();
        dto.setIdUser(user.getIdUser());
        dto.setFirstname(user.getFirstname());
        dto.setLastname(user.getLastname());
        dto.setUsernam(user.getUsernam());
        dto.setEmail(user.getEmail());
        dto.setPhonenumber(user.getPhonenumber());
        dto.setDateDeNaissance(user.getDateDeNaissance());
        user.setDateCreation(dto.getDateCreation());
        //dto.setRole(user.getRole());*/
        //dto.setDemandeEstateList(DemandeEstateMapper.mapToDTOList(user.getDemandeEstateList()));
        dto.setRole(user.getRole());


        return dto;
    }



    public static AppUser mapDtoToEntity(AppUserDTO dto) {
        AppUser user = new AppUser();
        user.setIdUser(dto.getIdUser());
        user.setFirstname(dto.getFirstname());
        user.setLastname(dto.getLastname());
        user.setUsernam(dto.getUsernam());
        user.setEmail(dto.getEmail());
        user.setPhonenumber(dto.getPhonenumber());
        user.setDateDeNaissance(dto.getDateDeNaissance());
        dto.setDateCreation(user.getDateCreation());
        //user.setDemandeEstateList(DemandeEstateMapper.mapToEntityList(dto.getDemandeEstateList()));
        user.setRole(dto.getRole());

        return user;
    }

}
