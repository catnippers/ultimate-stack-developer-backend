package pl.tomaszbuga.ultimatestackdeveloper.auth.exceptions;

public class IncorrectJWTTokenException extends RuntimeException {
    public IncorrectJWTTokenException() {
        super("JWT Token is incorrect!");
    }
}
