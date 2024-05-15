package MI.com.example.MI_Project.security.authentification;

import MI.com.example.MI_Project.security.configuration.JwtService;
import MI.com.example.MI_Project.security.entities.AppRole;
import MI.com.example.MI_Project.security.entities.AppUser;
import MI.com.example.MI_Project.security.entities.Token;
import MI.com.example.MI_Project.security.repository.AppRoleRepository;
import MI.com.example.MI_Project.security.repository.AppUserRepository;
import MI.com.example.MI_Project.security.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final AppUserRepository repository;
    private final TokenRepository tokenRepository;
    private final AppRoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        Optional<AppRole> defaultRoleOptional = roleRepository.findById(1);
        if (defaultRoleOptional.isPresent()) {
            // Si le rôle par défaut existe, récupérez-le
            AppRole defaultRole = defaultRoleOptional.get();
            // Créer un nouvel utilisateur avec le rôle par défaut
            var user = AppUser.builder()
                    .firstname(request.getFirstname())
                    .lastname(request.getLastname())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .role(defaultRole)
                    .build();
            var savedUser = repository.save(user);

            var jwtToken = jwtService.generateToken(user);
            saveUserToken(savedUser, jwtToken);



            saveUserToken(savedUser, jwtToken);
            return AuthenticationResponse.builder()
                    //.accessToken(jwtToken)
                    //.refreshToken(refreshToken)
                    .token(jwtToken)
                    .build();

            // Utiliser l'utilisateur nouvellement créé...
        } else {
            // Si aucun rôle n'est trouvé avec l'ID 1, lancez une exception ou gérez l'erreur d'une autre manière
            throw new IllegalArgumentException("Le rôle par défaut n'a pas été trouvé.");
        }


    }



    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );//user is authenticated
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);

        return AuthenticationResponse.builder()
                //.accessToken(jwtToken)
                //.refreshToken(refreshToken)
                .token(jwtToken)
                .build();
    }
    private void revokeAllUserTokens(AppUser user) {
        var validUserTokens = tokenRepository.findAllValidTokensByAppUser(user.getIdUser());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }

    private void saveUserToken(AppUser user, String jwtToken) {
        var token = Token.builder()
                .appUser(user)
                .tokenName(jwtToken)
                .revoked(false)
                .expired(false)
                .build();
        tokenRepository.save(token);
    }
}
