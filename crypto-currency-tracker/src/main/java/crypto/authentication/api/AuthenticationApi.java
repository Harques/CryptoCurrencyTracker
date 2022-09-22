package crypto.authentication.api;

import crypto.authentication.api.request.JwtRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/authenticate")
public interface AuthenticationApi {

    @PostMapping
    public ResponseEntity<?> createToken(@RequestBody JwtRequest jwtRequest) throws Exception;
}
