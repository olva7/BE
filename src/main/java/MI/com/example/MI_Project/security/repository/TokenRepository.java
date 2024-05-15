package MI.com.example.MI_Project.security.repository;

import MI.com.example.MI_Project.security.entities.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token,Integer> {
    @Query("""
select t from Token t inner join AppUser  u on t.appUser.idUser = u.idUser
 where u.idUser = :idUser and (t.expired = false or t.revoked = false)
""")
    List<Token> findAllValidTokensByAppUser(Integer idUser);
    Optional<Token> findByTokenName(String token);
}
