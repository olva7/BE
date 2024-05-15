package MI.com.example.MI_Project.entities;

import MI.com.example.MI_Project.security.entities.AppRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "privilege")
public class PrivilegeUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_privilege")
    private Integer idPrivilege;
    private String libPrivilege;
    @ManyToMany
    @JoinTable(
            name = "privilege_role",
            joinColumns = {@JoinColumn(name = "id_privilege")},
            inverseJoinColumns={@JoinColumn(name ="id_role")}
    )
    private List<AppRole> roles ;

}
