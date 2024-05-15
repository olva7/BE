package MI.com.example.MI_Project.Repository;

import MI.com.example.MI_Project.entities.CaracteristiqueComposant;
import MI.com.example.MI_Project.entities.EtatMi;
import MI.com.example.MI_Project.entities.EtatMiId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaracteristiqueComposantRepository extends JpaRepository<CaracteristiqueComposant, Integer> {
}