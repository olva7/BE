package MI.com.example.MI_Project.Controller;

import MI.com.example.MI_Project.dto.Mapper.EstateMiMapper;
import MI.com.example.MI_Project.dto.Model.EstateMiDto;
import MI.com.example.MI_Project.entities.EstateMi;
import MI.com.example.MI_Project.services.EstateMiServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class EstateMiController {
    @Autowired
    private EstateMiServiceImpl estateMiService;

    @PostMapping("/add")
    public ResponseEntity<EstateMiDto> addEstate(@RequestBody EstateMiDto newEstateMiDto) {
        // Map the DTO to an entity right away
        EstateMi estateMi = EstateMiMapper.mapToEntity(newEstateMiDto);

        // Assuming the mapper handles null checks and sets up default or existing relationships
        // The following code assumes that your service layer may handle some business logic
        EstateMi savedEstateMi = estateMiService.addEstate(estateMi);

        // Map the saved entity back to DTO to return
        EstateMiDto estateMiDto = EstateMiMapper.mapToDTO(savedEstateMi);
        return ResponseEntity.ok(estateMiDto);
    }

    /*public ResponseEntity<EstateMi> addEstatedto(@RequestBody EstateMiDto estateMiDto) {
        try {
            EstateMi estateMi = estateMiService.addEstatedto(estateMiDto,);
            return ResponseEntity.ok(estateMi);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }*/
  /*  @PostMapping("/adding")
    public ResponseEntity<EstateMi> addEstate(@RequestBody EstateMiDto estateMiDto,
                                              @RequestHeader("Authorization") String authorizationHeader) {
        try {
            EstateMi newEstate = estateMiService.addEstatedto(estateMiDto, authorizationHeader);
            return ResponseEntity.ok(newEstate);
        } catch (IllegalArgumentException | IllegalStateException e) {
            return ResponseEntity.badRequest().body(null); // Vous pouvez personnaliser le message d'erreur si nécessaire
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // Gérer d'autres exceptions imprévues
        }
    }*/


    @PostMapping("/adding")
    public ResponseEntity<Object> addEstate(@RequestBody EstateMiDto estateMiDto,
                                            @RequestHeader("Authorization") String authorizationHeader) {
        try {
            if (estateMiDto == null) {
                return ResponseEntity.badRequest().body("Le DTO immobilier est null.");
            }

            EstateMi newEstate = estateMiService.addEstatedto(estateMiDto, authorizationHeader);
            return ResponseEntity.ok(newEstate);
        } catch (IllegalArgumentException | IllegalStateException e) {
            String errorMessage = "Erreur dans la requête : " + e.getMessage();
            return ResponseEntity.badRequest().body(errorMessage); // Personnalisez le message d'erreur
        } catch (Exception e) {
            String errorMessage = "Une erreur est survenue lors de l'ajout de l'immobilier : " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage); // Personnalisez le message d'erreur
        }
    }
    /*@PostMapping("/estates")
    public ResponseEntity<?> addEstate1(
            @RequestBody EstateMiDto estateMiDto,
            @RequestHeader("Authorization") String authorizationHeader) {

        try {
            EstateMi newEstate = estateMiService.addEstatedto(estateMiDto, authorizationHeader);
            return ResponseEntity.ok(newEstate);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while adding the estate.");
        }
    }*/


    @GetMapping("get/{id}")
    public ResponseEntity<EstateMiDto> getEstate(@PathVariable Integer id) {
        return estateMiService.getEstateById(id)
                .map(ResponseEntity::ok)  // if the estate is found, return DTO with status 200
                .orElseGet(() -> ResponseEntity.notFound().build());  // if not found, return 404 Not Found
    }
    @GetMapping("/estates")
    public List<EstateMiDto> getAllEstate() {
        return estateMiService.getAllEstates();
    }
}
