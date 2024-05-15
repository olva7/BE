package MI.com.example.MI_Project.Controller;

import MI.com.example.MI_Project.entities.GalerieImage;
import MI.com.example.MI_Project.entities.GalerieMi;
import MI.com.example.MI_Project.services.GalerieMiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("api/galerie")
public class GalrieImageController {
    @Autowired
    private GalerieMiServiceImpl galerieService;

    /**
     * Endpoint pour ajouter une image à la galerie.
     *
     * @param file L'image à uploader.
     * @param estateId L'identifiant de la propriété associée.

     * @param tag Un tag optionnel pour l'image.
     * @return ResponseEntity avec les détails de la galerie ou un message d'erreur.
     */
    @PostMapping
    public ResponseEntity<?> addImageToGalerie(
            @RequestParam("file") MultipartFile file,
            @RequestParam("estateId") Integer estateId,
            @RequestParam(value = "tag", required = false) String tag) {

        try {
            GalerieMi galerie = galerieService.addGalerie(file, estateId, tag);
            return ResponseEntity.ok(galerie);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error uploading image: " + e.getMessage());
        }
    }
    @GetMapping("/images/estate/{estateId}")
    public ResponseEntity<List<GalerieImage>> getImagesByEstateId(@PathVariable Integer estateId) {
        try {
            List<GalerieImage> images = galerieService.getImagesByEstateId(estateId);
            return ResponseEntity.ok(images);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }
}
