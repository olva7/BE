package MI.com.example.MI_Project.Controller;

import MI.com.example.MI_Project.Repository.EstateImageRepository;
import MI.com.example.MI_Project.entities.EstateImage;
import MI.com.example.MI_Project.services.EstateMiServiceImpl;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
public class EstateImageController {
    @Autowired
    private EstateMiServiceImpl imageUploadService;

    @Autowired
    private EstateImageRepository estateImageRepository;

    @PostMapping("/upload/{idestate}")
    public ResponseEntity<String> uploadImage(
            @PathVariable Integer idestate,
            @RequestParam("file") MultipartFile file) {
        return imageUploadService.uploadImage(idestate, file);
    }
    @GetMapping("/getAll/{id}")
    public ResponseEntity<List<EstateImage>> getByIdImageData(@PathVariable Integer id) {
        List<EstateImage> images = estateImageRepository.findByIdEstate(id);
        return ResponseEntity.ok(images);
    }
    @GetMapping("/images")
    public List<String> getAllImageData() {
        return estateImageRepository.findAll().stream()
                .map(this::convertToBase64)
                .collect(Collectors.toList());
    }
    private String convertToBase64(EstateImage image) {
        ByteBuffer imageData = image.getImageData();
        byte[] bytesArray = new byte[imageData.remaining()];
        imageData.get(bytesArray);
        return Base64.encodeBase64String(bytesArray);
    }
}
