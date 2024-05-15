package MI.com.example.MI_Project.Repository;

import MI.com.example.MI_Project.entities.CaracteristiqueEstateMi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaracteristiqueEstateMiRepository extends JpaRepository<CaracteristiqueEstateMi, Integer> {
}