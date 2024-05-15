package MI.com.example.MI_Project.security.service;

import MI.com.example.MI_Project.security.dto.AppRoleDTO;
import MI.com.example.MI_Project.security.dtoMapper.MapperRole;
import MI.com.example.MI_Project.security.entities.AppRole;
import MI.com.example.MI_Project.security.entities.AppUser;
import MI.com.example.MI_Project.security.repository.AppRoleRepository;
import MI.com.example.MI_Project.security.repository.AppUserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class RoleServiceImp implements RoleService{
    private final AppRoleRepository roleRepository;
    private final AppUserRepository userRepository;

    @Autowired
    public RoleServiceImp(AppRoleRepository roleRepository, AppUserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }


    @Override
    public AppRoleDTO addRole(AppRoleDTO roleDTO) {
        // Convert DTO to entity
        AppRole role = MapperRole.dtoToEntity(roleDTO);
        role = roleRepository.save(role);
        return MapperRole.entityToDto(role);
    }

    @Override
    public void addRoleToUser(Integer userId, Integer roleId) {
        // Récupérer l'utilisateur et le rôle
        AppUser user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
        AppRole role =roleRepository.findById(roleId)
                .orElseThrow(() -> new EntityNotFoundException("Role not found with id: " + roleId));

        // Associer le rôle à l'utilisateur
        user.setRole(role);

        // Enregistrer l'utilisateur avec le nouveau rôle
        userRepository.save(user);

    }

    @Override
    public Set<AppRole> getAllRoles() {
        return new HashSet<>(roleRepository.findAll());

    }

    @Override
    public Set<AppRoleDTO> getAllRoles1() {
        // Obtenir tous les rôles de la base de données
        List<AppRole> roles = roleRepository.findAll();

        // Créer un nouvel ensemble pour stocker les DTO de rôle
        Set<AppRoleDTO> roleDTOs = new HashSet<>();

        // Mapper chaque rôle en son équivalent DTO
        for (AppRole role : roles) {
            AppRoleDTO roleDTO = MapperRole.entityToDto(role);
            roleDTOs.add(roleDTO);
        }

        return roleDTOs;
    }


}
