package MI.com.example.MI_Project.security;

import MI.com.example.MI_Project.security.dto.AppUserDTO;
import MI.com.example.MI_Project.security.dtoMapper.MapperModel;
import MI.com.example.MI_Project.security.entities.AppUser;
import MI.com.example.MI_Project.security.repository.AppUserRepository;
import MI.com.example.MI_Project.security.service.UserserviceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin("*")
public class AppUserController {
    @Autowired
    private UserserviceImpl userService;
    @Autowired
    private AppUserRepository userRepository;

    @GetMapping("/search/by-email")
    public AppUser getUserByEmail(@RequestParam String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with email: " + email));
    }
    @PutMapping("/users/{id}")
    public ResponseEntity<String> updateUser(@RequestBody AppUser user, @PathVariable Integer id) {
        try {
            AppUser oldUser = userRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Cette utilisateurs n'existe pas!!"));
            oldUser.setFirstname(user.getFirstname());
            oldUser.setLastname(user.getLastname());
            //oldUser.setUsername(user.getUsername());  // Assuming correct getter is getUsername.
           // oldUser.setPhoneNumber(user.getPhoneNumber());  // Assuming correct getter is getPhoneNumber.
            //oldUser.setDateOfBirth(user.getDateOfBirth());  // Assuming correct getter is getDateOfBirth.
            userRepository.save(oldUser);
            return ResponseEntity.ok("User updated successfully");
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/api/users/fetch-id")
    public Integer fetchUserIdByEmail(@RequestParam String email) {
        return userService.fetchIdByEmail(email);
    }
    @GetMapping("/api/users/{id}")
    public ResponseEntity<AppUserDTO> getUserById(@PathVariable Integer id) {
        AppUser user = userService.findAppUserById(id);
        AppUserDTO userDTO = MapperModel.mapEntityToDto(user);
        return ResponseEntity.ok(userDTO);
    }
    @GetMapping("get-all-users")
    public ResponseEntity<List<AppUserDTO>> getAllUsers() {
        List<AppUserDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

}
