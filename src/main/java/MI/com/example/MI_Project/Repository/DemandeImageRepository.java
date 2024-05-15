package MI.com.example.MI_Project.Repository;

import MI.com.example.MI_Project.entities.DemandeImage;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DemandeImageRepository extends CassandraRepository<DemandeImage, UUID> {
}
