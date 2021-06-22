package pl.tomaszbuga.ultimatestackdeveloper.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;
import pl.tomaszbuga.ultimatestackdeveloper.user.User;
import pl.tomaszbuga.ultimatestackdeveloper.user.UserRepository;

@Component
public class JwtValidator {
    private String secret = "Graphql";
    private final UserRepository userRepository;

    public JwtValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User validate(String token) {
        User user = null;
        Claims body = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();

        String username = body.getSubject();

        if (userRepository.findByUsername(username) != null) {
            user = userRepository.findByUsername(username);
        }

        return user;
    }
}
