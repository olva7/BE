package MI.com.example.MI_Project.Repository;

import MI.com.example.MI_Project.entities.DocumentDemande;
import MI.com.example.MI_Project.entities.DocumentDemandeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentDemandeRepository extends JpaRepository<DocumentDemande, DocumentDemandeId> {
}
