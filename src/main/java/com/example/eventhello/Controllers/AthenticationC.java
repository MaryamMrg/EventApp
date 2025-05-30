package com.example.eventhello.Controllers;

import com.example.eventhello.Services.AuthenticationS;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AthenticationC {

    private final AuthenticationS authenticationS;

    public AthenticationC(AuthenticationS authenticationS) {
        this.authenticationS = authenticationS;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
   return ResponseEntity.ok(authenticationS.register(request));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
     return ResponseEntity.ok(authenticationS.authenticate(request));
    }
}
