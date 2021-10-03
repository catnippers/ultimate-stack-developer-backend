package pl.tomaszbuga.ultimatestackdeveloper.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import pl.tomaszbuga.ultimatestackdeveloper.auth.models.JwtAuthenticationToken;
import pl.tomaszbuga.ultimatestackdeveloper.auth.models.JwtUserDetails;
import pl.tomaszbuga.ultimatestackdeveloper.user.User;

import java.util.List;

@RequiredArgsConstructor
@Component
public abstract class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
    private final JwtValidator validator;

    @Override
    protected UserDetails retrieveUser(
            String username,
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) 
            throws AuthenticationException {

        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) usernamePasswordAuthenticationToken;
        String token = jwtAuthenticationToken.getToken();

        User user = validator.validate(token);

        if (user == null) {
            throw new RuntimeException("JWT Token is incorrect");
        }

        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList(user.getRole());

        return new JwtUserDetails(
                user.getUsername(),
                user.getPassword(),
                token,
                grantedAuthorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return (JwtAuthenticationToken.class.isAssignableFrom(aClass));
    }
}
