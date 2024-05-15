package MI.com.example.MI_Project.dto.Mapper;

import MI.com.example.MI_Project.dto.Model.EtatMiDto;
import MI.com.example.MI_Project.dto.Model.PrivilegeUserDto;
import MI.com.example.MI_Project.entities.EtatMi;
import MI.com.example.MI_Project.entities.PrivilegeUser;

public class PrivilegeUserMapper {
    public static PrivilegeUserDto maptoDto(PrivilegeUser privilegeUser) {
        if (privilegeUser != null) {
            PrivilegeUserDto privilegeUserDto = new PrivilegeUserDto();
            privilegeUserDto.setIdPrivilege(privilegeUser.getIdPrivilege());
            privilegeUserDto.setLibPrivilege(privilegeUser.getLibPrivilege());
            privilegeUserDto.setRoleIds(privilegeUser.getRoles());


            return privilegeUserDto;
        } else return null;
    }


    public static PrivilegeUser maptoEntity(PrivilegeUserDto privilegeUserDto) {
        if (privilegeUserDto != null) {

            PrivilegeUser privilegeUser= new PrivilegeUser();
            privilegeUser.setIdPrivilege(privilegeUserDto.getIdPrivilege());
            privilegeUser.setLibPrivilege(privilegeUserDto.getLibPrivilege());
            privilegeUser.setRoles(privilegeUserDto.getRoleIds());



            return privilegeUser;
        } else return null;
    }

}
