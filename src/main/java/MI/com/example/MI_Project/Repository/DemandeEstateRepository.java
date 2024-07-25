package MI.com.example.MI_Project.Repository;

import MI.com.example.MI_Project.dto.Model.DemandeEstateDto;
import MI.com.example.MI_Project.entities.DemandeEstate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemandeEstateRepository extends JpaRepository<DemandeEstate,Integer> {

    List<DemandeEstate> findByAppUser_IdUser(Integer userId);
    @Query("SELECT COUNT(d) FROM DemandeEstate d")
    long countDemandes();
    @Query("SELECT COUNT(e) FROM EstateMi e WHERE e.etatEstate = 2")
    long countEstatesByEtatEstateEquals2();
    @Query("SELECT COUNT(e) FROM EstateMi e WHERE e.etatEstate = 3")
    long countEstatesByEtatEstateEquals3();
    @Query("SELECT COUNT(e) FROM EstateMi e WHERE e.etatEstate = 1")
    long countEstatesByEtatEstateEquals1();


}
