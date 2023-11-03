//package com.example.InternTaskBookStore.controller;
//
//import com.example.InternTaskBookStore.security.JwtService;
//import com.example.InternTaskBookStore.security.data.AuthRequest;
//import com.example.InternTaskBookStore.security.data.AuthResponse;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequiredArgsConstructor
//public class AuthController {
//
//    private final AuthenticationManager authenticationManager;
//
//    private final UserDetailsService userDetailsService;
//
//    private final JwtService jwtService;
//
//    @PostMapping("/login")
//    public AuthResponse login(@RequestBody AuthRequest request){
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        request.getUsername(),
//                        request.getPassword()
//                )
//        );
//        var user  = userDetailsService.loadUserByUsername(request.getUsername());
//        var jwtToken = jwtService.generateToken(user);
//        return new AuthResponse(jwtToken);
//    }
//}
