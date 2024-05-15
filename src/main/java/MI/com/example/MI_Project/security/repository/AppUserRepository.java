package MI.com.example.MI_Project.security.repository;

import MI.com.example.MI_Project.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser,Integer> {
    Optional<AppUser> findByEmail(String email);

}
