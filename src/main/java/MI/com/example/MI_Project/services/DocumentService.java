package MI.com.example.MI_Project.services;

import MI.com.example.MI_Project.Repository.DocumentRepository;
import MI.com.example.MI_Project.dto.Model.DocumentDto;
import MI.com.example.MI_Project.entities.Document;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {
    @Autowired
    private DocumentRepository documentRepository;
    @Transactional
    public Document addDocument(DocumentDto documentDto) {
        Document document = new Document();
        document.setIdDocument(documentDto.getIdDocument());
        document.setDocumentLib(documentDto.getDocumentLib());


        // Logique supplémentaire ici si nécessaire

        return documentRepository.save(document);
    }
    public List<Document> getAll() {
        return documentRepository.findAll();
    }

    public Optional<Document> getById(Integer id) {
        return documentRepository.findById(id);
    }

}
