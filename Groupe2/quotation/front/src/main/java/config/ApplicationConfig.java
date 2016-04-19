package config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by Nico on 09/02/2016.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"config","controller","vertex","com"})
@EnableJpaRepositories(basePackages = "com")
@EntityScan(basePackages = {"com"})
@Import(value = {ApplicationWebMvc.class})
public class ApplicationConfig extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        //application.banner(Banner.Mode.OFF);
        return application.sources(ApplicationConfig.class);
    }
}