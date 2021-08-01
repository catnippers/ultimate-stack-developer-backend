package pl.tomaszbuga.ultimatestackdeveloper.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.tomaszbuga.ultimatestackdeveloper.user.User;
import pl.tomaszbuga.ultimatestackdeveloper.user.UserRepository;

import java.util.Optional;

@RestController
public class TokenController {
    private final JwtGenerator jwtGenerator;
    private final UserRepository userRepository;

    public TokenController(JwtGenerator jwtGenerator,
                           UserRepository userRepository) {
        this.jwtGenerator = jwtGenerator;
        this.userRepository = userRepository;
    }

    // todo handle in service, and use bcryptpassword encoder/decoder instead
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object generate(@RequestBody final User user) {
        Optional<User> userOptional = userRepository.findByUsername(user.getUsername());

        if (userOptional.isPresent()) {
            if (userOptional.get().getPassword().equals(user.getPassword())) {
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
}
