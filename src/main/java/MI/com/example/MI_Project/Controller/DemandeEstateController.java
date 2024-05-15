package MI.com.example.MI_Project.Controller;

import MI.com.example.MI_Project.dto.Model.DemandeEstateDto;
import MI.com.example.MI_Project.entities.DemandeEstate;
import MI.com.example.MI_Project.entities.Document;
import MI.com.example.MI_Project.services.DemandeEstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class DemandeEstateController {
    @Autowired
    private DemandeEstateService demandeEstateService;



    @PostMapping("demande")
    public ResponseEntity<DemandeEstate> createDemande(
            @RequestBody DemandeEstateDto demandeDTO,
            @RequestHeader("Authorization") String authorizationHeader) {
        DemandeEstate savedDemande = demandeEstateService.addDemandeEstate(demandeDTO, authorizationHeader);
        return ResponseEntity.ok(savedDemande);
    }
    @GetMapping("demandes/{id}")
    public ResponseEntity<DemandeEstateDto> getDemandeById(@PathVariable Integer id) {
        DemandeEstateDto demandeDto = demandeEstateService.getById(id);
        return ResponseEntity.ok(demandeDto);
    }

    @PostMapping("addDemande")
    public ResponseEntity<DemandeEstate> addDemandeEstate(@RequestBody DemandeEstateDto demandeDTO,
                                                          @RequestHeader("Authorization") String authorizationHeader) {
        DemandeEstate newDemandeEstate = demandeEstateService.addDemandeEstate(demandeDTO, authorizationHeader);
        return ResponseEntity.ok(newDemandeEstate);
    }
    @GetMapping("demendes/all")
    public List<DemandeEstateDto> getAllDemandesEstate() {
        return demandeEstateService.getAllDemandesEstate();
    }
    @GetMapping("user/{userId}")
    public List<DemandeEstateDto> getDemandeByUser(@PathVariable Integer userId) {
        return demandeEstateService.getDemandesByUser(userId);
    }
    @PutMapping("/mettre-a-jour-accepter/{demandeId}")
    public ResponseEntity<DemandeEstateDto> updateDemandeEstateAccepter(@PathVariable Integer demandeId) {
        DemandeEstateDto demandeMiseAJour = demandeEstateService.updateDemandeEstateAccepter(demandeId);
        return ResponseEntity.ok(demandeMiseAJour);
    }
    @PutMapping("/mettre-a-jour-refuser/{demandeId}")
    public ResponseEntity<DemandeEstateDto> updateDemandeEstateRefuser(@PathVariable Integer demandeId) {
        DemandeEstateDto demandeMiseAJour = demandeEstateService.updateDemandeEstateRefuser(demandeId);
        return ResponseEntity.ok(demandeMiseAJour);
    }



}
