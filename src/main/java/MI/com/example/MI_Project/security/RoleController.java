package MI.com.example.MI_Project.security;

import MI.com.example.MI_Project.security.entities.AppRole;
import MI.com.example.MI_Project.security.entities.AppUser;
import MI.com.example.MI_Project.security.repository.AppRoleRepository;
import MI.com.example.MI_Project.security.repository.AppUserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class RoleController {
    @Autowired
    private AppUserRepository userRepository;

    @Autowired
    private AppRoleRepository roleRepository;

    public RoleController(AppUserRepository userRepository, AppRoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @PutMapping("/{userId}/roles/{roleId}")
    public ResponseEntity<?> addRoleToUser(@PathVariable Integer userId, @PathVariable Integer roleId) {
        try {
            AppUser user = userRepository.findById(userId)
                    .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
            AppRole role = roleRepository.findById(roleId)
                    .orElseThrow(() -> new EntityNotFoundException("Role not found with id: " + roleId));

            user.setRole(role);
            userRepository.save(user);

            return ResponseEntity.ok("Role added to user successfully");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
