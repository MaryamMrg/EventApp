package com.example.eventhello.Controllers;

import com.example.eventhello.Services.AuthenticationS;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AthenticationC{

    private final AuthenticationS authenticationS;

    public AthenticationC(AuthenticationS authenticationS) {
        this.authenticationS = authenticationS;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        try {
            AuthenticationResponse response = authenticationS.register(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            System.out.println("Registration failed: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        try {
            System.out.println("Authentication attempt for: " + request.getUsername()); // Debug log
            AuthenticationResponse response = authenticationS.authenticate(request);
            System.out.println("Authentication successful"); // Debug log
            return ResponseEntity.ok(response);
        } catch (BadCredentialsException e) {
            System.out.println("Authentication failed: Bad credentials");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (Exception e) {
            System.out.println("Authentication failed: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}