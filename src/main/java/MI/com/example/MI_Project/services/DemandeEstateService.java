package MI.com.example.MI_Project.services;

import MI.com.example.MI_Project.Repository.DemandeEstateRepository;
import MI.com.example.MI_Project.Repository.DocumentRepository;
import MI.com.example.MI_Project.Repository.EtatDemandeRepository;
import MI.com.example.MI_Project.dto.Mapper.DemandeEstateMapper;
import MI.com.example.MI_Project.dto.Model.DemandeEstateDto;
import MI.com.example.MI_Project.entities.*;
import MI.com.example.MI_Project.security.configuration.JwtService;
import MI.com.example.MI_Project.security.entities.AppRole;
import MI.com.example.MI_Project.security.entities.AppUser;
import MI.com.example.MI_Project.security.repository.AppUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DemandeEstateService {

    @Autowired
    private DemandeEstateRepository demandeEstateRepository;

    @Autowired
    private EtatDemandeRepository etatDemandeRepository;

    @Autowired
    private AppUserRepository userRepository;

    @Autowired
    private JwtService jwtService;
    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private DocumentDemandeService documentDemandeService;


    @Transactional
    public DemandeEstate addDemandeEstate(DemandeEstateDto demandeDTO, String authorizationHeader) {
        String jwt = authorizationHeader.substring(7);

        // Extraire l'email de l'utilisateur du JWT
        String emailUser = jwtService.extractUsername(jwt);

        // Trouver les détails de l'utilisateur à partir de son email
        AppUser user = userRepository.findByEmail(emailUser)
                .orElseThrow(() -> new IllegalArgumentException("No user found with email: " + emailUser));

        // Créer une nouvelle demande avec les détails fournis
        DemandeEstate demande = new DemandeEstate();
        demande.setReference(demandeDTO.getReference());
        demande.setPrixDemande(demandeDTO.getPrixDemande());
        demande.setPrixTotale(demandeDTO.getPrixTotale());
        // demande.setDateCreation(LocalDateTime.now());  // Assurez-vous d'ajouter la date de création

        // Associer l'utilisateur extrait du JWT
        demande.setAppUser(user);
        EtatDemande etatDemande = etatDemandeRepository.findById(1)
                .orElseThrow(() -> new RuntimeException("Default etat de demande not found!"));
        demande.setEtatDemande(etatDemande);
        // Sauvegarder la demande dans la base de données pour obtenir une référence valide
        demande = demandeEstateRepository.save(demande);

        // Récupérer tous les documents de la base de données
        List<Document> documentsList = documentRepository.findAll();
        for (Document item : documentsList) {
            // Créer une instance de DocumentDemande
            DocumentDemande documentDemande = new DocumentDemande();
            // Initialiser DocumentDemandeId avec les identifiants de demande et de document
            DocumentDemandeId documentDemandeId = new DocumentDemandeId(demande.getReference(), item.getIdDocument());
            documentDemande.setIdDocumentDemande(documentDemandeId);
            // Associer le document à la demande
            documentDemande.setIdDocument(item);
            documentDemande.setReference(demande);
            // Enregistrer DocumentDemande dans la base de données
            documentDemandeService.addDocumentDemande(documentDemande);
        }

        // Retourner la demande sauvegardée
        return demande;
    }
    public List<DemandeEstateDto> getAllDemandesEstate() {
        List<DemandeEstate> demandes = demandeEstateRepository.findAll();
        return demandes.stream()
                .map(DemandeEstateMapper::mapToDTO) // Utilisation du mapper pour convertir en DTO
                .collect(Collectors.toList());
    }
    public DemandeEstateDto getById(Integer id) {
        Optional<DemandeEstate> demandeOptional = demandeEstateRepository.findById(id);
        if (demandeOptional.isPresent()) {
            DemandeEstate demande = demandeOptional.get();
            return DemandeEstateMapper.mapToDTO(demande);
        } else {
            // Gérer le cas où la demande n'est pas trouvée (par exemple, lancer une exception)
            throw new NoSuchElementException("Demande with ID " + id + " not found");
        }
    }
    public long countEstatesByEtatEstateEquals2() {
        return demandeEstateRepository.countEstatesByEtatEstateEquals2();
    }
    public long countEstatesByEtatEstateEquals3() {
        return demandeEstateRepository.countEstatesByEtatEstateEquals3();
    }
    public long countEstatesByEtatEstateEquals1() {
        return demandeEstateRepository.countEstatesByEtatEstateEquals1();
    }
    public long countDemandes() {
        return demandeEstateRepository.countDemandes();
    }

    public List<DemandeEstateDto> getDemandesByUser(Integer userId) {
        List<DemandeEstate> demandesByUser = demandeEstateRepository.findByAppUser_IdUser(userId);
        return demandesByUser.stream()
                .map(DemandeEstateMapper::mapToDTO)
                .collect(Collectors.toList());
    }
    @Transactional
    public DemandeEstateDto updateDemandeEstateAccepter(Integer demandeId) {
        // Trouver la demande à mettre à jour
        DemandeEstate demande = demandeEstateRepository.findById(demandeId)
                .orElseThrow(() -> new IllegalArgumentException("No demande found with ID: " + demandeId));

        // Trouver l'état de demande à mettre à jour
        EtatDemande etatDemande = etatDemandeRepository.findById(2)
                .orElseThrow(() -> new RuntimeException("New etat de demande not found!"));

        // Mettre à jour l'état de la demande
        demande.setEtatDemande(etatDemande);

        // Sauvegarder la demande mise à jour dans la base de données
        demande = demandeEstateRepository.save(demande);

        // Retourner la demande mise à jour sous forme de DTO
        return DemandeEstateMapper.mapToDTO(demande);
    }
    @Transactional
    public DemandeEstateDto updateDemandeEstateRefuser(Integer demandeId) {
        // Trouver la demande à mettre à jour
        DemandeEstate demande = demandeEstateRepository.findById(demandeId)
                .orElseThrow(() -> new IllegalArgumentException("No demande found with ID: " + demandeId));

        // Trouver l'état de demande à mettre à jour
        EtatDemande etatDemande = etatDemandeRepository.findById(3)
                .orElseThrow(() -> new RuntimeException("New etat de demande not found!"));

        // Mettre à jour l'état de la demande
        demande.setEtatDemande(etatDemande);

        // Sauvegarder la demande mise à jour dans la base de données
        demande = demandeEstateRepository.save(demande);

        // Retourner la demande mise à jour sous forme de DTO
        return DemandeEstateMapper.mapToDTO(demande);
    }



}
