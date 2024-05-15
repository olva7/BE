package MI.com.example.MI_Project.security.dtoMapper;

import MI.com.example.MI_Project.security.dto.AppRoleDTO;
import MI.com.example.MI_Project.security.entities.AppRole;

public class MapperRole {
    private MapperRole() {
        throw new IllegalStateException("Utility class");
    }
    public static AppRoleDTO entityToDto(AppRole role) {
        AppRoleDTO dto = new AppRoleDTO();
        dto.setIdRole(role.getIdRole());
        dto.setRole(role.getRole());
        return dto;
    }

    public static AppRole dtoToEntity(AppRoleDTO dto) {
        AppRole role = new AppRole();
        role.setIdRole(dto.getIdRole());
        //role.setRole(dto.getRole());
        role.setRole(dto.getRole());
        return role;
    }
}
