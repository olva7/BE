package MI.com.example.MI_Project.Repository;
import MI.com.example.MI_Project.entities.TypeCaracteristiqueMi;
import MI.com.example.MI_Project.entities.TypeCaracteristiqueMiId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TypeCaracteristiqueMiRepository extends JpaRepository<TypeCaracteristiqueMi, TypeCaracteristiqueMiId> {
    @Query(value = "select * from type_caracteristique_mi  where id_type=:idType ", nativeQuery = true)
    List<TypeCaracteristiqueMi> findAllByIdCaracteristique(@Param("idType") Integer idType);
}
