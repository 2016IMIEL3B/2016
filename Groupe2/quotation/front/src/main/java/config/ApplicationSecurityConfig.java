package config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Created by Nico on 09/02/2016.
 */
@Configuration
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    public static String USER_NAME = "toto";
    public static String USER_NAME_ADMIN = "admin";
    public static String PASSWORD = new BCryptPasswordEncoder().encode("toto");

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Active ou déscative le csrl (si désactivé, plus besoin du champ hidden correspond dans la page de login
        //http.csrf().disable();

        http.authorizeRequests().antMatchers("/*").permitAll();
    }

}