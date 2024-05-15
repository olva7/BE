package MI.com.example.MI_Project.security.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Token {
    @Id
    @GeneratedValue
    private Integer idToken;
    private String tokenName;

    private boolean expired;
    private boolean revoked;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser appUser;

}
