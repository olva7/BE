package MI.com.example.MI_Project.security.configuration;

import MI.com.example.MI_Project.security.repository.TokenRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    private final TokenRepository tokenRepository;
    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain) throws ServletException, IOException {
        final String authHeader = request.getHeader("Autherazation");
        final String jwt;
        final String userEmail;
        if(authHeader == null ||!authHeader.startsWith("Bearer")){//condition before extractiong
            filterChain.doFilter(request,response);
            return;
        }
        jwt = authHeader.substring(7);//to extract the jwt from the request
        userEmail = jwtService.extractUsername(jwt);  //to extract the userEmail from the jwt token(we need a class caled jwtservice)
        if( userEmail !=null && SecurityContextHolder.getContext().getAuthentication() == null){
            //is user authenticated or not if yes we go just to the controller we don't need to verify and update
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
            var isValid = tokenRepository.findByTokenName(jwt)
                    .map(t -> !t.isExpired() && !t.isRevoked())
                    .orElse(false);
            if (jwtService.isValid(jwt, userDetails) && isValid){
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,null,
                        userDetails.getAuthorities()//if valid do to the dispached servlet(update the security status) , userdetails from the database
                );
                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );// update the security context holder
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request,response);



    }
}
