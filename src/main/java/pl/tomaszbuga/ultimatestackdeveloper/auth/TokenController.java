package pl.tomaszbuga.ultimatestackdeveloper.auth;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.tomaszbuga.ultimatestackdeveloper.dto.UserDTO;
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
    private final ModelMapper modelMapper;

    // todo handle these in a service
    @PostMapping("login")
    public ResponseEntity<String> generate(@RequestBody final User user) {
        Optional<User> userOptional = userRepository.findByUsername(user.getUsername());

        // todo throw exception if not present and catch at RestControllerAdvice
        // temporarily added password encode method to mock getting encoded password from DB
        if (userOptional.isPresent() && passwordEncoder.matches(user.getPassword(), passwordEncoder.encode(userOptional.get().getPassword()))) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .header("Content-Type", "application/json")
                    .body("{\"token\":\"" + jwtGenerator.generate(user) + "\"}");
        }

        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body("Provided credentials are not valid.");
    }

    // todo complete signup logic
    @PutMapping("signup")
    public ResponseEntity<String> signup(@RequestBody final UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        //user.setRole(""); // todo create roles as enum
        userRepository.save(user);
        return ResponseEntity.ok("");
    }
}
