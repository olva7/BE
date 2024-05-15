package MI.com.example.MI_Project.Repository;

import MI.com.example.MI_Project.entities.EstateMi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstateMiRepository extends JpaRepository<EstateMi, Integer> {
}