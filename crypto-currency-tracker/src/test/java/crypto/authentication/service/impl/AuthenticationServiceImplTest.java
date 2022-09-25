package crypto.authentication.service.impl;

import crypto.authentication.api.request.JwtRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuthenticationServiceImplTest {

    @Mock
    AuthenticationManager authenticationManager;

    @InjectMocks
    AuthenticationServiceImpl authenticationService;

    @Test
    void whenAuthenticateIsCalledBadCredentials_thenThrowBadCredentialsException(){
        Mockito.when(authenticationManager.authenticate(Mockito.any(UsernamePasswordAuthenticationToken.class))).thenThrow(BadCredentialsException.class);

        Exception exception = Assertions.assertThrows(BadCredentialsException.class
                , () -> authenticationService.authenticate(new JwtRequest()));

        assertEquals("Bad credentials", exception.getMessage());
    }
}