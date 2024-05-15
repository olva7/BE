package MI.com.example.MI_Project.Repository;

import MI.com.example.MI_Project.entities.TypeCaracteristiqueMi;
import MI.com.example.MI_Project.entities.TypeCaracteristiqueMiId;
import MI.com.example.MI_Project.entities.TypeComposant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TypeComposantRepository extends JpaRepository<TypeComposant, Integer> {
}