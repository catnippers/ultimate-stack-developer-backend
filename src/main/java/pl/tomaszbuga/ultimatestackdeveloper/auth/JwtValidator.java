package pl.tomaszbuga.ultimatestackdeveloper.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;
import pl.tomaszbuga.ultimatestackdeveloper.user.User;
import pl.tomaszbuga.ultimatestackdeveloper.user.UserRepository;

@Component
public class JwtValidator {
    private static final String secret = "Graphql";
    private final UserRepository userRepository;

    public JwtValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // todo do not return null object, throw exception instead
    public User validate(String token) {
        User user = null;
        Claims body = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();

        String username = body.getSubject();

        // maybe take advantage of ifPresent
        if (userRepository.findByUsername(username).isPresent()) {
            user = userRepository.findByUsername(username).get();
        }

        return user;
    }
}
