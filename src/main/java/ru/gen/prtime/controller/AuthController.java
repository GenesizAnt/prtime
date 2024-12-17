//package ru.gen.prtime.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.*;
//import ru.gen.prtime.config.AuthenticationRequest;
//import ru.gen.prtime.config.JwtTokenProvider;
//
//@RestController
//@CrossOrigin(origins = "${cors.frontend}")
//@RequestMapping("/api/auth")
//public class AuthController {
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private JwtTokenProvider jwtTokenProvider;
//
//    @PostMapping("/login")
////    public ResponseEntity<?> authenticateUser() {
//    public ResponseEntity<?> authenticateUser(@RequestBody AuthenticationRequest authenticationRequest) {
//
//        System.out.println();
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        authenticationRequest.getUsername(),
//                        authenticationRequest.getPassword()
//                )
//        );
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        String jwt = jwtTokenProvider.createToken(authentication);
//        return ResponseEntity.ok(new AuthenticationResponse(jwt));
//    }
//
//    @GetMapping("/test")
//    public ResponseEntity<?> test() {
//        return ResponseEntity.ok(" you have access now  ");
//    }
//}