package crypto.authentication.api;

import crypto.authentication.api.request.JwtRequest;
import crypto.authentication.api.response.JwtResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/authenticate")
public interface AuthenticationApi {

    @PostMapping
    ResponseEntity<JwtResponse> createToken(@RequestBody JwtRequest jwtRequest) throws BadCredentialsException, UsernameNotFoundException;
}
