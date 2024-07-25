package MI.com.example.MI_Project.Repository;

import MI.com.example.MI_Project.entities.CategorieMi;
import MI.com.example.MI_Project.entities.TypeEstateMi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategorieMiRepository extends JpaRepository<CategorieMi, Integer> {


}