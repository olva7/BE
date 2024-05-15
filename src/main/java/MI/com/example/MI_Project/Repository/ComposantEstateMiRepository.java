package MI.com.example.MI_Project.Repository;

import MI.com.example.MI_Project.entities.CaracteristiqueComposant;
import MI.com.example.MI_Project.entities.ComposantEstateMi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComposantEstateMiRepository extends JpaRepository<ComposantEstateMi, Integer> {
}