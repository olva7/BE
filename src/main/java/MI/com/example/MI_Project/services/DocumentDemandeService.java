package MI.com.example.MI_Project.services;

import MI.com.example.MI_Project.Repository.DocumentDemandeRepository;
import MI.com.example.MI_Project.dto.Mapper.DocumentDemandeMapper;
import MI.com.example.MI_Project.dto.Model.DocumentDemandeDto;
import MI.com.example.MI_Project.entities.DocumentDemande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DocumentDemandeService {
    @Autowired
    private DocumentDemandeRepository documentDemandeRepository;

    public ResponseEntity<DocumentDemandeDto> addDocumentDemande(DocumentDemande newDocumentDemande) {

        return ResponseEntity.ok(DocumentDemandeMapper.maptoDto(documentDemandeRepository.save(newDocumentDemande)));
    }
}
