package com.group4.front.config;

import com.group4.front.services.CustomAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/login","/error").permitAll()
                .antMatchers("/").fullyAuthenticated()
                .antMatchers("/admin/**").hasRole("ADMIN")    // l'accès aux URLs private/** sera restrainte à un utilisateur authentifié
                .and()
                .formLogin()                        // utilisation du mode FormLogin pour l'authentification
             // .loginPage( "/login" )              // Définition d'une page custom pour le login (si non présent authomatiquement généré)
                .loginProcessingUrl( "/login.do" )  // Url à utiliser pour poster l'authenfication, donc l'action dans la page custom de login
                .defaultSuccessUrl( "/" )           // Url par défaut à utiliser en cas d'authentification réussie
                .failureUrl( "/login?err=1" )
                .usernameParameter( "username" )    // Nom du champs pour le username dans la page de login
                .passwordParameter( "password" )    // Nom du champs pour le mot de passe dans la page de login
                .and()
                .exceptionHandling()
                .accessDeniedPage( "/403" )
                .and()
                // Configuration du logout
                .logout()
                .logoutRequestMatcher( new AntPathRequestMatcher( "/logout" ) ) // URL à appeler pour se délogguer
                .logoutSuccessUrl( "/login" )                                   // URL vers laquelle renvoyer lorsqu'on s'est bien déloggué
                .invalidateHttpSession( true )                                  // Invalider la session HTTP
                .and()
                // The session management is used to ensure the user only has one session. This isn't
                // compulsory but can add some extra security to your application.
                .sessionManagement()
                .invalidSessionUrl( "/" )
                .maximumSessions( 1 );
    }

    /**
     * Service d'authentification
     */
    @Autowired
    private CustomAuthenticationProvider authenticationProvider;

    /**
     * Surcharge de la configuration
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void configureGlobal( AuthenticationManagerBuilder auth ) throws Exception
    {
        auth.authenticationProvider(authenticationProvider);
    }
}
