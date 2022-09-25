package crypto.authentication.service.impl;

import crypto.authentication.api.request.JwtRequest;
import crypto.authentication.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;

    @Override
    public void authenticate(JwtRequest jwtRequest) throws BadCredentialsException{
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(),jwtRequest.getPassword()));
        }
        catch (BadCredentialsException e){
            throw new BadCredentialsException("INVALID_CREDENTIALS", e);
        }
    }
}
