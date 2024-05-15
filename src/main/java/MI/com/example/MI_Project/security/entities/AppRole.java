package MI.com.example.MI_Project.security.entities;

import MI.com.example.MI_Project.entities.PrivilegeUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Getter
@Setter
@Entity


@Table(name = "roles")
public class AppRole implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    private Integer idRole;

    private String role;
    @OneToMany(mappedBy = "role")
    private Set<AppUser> utilisateurs;
    @ManyToMany(mappedBy = "roles")
    private List<PrivilegeUser> privilegeUsers;

}
