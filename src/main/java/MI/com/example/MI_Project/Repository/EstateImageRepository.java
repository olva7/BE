package MI.com.example.MI_Project.Repository;

import MI.com.example.MI_Project.entities.EstateImage;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EstateImageRepository extends CassandraRepository<EstateImage, EstateImage.EstateImageKey> {
    @Query("SELECT * FROM estate_images WHERE idestate = ?0 ALLOW FILTERING")
    List<EstateImage> findByIdEstate(Integer idEstate);
    EstateImage findByKey(EstateImage.EstateImageKey key);

    List<EstateImage> findByKey_IdEstateAndKey_YearMonth(Integer idEstate, String yearMonth);
}
