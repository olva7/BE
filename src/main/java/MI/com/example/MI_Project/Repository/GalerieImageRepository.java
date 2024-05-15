package MI.com.example.MI_Project.Repository;

import MI.com.example.MI_Project.entities.GalerieImage;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface GalerieImageRepository extends CassandraRepository<GalerieImage, UUID> {

    @org.springframework.data.cassandra.repository.Query("SELECT * FROM image_data WHERE estate_id = ?0 ALLOW FILTERING")
    List<GalerieImage> findByEstateId(Integer estateId);
}
