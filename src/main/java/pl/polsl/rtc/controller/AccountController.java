package pl.polsl.rtc.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.test.annotation.Timed;
import org.springframework.web.bind.annotation.*;
import pl.polsl.rtc.security.SecurityConstatns;
import pl.polsl.rtc.security.TokenProvider;
import pl.polsl.rtc.service.dto.ManagedUser;
import pl.polsl.rtc.service.dto.UserJWT;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping(value = "/api")
public class AccountController {


    private TokenProvider tokenProvider;

    private AuthenticationManager authenticationManager;

    public AccountController(TokenProvider tokenProvider, AuthenticationManager authenticationManager) {
        this.tokenProvider = tokenProvider;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping(value = "/login")

    public ResponseEntity<JWTToken> authorize(@Valid @RequestBody UserJWT managedUser) {

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(managedUser.getUsername(), managedUser.getPassword());

        Authentication auth = this.authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(auth);

        String jwt = tokenProvider.generateToken(auth);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(SecurityConstatns.AUTHORIZATION_HEADER, SecurityConstatns.TOKEN_PREFIX + jwt);

        return new ResponseEntity<>(new JWTToken(jwt), httpHeaders, HttpStatus.OK);
    }

    static class JWTToken {

        private String idToken;

        public JWTToken(String idToken) {
            this.idToken = idToken;
        }

        @JsonProperty("id_token")
        public String getIdToken() {
            return idToken;
        }

        public void setIdToken(String idToken) {
            this.idToken = idToken;
        }
    }

//    @RequestMapping("/login")
//    @ResponseStatus(HttpStatus.OK)
//    public Principal user(Principal principal) {
//        return principal;
//    }
}
