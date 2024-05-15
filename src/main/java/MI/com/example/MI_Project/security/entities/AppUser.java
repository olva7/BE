package MI.com.example.MI_Project.security.entities;

import MI.com.example.MI_Project.entities.AgenceImmobiliereMi;
import MI.com.example.MI_Project.entities.DemandeEstate;
import MI.com.example.MI_Project.entities.EstateMi;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.time.LocalDateTime;
import java.util.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idUser")
public class AppUser implements UserDetails {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer idUser;
    private String firstname;
    private String lastname;
    private Integer phonenumber;
    private String usernam;
    @Column(name = "Email", unique = true)
    private String email;
    private Date dateDeNaissance;
    //@Column(name = "date_creation")
    //private LocalDateTime dateCreation;

    /*@PrePersist
    protected void onCreate() {
        dateCreation = LocalDateTime.now();
    }*/
    private String password;

    @Lob
    private byte[] profileImage;

    @OneToMany
    private transient List<Token> tokens;

    @ManyToOne
    @JoinColumn(name = "id_role")

    private AppRole role;
    @OneToOne(mappedBy = "appUser")
    @JoinColumn(name = "id_agence")
    @JsonIgnore
    private AgenceImmobiliereMi agenceImmobiliereMi;
    @OneToMany(mappedBy = "appUser")
    @JsonIgnore
    private List<DemandeEstate> demandeEstateList;
    @OneToMany(mappedBy = "idUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    @JsonIgnore
    private Set<EstateMi> estateMis ;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.getRole()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
