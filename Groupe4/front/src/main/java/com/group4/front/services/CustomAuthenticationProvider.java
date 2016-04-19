package com.group4.front.services;

import com.group4.front.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private AuthenticationService authenticationService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        //BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
        //password = bCryptEncoder.encode(password);

        User user = this.authenticationService.login(name, password);

        if (user != null) {
            if (password.equals(user.getPassword())) {
                return new UsernamePasswordAuthenticationToken(name, password, user.getRoles());
            }
        }

        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
