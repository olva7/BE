package MI.com.example.MI_Project.dto.Mapper;

import MI.com.example.MI_Project.dto.Model.CategorieMiDto;
import MI.com.example.MI_Project.dto.Model.CategorieTypeMiDto;
import MI.com.example.MI_Project.dto.Model.DocumentDemandeDto;
import MI.com.example.MI_Project.entities.CategorieMi;
import MI.com.example.MI_Project.entities.CategorieType;
import MI.com.example.MI_Project.entities.DocumentDemande;

public class DocumentDemandeMapper {
    public static DocumentDemandeDto maptoDto(DocumentDemande documentDemande) {
        if (documentDemande != null) {
            DocumentDemandeDto documentDemandeDto = new DocumentDemandeDto();
            documentDemandeDto.setDocument(documentDemande.getIdDocument());
            documentDemandeDto.setDemandeEstate(documentDemande.getReference());
            documentDemandeDto.setIdImage(documentDemande.getIdImage());


            return documentDemandeDto;
        } else return null;
    }


    public static DocumentDemande maptoEntity(DocumentDemandeDto documentDemandeDto) {
        if (documentDemandeDto != null) {

            DocumentDemande documentDemande= new DocumentDemande();
            documentDemande.setIdDocument(documentDemandeDto.getDocument());
            documentDemande.setReference(documentDemandeDto.getDemandeEstate());
            documentDemande.setIdImage(documentDemandeDto.getIdImage());

            return documentDemande;
        } else return null;
    }
}
