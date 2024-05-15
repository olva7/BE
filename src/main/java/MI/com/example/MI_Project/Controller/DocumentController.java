package MI.com.example.MI_Project.Controller;

import MI.com.example.MI_Project.dto.Model.DocumentDto;
import MI.com.example.MI_Project.entities.Document;
import MI.com.example.MI_Project.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin("*")
@RestController
public class DocumentController {
    @Autowired
    private DocumentService documentService;

    @PostMapping("document")
    public ResponseEntity<Document> addDocument(@RequestBody DocumentDto documentDto) {
        Document savedDocument = documentService.addDocument(documentDto);
        return ResponseEntity.ok(savedDocument);
    }
    @GetMapping("document/all")
    public ResponseEntity<List<Document>> getAllDocuments() {
        List<Document> documents = documentService.getAll();
        return ResponseEntity.ok(documents);
    }

    @GetMapping("document/{id}")
    public ResponseEntity<Document> getDocumentById(@PathVariable Integer id) {
        Optional<Document> document = documentService.getById(id);
        return document.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
