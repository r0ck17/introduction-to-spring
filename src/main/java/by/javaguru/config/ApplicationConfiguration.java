package by.javaguru.config;

import by.javaguru.util.ConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import java.sql.Connection;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan("by.javaguru")
public class ApplicationConfiguration {

    @Bean
    @Profile("test")
    public Connection connectionTest(@Value("${db.url}") String url,
                                     @Value("${db.username}") String username,
                                     @Value("${db.password}") String password,
                                     @Value("${db.test.schema}") String schema) {
        return ConnectionManager.getConnection(url, username, password, schema);
    }

    @Bean
    @Profile("prod")
    public Connection connectionProd(@Value("${db.url}") String url,
                                     @Value("${db.username}") String username,
                                     @Value("${db.password}") String password,
                                     @Value("${db.prod.schema}") String schema) {
        return ConnectionManager.getConnection(url, username, password, schema);
    }
}
