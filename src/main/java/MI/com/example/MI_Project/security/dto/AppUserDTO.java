package MI.com.example.MI_Project.security.dto;

import MI.com.example.MI_Project.dto.Model.DemandeEstateDto;
import MI.com.example.MI_Project.entities.DemandeEstate;
import MI.com.example.MI_Project.security.entities.AppRole;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class AppUserDTO implements Serializable {
    private Integer idUser;
    private String firstname;
    private String lastname;
    private String usernam;
    private String email;
    private Date dateDeNaissance;
    private Integer phonenumber;
    //private LocalDateTime dateCreation;
    private AppRole role;
    private String password;



}
