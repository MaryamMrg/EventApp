package com.example.eventhello.Services;

import com.example.eventhello.Controllers.AuthenticationRequest;
import com.example.eventhello.Controllers.AuthenticationResponse;
import com.example.eventhello.Controllers.RegisterRequest;
import com.example.eventhello.Repositories.UserRepository;
import com.example.eventhello.entities.User;
import com.example.eventhello.filter.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationS {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationS(PasswordEncoder passwordEncoder, UserRepository userRepository,
                           JwtService jwtService, AuthenticationManager authenticationManager) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse register(RegisterRequest request) {
        System.out.println("Starting registration for: " + request.getUsername());

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());

        User savedUser = userRepository.save(user);
        System.out.println("User saved with ID: " + savedUser.getId());

        String jwtToken = jwtService.generateToken(savedUser);
        System.out.println("JWT token generated: " + (jwtToken != null ? "Success" : "Failed"));

        return new AuthenticationResponse(jwtToken);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        System.out.println("Starting authentication for: " + request.getUsername());

        try {

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );
            System.out.println("Authentication manager passed");


            User user = userRepository.findByUsername(request.getUsername())
                    .orElseThrow(() -> {
                        System.out.println("User not found: " + request.getUsername());
                        return new RuntimeException("User not found");
                    });
            System.out.println("User found: " + user.getUsername());


            String jwtToken = jwtService.generateToken(user);
            System.out.println("JWT token generated: " + (jwtToken != null ? "Success" : "Failed"));

            if (jwtToken == null) {
                throw new RuntimeException("Failed to generate JWT token");
            }

            AuthenticationResponse response = new AuthenticationResponse(jwtToken);
            System.out.println("Response created: " + (response != null ? "Success" : "Failed"));

            return response;

        } catch (BadCredentialsException e) {
            System.out.println("Bad credentials for user: " + request.getUsername());
            throw e;
        } catch (Exception e) {
            System.out.println("Authentication error: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }
}