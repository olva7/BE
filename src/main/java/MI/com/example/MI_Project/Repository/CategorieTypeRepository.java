package MI.com.example.MI_Project.Repository;

import MI.com.example.MI_Project.entities.CategorieType;
import MI.com.example.MI_Project.entities.CategorieTypeMiId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategorieTypeRepository extends JpaRepository<CategorieType, CategorieTypeMiId> {
    @Query(value = "select * from categorie_type  where id_categorie=:idCategorie ", nativeQuery = true)
    List<CategorieType> findAllByIdCategorieMi(@Param("idCategorie") Integer idCategorie);
}