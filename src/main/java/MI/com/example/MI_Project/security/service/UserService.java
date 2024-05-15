package MI.com.example.MI_Project.security.service;

import MI.com.example.MI_Project.security.dto.AppUserDTO;
import MI.com.example.MI_Project.security.entities.AppUser;

import java.util.List;
import java.util.Optional;

public interface UserService {
    AppUser postUser(AppUser user);
    String deleteUser(Integer id);
    void updateUser(AppUser user,Integer id);
    List<AppUser> getUtilisateurs();

    AppUser findAppUserById(Integer id);
    AppUserDTO addUser1(AppUserDTO userDTO);
    AppUser assignRoleToUser(Integer userId, Integer roleId);
    List<AppUserDTO> getUtilisateurs1();
    AppUserDTO findAppUserById1(Integer id);
    public Integer fetchIdByEmail(String email);
    public List<AppUserDTO> getAllUsers();
}
