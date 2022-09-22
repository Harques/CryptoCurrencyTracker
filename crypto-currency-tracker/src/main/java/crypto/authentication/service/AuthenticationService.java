package crypto.authentication.service;

import crypto.authentication.api.request.JwtRequest;

public interface AuthenticationService {
    void authenticate(JwtRequest jwtRequest) throws Exception;
}
