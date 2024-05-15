package MI.com.example.MI_Project.Controller;

import MI.com.example.MI_Project.services.DemandeImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@CrossOrigin("*")
@RestController
public class DemandeImageController {
    @Autowired
    private DemandeImageService uploadService;

    @PostMapping("upload/{reference}/{documentId}")
    public ResponseEntity<String> uploadImage(
            @RequestParam("file") MultipartFile file,
            @PathVariable Integer reference,
            @PathVariable Integer documentId) {

        try {
            uploadService.uploadImageAndUpdateDocument(file, reference, documentId);
            return ResponseEntity.ok("Upload successful and document updated");
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Failed to upload image: " + e.getMessage());
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body("Failed to update document: " + e.getMessage());
        }
    }
}
