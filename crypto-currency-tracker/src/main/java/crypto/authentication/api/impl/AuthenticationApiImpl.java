package crypto.authentication.api.impl;

import crypto.authentication.api.AuthenticationApi;
import crypto.authentication.api.request.JwtRequest;
import crypto.authentication.api.response.JwtResponse;
import crypto.authentication.config.JwtTokenUtil;
import crypto.authentication.dao.entity.RoleEntity;
import crypto.authentication.dao.entity.UserEntity;
import crypto.authentication.dao.repository.RoleRepository;
import crypto.authentication.dao.repository.UserRepository;
import crypto.authentication.service.AuthenticationService;
import crypto.authentication.service.impl.JwtUserDetailsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@Api(tags = "Authentication API")
@Tag(name = "Authentication API", description = "Authentication API")
public class AuthenticationApiImpl implements AuthenticationApi {
    private final AuthenticationService authenticationService;
    private final JwtTokenUtil jwtTokenUtil;
    private final JwtUserDetailsService jwtUserDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<?> createToken(JwtRequest jwtRequest) throws Exception {

        authenticationService.authenticate(jwtRequest);

        final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }
}
