package pl.tomaszbuga.ultimatestackdeveloper.auth.exceptions;

public class MissingJWTTokenException extends RuntimeException {
    public MissingJWTTokenException() {
        super("JWT Token is missing!");
    }
}
