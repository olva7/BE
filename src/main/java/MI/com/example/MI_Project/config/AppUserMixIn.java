package MI.com.example.MI_Project.config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AppUserMixIn {

    // Ignore the authorities collection to prevent serialization
    @JsonIgnore
    abstract Collection<? extends GrantedAuthority> getAuthorities();

    // Ignore the password field to enhance security
    @JsonIgnore
    abstract String getPassword();

    // This ensures the username is included, customize further if needed
    @JsonSerialize
    abstract String getUsername();

    // Additional fields to ignore to prevent recursion or exposure
    @JsonIgnore
    abstract Set<?> getEstateMis();  // Assuming this is the field that can cause recursion

    @JsonIgnore
    abstract List<?> getTokens();  // Assume you do not want to serialize tokens

    // Any other fields you think are sensitive or prone to cause issues can be ignored
    @JsonIgnore
    abstract Integer getIdUser(); // Optionally ignore ID if not needed externally

    @JsonIgnore
    abstract String getEmail(); // Optionally expose based on your security requirements

    // Example of customizing serialization of some user attributes
    // @JsonSerialize(using = CustomSerializer.class)
    // abstract LocalDateTime getDateCreation();
}
