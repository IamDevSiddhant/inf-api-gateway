package io.flightinfo.api.gateway.controller;


import io.flightinfo.api.gateway.dto.AuthRequestDTO;
import io.flightinfo.api.gateway.service.JWTService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class JWTAuthController {


    private final AuthenticationManager authManager;
    private final JWTService jwtService;

    public JWTAuthController(AuthenticationManager authManager, JWTService jwtService) {
        this.authManager = authManager;
        this.jwtService = jwtService;
    }

    @PostMapping("/jwt")
    public ResponseEntity<?> createAuthToken(@RequestBody AuthRequestDTO authRequest) {

        String token = "";
        Authentication authentication = authManager
                .authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        log.info("Creating JWT Token");
        if (authentication.isAuthenticated()) {
            log.info("user found, user authenticated");
            token=jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("User Not Found");
        }

        return new ResponseEntity<>(token, HttpStatus.OK);
    }

}
