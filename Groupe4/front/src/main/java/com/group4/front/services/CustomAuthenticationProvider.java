package com.group4.front.services;

import com.group4.front.common.User;
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
        System.out.println("Entering CustomAuthenticationProvider.authenticate");
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        //BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
        //password = bCryptEncoder.encode(password);

        User user = this.authenticationService.login(name, password);


        if (password.equals(user.getPassword())) {
            System.out.println("Password match as expected.");
            System.out.println("Exiting CustomAuthenticationProvider.authenticate");
            System.out.println("name: " + name);
            return new UsernamePasswordAuthenticationToken(name, password, user.getRoles());
        }
        System.out.println("Password does not match as expected.");

        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
