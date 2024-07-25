package MI.com.example.MI_Project.Repository;

import MI.com.example.MI_Project.entities.EstateMi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstateMiRepository extends JpaRepository<EstateMi, Integer> {
    @Query("SELECT e.categorieMiTag, COUNT(e) FROM EstateMi e GROUP BY e.categorieMiTag")
    List<Object[]> countEstatesByCategory();
    @Query("SELECT COUNT(e) FROM EstateMi e")
    long countEstates();

}