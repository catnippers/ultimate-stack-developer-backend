package pl.tomaszbuga.ultimatestackdeveloper.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import pl.tomaszbuga.ultimatestackdeveloper.user.User;

import java.time.ZonedDateTime;
import java.util.Date;

@Component
public class JwtGenerator {

    public String generate(User user) {
        final Date EXP_DATE = Date.from(ZonedDateTime.now().plusMinutes(30).toInstant());

        Claims claims = Jwts.claims()
                .setSubject(user.getUsername())
                .setExpiration(EXP_DATE);

        claims.put("password", String.valueOf(user.getPassword()));
        claims.put("role", user.getRole());

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, "Graphql")
                .compact();
    }
}
