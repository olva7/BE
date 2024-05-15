package MI.com.example.MI_Project.dto.Model;

import MI.com.example.MI_Project.entities.DemandeEstate;
import MI.com.example.MI_Project.entities.Document;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.UUID;

@Accessors(chain = true)
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class DocumentDemandeDto implements Serializable {
    private Document document;

    private DemandeEstate demandeEstate;
    private UUID idImage;

}
