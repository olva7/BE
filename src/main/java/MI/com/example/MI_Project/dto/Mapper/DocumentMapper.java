package MI.com.example.MI_Project.dto.Mapper;

import MI.com.example.MI_Project.dto.Model.DocumentDto;

import MI.com.example.MI_Project.entities.Document;

public class DocumentMapper {
    public static DocumentDto mapToDTO(Document document) {

        if (document != null) {


            return new DocumentDto()
                    .setIdDocument(document.getIdDocument())

                    .setDocumentLib(document.getDocumentLib());

        } else
            return null;
    }

    public static Document mapToEntity(DocumentDto documentDto) {
        if (documentDto != null) {
            Document document = new Document();
            document.setIdDocument(documentDto.getIdDocument());

            document.setDocumentLib(documentDto.getDocumentLib());




            return document;
        }
        return null;

    }
}
