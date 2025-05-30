package com.example.eventhello.Services;

import com.example.eventhello.Controllers.AuthenticationRequest;
import com.example.eventhello.Controllers.AuthenticationResponse;
import com.example.eventhello.Controllers.RegisterRequest;

import com.example.eventhello.Mapper.UserMapper;
import com.example.eventhello.Repositories.UserRepository;
import com.example.eventhello.entities.User;
import com.example.eventhello.filter.JwtService;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationS {

    private  final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationS( PasswordEncoder passwordEncoder,  UserRepository userRepository, JwtService jwtService, AuthenticationManager authenticationManager) {

        this.passwordEncoder = passwordEncoder;

        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse register(RegisterRequest request) {


        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());

//        userRepository.save(user);
//
//        var jwtToken = jwtService.generateToken(user);
//         return new AuthenticationResponse(jwtToken);
//        var user = User
//                .builder()
//                .username(request.getUsername())
//                .password(passwordEncoder.encode(request.getPassword()))
//
//                .build();

   userRepository.save(user);
   var jwtToken = jwtService.generateToken(user);
//   return  AuthenticationResponse.builder()
//           .token(jwtToken).build();
              return new AuthenticationResponse(jwtToken);

    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),request.getPassword()
                )

        );
        var user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
//        return  AuthenticationResponse.builder()
//                .token(jwtToken).build();
        return new AuthenticationResponse(jwtToken);
    }
}
