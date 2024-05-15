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
}
