package MI.com.example.MI_Project.security.service;

import MI.com.example.MI_Project.security.dto.AppUserDTO;
import MI.com.example.MI_Project.security.dtoMapper.MapperModel;
import MI.com.example.MI_Project.security.entities.AppRole;
import MI.com.example.MI_Project.security.entities.AppUser;
import MI.com.example.MI_Project.security.repository.AppRoleRepository;
import MI.com.example.MI_Project.security.repository.AppUserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserserviceImpl implements UserService{
    private final AppUserRepository userRepository;

    private final AppRoleRepository roleRepository;
    @Autowired
    public UserserviceImpl(AppUserRepository userRepository, AppRoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }
    @Override
    public AppUser postUser(@RequestBody AppUser user) {
        Optional<AppUser> existingUser= userRepository.findByEmail(user.getEmail());
        if(existingUser.isPresent()){
            throw new IllegalArgumentException("Cette utilisateur existe déja!");
        }
        AppRole defaultRole = roleRepository.findById(1)
                .orElseThrow(() -> new RuntimeException("Default role not found!"));
        user.setRole(defaultRole);
        return userRepository.save(user);
    }

    @Override
    public String deleteUser(Integer id) {
        userRepository.deleteById(id);
        return"done";
    }

    @Override
    public void updateUser(AppUser user, Integer id) {
        AppUser oldUser = userRepository.findById(id).orElseThrow(() ->new RuntimeException("Cette utilisateurs n'existe pas!!"));
        oldUser.setFirstname(user.getFirstname());
        oldUser.setLastname(user.getLastname());
        oldUser.setUsernam(user.getUsernam());
        oldUser.setPhonenumber(user.getPhonenumber());
        oldUser.setDateDeNaissance(user.getDateDeNaissance());
        userRepository.save(oldUser);

    }

    @Override
    public List<AppUser> getUtilisateurs() {
        return userRepository.findAll();
    }

    @Override
    public AppUser findAppUserById(Integer id) {
        Optional<AppUser> userOptional = userRepository.findById(id);
        return userOptional.orElseThrow(() -> new RuntimeException("No user found with id " + id));
    }

    @Override
    public AppUserDTO addUser1(AppUserDTO userDTO) {
        Optional<AppUser> existingUser= userRepository.findByEmail(userDTO.getEmail());
        if(existingUser.isPresent()){
            throw new IllegalArgumentException("Cette utilisateur existe déja!");
        }
        // Convert DTO to entity
        AppUser user = MapperModel.mapDtoToEntity(userDTO);
        user = userRepository.save(user);
        return MapperModel.mapEntityToDto(user);
    }

    @Override
    public AppUser assignRoleToUser(Integer userId, Integer roleId) {
        // Retrieve the user and the role from the database
        AppUser user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
        AppRole role = roleRepository.findById(roleId).orElseThrow(() -> new EntityNotFoundException("Role not found with id: " + roleId));

        // Assign the role to the user
        user.setRole(role);
        userRepository.save(user);

        return user;
    }


   /* public void updateUser1(AppUserDTO user, Integer id) {
        AppUser oldUser = userRepository.findById(id).orElseThrow(() ->new RuntimeException("Cette utilisateurs n'existe pas!!"));
        oldUser.setFirstname(user.getFirstname());
        oldUser.setLastname(user.getLastname());
        oldUser.setUsernam(user.getUsernam());
        oldUser.setPhonenumber(user.getPhonenumber());
        oldUser.setDateDeNaissance(user.getDateDeNaissance());
        userRepository.save(oldUser);

    }*/
   @Override
   public List<AppUserDTO> getAllUsers() {
       List<AppUser> users = userRepository.findAll();
       return users.stream()
               .map(MapperModel::mapEntityToDto)
               .collect(Collectors.toList());
   }


    @Override
    public List<AppUserDTO> getUtilisateurs1() {
        List<AppUser> users = userRepository.findAll();
        return users.stream()
                .map(MapperModel::mapEntityToDto) // Utilisez votre méthode de mappage pour convertir AppUser en AppUserDTO
                .collect(Collectors.toList());
    }

    @Override
    public AppUserDTO findAppUserById1(Integer id) {
        Optional<AppUser> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            AppUser user = userOptional.get();
            return MapperModel.mapEntityToDto(user);
        } else {
            return null;
        }
    }
    @Override
    public Integer fetchIdByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(AppUser::getIdUser)
                .orElse(null);  // Retourne null si aucun utilisateur n'est trouvé
    }


}
