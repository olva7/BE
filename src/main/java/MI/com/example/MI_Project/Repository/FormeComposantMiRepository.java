package MI.com.example.MI_Project.Repository;

import MI.com.example.MI_Project.entities.FormeComposantMi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormeComposantMiRepository extends JpaRepository<FormeComposantMi, Integer> {
}