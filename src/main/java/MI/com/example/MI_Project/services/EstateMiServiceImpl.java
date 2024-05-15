package MI.com.example.MI_Project.services;

import MI.com.example.MI_Project.Repository.EstateImageRepository;
import MI.com.example.MI_Project.Repository.EstateMiRepository;
import MI.com.example.MI_Project.Repository.TypeEstateMiRepository;
import MI.com.example.MI_Project.dto.Mapper.AgenceImmobilierMapper;
import MI.com.example.MI_Project.dto.Mapper.EstateMiMapper;
import MI.com.example.MI_Project.dto.Model.EstateMiDto;
import MI.com.example.MI_Project.entities.*;
import MI.com.example.MI_Project.security.configuration.JwtService;
import MI.com.example.MI_Project.security.dto.AppUserDTO;
import MI.com.example.MI_Project.security.dtoMapper.MapperModel;
import MI.com.example.MI_Project.security.entities.AppUser;
import MI.com.example.MI_Project.security.repository.AppUserRepository;
import jakarta.transaction.Transactional;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EstateMiServiceImpl {


    private final EstateMiRepository estateMiRepository;


    private final JwtService jwtService;

    @Autowired
    private EstateImageRepository estateImageRepository;



    private final AppUserRepository appUserRepository;
    @Autowired

    public EstateMiServiceImpl(EstateMiRepository estateMiRepository, JwtService jwtService, AppUserRepository appUserRepository) {
        this.estateMiRepository = estateMiRepository;
        this.jwtService = jwtService;
        this.appUserRepository = appUserRepository;
    }


    public EstateMi addEstate(EstateMi estateMi) {
        // Validate or throw exceptions if necessary

        //validateEstate(estateMi);
        return estateMiRepository.save(estateMi);
    }
    public ResponseEntity<String> uploadImage( Integer idEstate, MultipartFile file) {

        // Assuming you have a method to check the existence of the estate
        if (!estateExists(idEstate)) {
            return ResponseEntity.badRequest().body("Estate not found!");
        }

        try {
            UUID imageId = UUID.randomUUID(); // Generate a unique ID for the image
            Date uploadDate = new Date(); // Get the current upload date
            String yearMonth = new SimpleDateFormat("yyyy-MM").format(uploadDate); // Format the date in year-month format

            // Compress and convert the image to a byte array
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            Thumbnails.of(file.getInputStream())
                    .size(800, 600) // Resize the image
                    .outputQuality(0.75) // Reduce quality for smaller size
                    .outputFormat("jpg") // Convert to JPG
                    .toOutputStream(outputStream);
            byte[] compressedImage = outputStream.toByteArray();
            ByteBuffer imageData = ByteBuffer.wrap(compressedImage); // Wrap the compressed byte array into a ByteBuffer

            // Calculate compression ratio
            long originalSize = file.getSize();
            long compressedSize = compressedImage.length;
            double compressionRatio = 100 - (compressedSize * 100.0 / originalSize);

            EstateImage.EstateImageKey key = new EstateImage.EstateImageKey(idEstate, yearMonth, imageId);
            EstateImage estateImage = new EstateImage(key, imageData, uploadDate);

            estateImageRepository.save(estateImage); // Save to Cassandra

            // Add compression details to the response
            String responseMessage = String.format("Image uploaded successfully with ID: %s. Original size: %d bytes, Compressed size: %d bytes, Compression ratio: %.2f%%",
                    imageId, originalSize, compressedSize, compressionRatio);
            return ResponseEntity.ok(responseMessage);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to upload image: " + e.getMessage());
        }
    }

    private boolean estateExists(Integer idEstate) {
        // Implement the logic to check if the estate exists in your repository
        return true; // Placeholder for demonstration
    }

  /*  public EstateMi addEstatedto(EstateMiDto estateMiDto, String authorizationHeader) {
        // Extraire le JWT du header d'autorisation
        String jwt = authorizationHeader.substring(7);

        // Extraire l'email de l'utilisateur du JWT
        String emailUser = jwtService.extractUsername(jwt);

        // Afficher l'email extrait pour le débogage
        System.out.println("Email extracted from JWT: " + emailUser);

        // Trouver les détails de l'utilisateur à partir de son email
        Optional<AppUser> userDetails = appUserRepository.findByEmail(emailUser);
        System.out.println("User details present: " + userDetails.isPresent());

        // Vérifier si l'utilisateur existe
        if (userDetails.isPresent()) {
            // Récupérer l'utilisateur à partir des détails trouvés
            AppUser user = userDetails.get();

            // Mapper le DTO EstateMi vers une entité EstateMi
            EstateMi newEstateMi = EstateMiMapper.mapToEntity(estateMiDto);

            // Définir l'utilisateur associé à l'estate
            newEstateMi.setIdUser(user);

            // Définir des propriétés supplémentaires si nécessaire
            newEstateMi.setEtatEstate(2);  // Supposons que le réglage de l'état soit nécessaire

            // Enregistrer et renvoyer l'entité
            return estateMiRepository.save(newEstateMi);
        } else {
            throw new IllegalArgumentException("No user found with email: " + emailUser);
        }
    }*/
  public EstateMi addEstatedto(EstateMiDto estateMiDto, String authorizationHeader) {
      String jwt = authorizationHeader.substring(7);
      String emailUser = jwtService.extractUsername(jwt);
      System.out.println("Email extracted from JWT: " + emailUser);

      Optional<AppUser> userDetails = appUserRepository.findByEmail(emailUser);
      System.out.println("User details present: " + userDetails.isPresent());
      AppUser user = userDetails.orElseThrow(() -> new IllegalArgumentException("No user found with email: " + emailUser));
      System.out.println("User details retrieved: " + user);

      AppUserDTO dto = MapperModel.mapEntityToDto(user);
      System.out.println("DTO created: " + dto);
      if (dto == null) {
          throw new IllegalStateException("DTO conversion resulted in null");
      }

      EstateMi newEstateMi = EstateMiMapper.mapToEntity(estateMiDto);
      System.out.println("EstateMi entity created: " + newEstateMi);
      if (dto != null) {
          System.out.println("DTO before getIdUser: " + dto);
          Integer userId = dto.getIdUser();
          System.out.println("User ID from DTO: " + userId);
      } else {
          throw new IllegalStateException("DTO is null after creation");
      }
      newEstateMi.setIdUser(user);
      newEstateMi.setEtatEstate(2);  // Set other necessary properties

      // Validate estate if needed
      // validateEstate(newEstateMi);

      return estateMiRepository.save(newEstateMi);
  }




    /*private void validateEstate(EstateMi estateMi) {
        // Validation logic, e.g., check not null fields
        if ( estateMi.getIdType() == null) {
            throw new IllegalArgumentException("Agence, Type, and Localisation must not be null");
        }
    }*/
    public Optional<EstateMiDto> getEstateById(Integer id) {
        return estateMiRepository.findById(id)
                .map(EstateMiMapper::mapToDTO);
    }
    public List<EstateMiDto> getAllEstates() {
        List<EstateMi> estates = estateMiRepository.findAll();
        return estates.stream()
                .map(EstateMiMapper::mapToDTO)
                .collect(Collectors.toList());
    }

}
