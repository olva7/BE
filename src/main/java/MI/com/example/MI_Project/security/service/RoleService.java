package MI.com.example.MI_Project.security.service;

import MI.com.example.MI_Project.security.dto.AppRoleDTO;
import MI.com.example.MI_Project.security.entities.AppRole;

import java.util.Set;

public interface RoleService {
    AppRoleDTO addRole(AppRoleDTO roleDTO);
    void addRoleToUser(Integer userId, Integer roleId) ;


    Set<AppRole> getAllRoles();
    Set<AppRoleDTO> getAllRoles1();
}
