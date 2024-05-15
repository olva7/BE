package MI.com.example.MI_Project.services;

import MI.com.example.MI_Project.Repository.DemandeImageRepository;
import MI.com.example.MI_Project.Repository.DocumentDemandeRepository;
import MI.com.example.MI_Project.entities.DemandeImage;
import MI.com.example.MI_Project.entities.DocumentDemande;
import MI.com.example.MI_Project.entities.DocumentDemandeId;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.UUID;

@Service
public class DemandeImageService {
    @Autowired
    private DemandeImageRepository imageDataRepository;

    @Autowired
    private DocumentDemandeRepository documentDemandeRepository;

    @Transactional
    public void uploadImageAndUpdateDocument(MultipartFile file, Integer reference, Integer documentId) throws IOException {
        UUID imageId = UUID.randomUUID();

        // Convertir le fichier en ByteBuffer
        ByteBuffer byteBuffer = ByteBuffer.wrap(file.getBytes());

        // Sauvegarder l'image dans Cassandra
        DemandeImage imageData = new DemandeImage();
        imageData.setIdImage(imageId);
        imageData.setImageData(byteBuffer);
        imageDataRepository.save(imageData);

        // Trouver et mettre à jour DocumentDemande
        DocumentDemandeId documentDemandeId = new DocumentDemandeId(reference, documentId);
        DocumentDemande documentDemande = documentDemandeRepository.findById(documentDemandeId)
                .orElseThrow(() -> new IllegalStateException("DocumentDemande not found"));
        documentDemande.setIdImage(imageId);
        documentDemandeRepository.save(documentDemande);
    }
}
