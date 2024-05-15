package MI.com.example.MI_Project.services;

import MI.com.example.MI_Project.Repository.EstateMiRepository;
import MI.com.example.MI_Project.Repository.GalerieImageRepository;
import MI.com.example.MI_Project.Repository.GalerieMiRepository;
import MI.com.example.MI_Project.entities.GalerieImage;
import MI.com.example.MI_Project.entities.GalerieMi;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.UUID;

@Service
public class GalerieMiServiceImpl {
    @Autowired
    private GalerieMiRepository galerieRepository;

    @Autowired
    private GalerieImageRepository imageDataRepository;
    @Autowired
    private EstateMiRepository estateMiRepository;

    @Transactional
    public GalerieMi addGalerie(MultipartFile file, Integer estateId, String tag) throws IOException {
        UUID imageId = UUID.randomUUID();

        // Convertir le fichier en ByteBuffer
        ByteBuffer byteBuffer = ByteBuffer.wrap(file.getBytes());

        // Sauvegarder l'image dans Cassandra avec l'ID estate
        GalerieImage imageData = new GalerieImage();
        imageData.setId(imageId);
        imageData.setImageData(byteBuffer);
        imageData.setTag(tag);
        imageData.setEstateId(estateId);  // Inclure l'ID estate
        imageDataRepository.save(imageData);

        // Créer une nouvelle galerie et la sauvegarder
        GalerieMi galerie = new GalerieMi();
        galerie.setIdEstate(estateMiRepository.findById(estateId).orElseThrow());
        //galerie.setIdTypeGalerie(galerieTypeRepository.findById(typeGalerieId).orElseThrow());
        galerie.setUrlGalerie(imageId.toString());  // Utiliser l'UUID comme URL fictive
        galerie.setTag(tag);
        galerieRepository.save(galerie);

        return galerie;
    }
    public List<GalerieImage> getImagesByEstateId(Integer estateId) {
        return imageDataRepository.findByEstateId(estateId);
    }

}
