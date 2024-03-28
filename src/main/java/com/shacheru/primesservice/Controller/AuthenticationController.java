package com.shacheru.primesservice.Controller;

import com.shacheru.primesservice.Model.Customer;
import com.shacheru.primesservice.Service.IAuthenticationService;
import com.shacheru.primesservice.Service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

//@RestController
//public  class AuthenticationController {
//    private TokenService tokenService;
////    private AuthenticationManager authenticationManager;
//    private final IAuthenticationService authenticationService;
////@Autowired
//    public AuthenticationController(IAuthenticationService authenticationService, AuthenticationManager authenticationManager, TokenService tokenService){
//        this.authenticationService = authenticationService;
//        this.authenticationManager = authenticationManager;
//        this.tokenService = tokenService;
//    }
//    @PostMapping("/register")
//
//    public boolean register(@RequestBody Customer customer) {
//
//        try {
//            System.out.print("jhgmn");
//            return authenticationService.register(customer);
//        } catch (IOException e) {
//
//            throw new RuntimeException(e);
//
//        }
//
//    }
//    @PostMapping("/login")
//
//    public String login (@RequestBody Customer customer) {
//        Authentication authentication = authenticationManager.authenticate(
//        new UsernamePasswordAuthenticationToken( customer.getUsername() , customer.getPassword()));
//        return tokenService.generateToken(authentication);
//    }
//    private final AuthenticationManager authenticationManager;
//    public AuthenticationController(AuthenticationManager authenticationManager,IAuthenticationService authenticationService){
//        this.authenticationManager = authenticationManager;
//        this.authenticationService = authenticationService;
//    }
//}

@RestController
public class AuthenticationController {

    private IAuthenticationService authenticationService;

    private AuthenticationManager authenticationManager;

    private TokenService tokenService;

    public AuthenticationController(IAuthenticationService authenticationService,
                                    AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticationService = authenticationService;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping("/register")
    public boolean register(@RequestBody Customer customer) {
        try {
            return authenticationService.register(customer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/login")
    public String login(@RequestBody Customer customer) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(customer.getUsername(), customer.getPassword()));
        return tokenService.generateToken(authentication);
    }
}