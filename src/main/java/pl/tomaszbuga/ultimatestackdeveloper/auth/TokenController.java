package pl.tomaszbuga.ultimatestackdeveloper.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pl.tomaszbuga.ultimatestackdeveloper.user.User;
import pl.tomaszbuga.ultimatestackdeveloper.user.UserRepository;

import java.util.Optional;

// todo name it as "PublicController"
@RequiredArgsConstructor
@RestController
public class TokenController {
    private final JwtGenerator jwtGenerator;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    // todo handle these in a service
    @PostMapping("login")
    public ResponseEntity<String> generate(@RequestBody final User user) {
        Optional<User> userOptional = userRepository.findByUsername(user.getUsername());

        // todo throw exception if not present and catch at RestControllerAdvice
        if (userOptional.isPresent()) {
            if (passwordEncoder.matches(user.getPassword(), userOptional.get().getPassword())) {
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .header("Content-Type", "application/json")
                        .body("{\"token\":\"" + jwtGenerator.generate(user) + "\"}");
            }
        }

        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body("Provided credentials are not valid.");
    }

    // todo complete signup logic
    @PutMapping("signup")
    public ResponseEntity<String> signup(@RequestBody final User user) {
        return ResponseEntity.ok("");
    }
}
