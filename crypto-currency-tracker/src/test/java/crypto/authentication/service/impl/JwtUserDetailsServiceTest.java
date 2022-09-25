package crypto.authentication.service.impl;

import crypto.authentication.dao.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JwtUserDetailsServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    JwtUserDetailsService jwtUserDetailsService;

    @Test
    void whenLoadByUsernameIsCalledWithNotFoundUsername_thenThrowUsernameNotFoundException(){
        Exception exception = Assertions.assertThrows(UsernameNotFoundException.class
                , () -> jwtUserDetailsService.loadUserByUsername(""));

        assertEquals("User not found with username: ", exception.getMessage());
    }

}