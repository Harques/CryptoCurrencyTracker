package crypto.authentication.service;

import crypto.authentication.api.request.JwtRequest;
import org.springframework.security.authentication.BadCredentialsException;

public interface AuthenticationService {
    void authenticate(JwtRequest jwtRequest) throws BadCredentialsException;
}
